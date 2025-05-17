<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-button fill="clear" @click="goBack">
            <font-awesome-icon :icon="['fas', 'chevron-left']" style="font-size: 24px; color: #fff;" />
          </ion-button>
        </ion-buttons>

        <ion-title class="ion-text-center">Resumen del Pedido</ion-title>

        <ion-buttons slot="end">
          <ion-button fill="clear" @click="goToMenu">
            <font-awesome-icon :icon="['fas', 'plus']" style="font-size: 24px; color: #fff;" />
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>

    <ion-content>
      <ion-list>
        <ion-item v-for="producto in productosEnCarrito" :key="producto.id">
          <ion-label>
              <h2>{{ producto.nombreProducto }}</h2>
            <p>Precio: ${{ producto.precio }}</p>
            <p>Cantidad: {{ cart.cantidadPorProducto(producto.id) }}</p>
            <p>Fecha: {{ new Date().toLocaleDateString() }}</p>
          </ion-label>
        </ion-item>
      </ion-list>

      <div v-if="productosEnCarrito.length === 0" class="ion-text-center ion-padding">
        <p>No hay productos en el carrito.</p>
      </div>
    </ion-content>

   <ion-footer>
      <ion-toolbar class="ion-text-center">
        <ion-button 
          class="hacer-pedido-btn" 
          @click="hacerPedido" 
          :disabled="productosEnCarrito.length === 0">
          Hacer Pedido 
        </ion-button> 
      </ion-toolbar>
    </ion-footer>
  </ion-page>
</template>


<script setup lang="ts">
import {
  IonPage, IonHeader, IonToolbar, IonTitle,
  IonContent, IonList, IonItem, IonLabel, IonButtons, IonButton
} from '@ionic/vue';
import { ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useCartStore } from '@/store/cart';
import { ProductoService } from '@/services/ProductoService';
import { Producto } from '@/models/Producto';
import { PedidoService } from '@/services/PedidoService'; 

// FontAwesome
import { library } from '@fortawesome/fontawesome-svg-core';
import { faChevronLeft, faPlus } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { Pedido } from '@/models/Pedido';
library.add(faChevronLeft, faPlus);

const productos = ref<Producto[]>([]);
const cart = useCartStore();
const router = useRouter();
const loading = ref(false);

onMounted(async () => {
  const res = await ProductoService.getAll();
  productos.value = res.data;
});

const productosEnCarrito = computed(() => {
  return productos.value.filter(p => cart.cantidadPorProducto(p.id) > 0);
});

const crearPedido = (): Pedido => {
  return {
    id: null,
    fecha: new Date().toISOString(),
    estado: true,
    administradorId: null, // O asigna el administrador si lo tienes
    empleadoId: null,      // O asigna el empleado si lo tienes
    productos: productosEnCarrito.value.map(producto => ({ id: producto.id }))
  } as any;
};

// ...existing code...

const hacerPedido = async () => {
  if (productosEnCarrito.value.length === 0) {
    console.log("El carrito está vacío.");
    return;
  }

  const pedido = crearPedido();
  loading.value = true;

  try {
    await PedidoService.create(pedido);
    alert("¡Pedido realizado con éxito!");
    if (typeof cart.limpiarCarrito === 'function') {
      cart.limpiarCarrito();
    }
    router.push({ path: '/' });
  } catch (error: any) {
    let msg = "Hubo un error al realizar el pedido. Por favor, inténtalo de nuevo.";
    if (error?.response?.data?.message) {
      msg += "\n" + error.response.data.message;
    }
    console.error("Error al realizar el pedido:", error);
    alert(msg);
  } finally {
    loading.value = false;
  }
};

// Agrega estas funciones para la navegación
function goBack() {
  router.back();
}

function goToMenu() {
  router.push({ path: '/menu' });
}

function reloadPage() {
  router.replace("/home"); // Use Vue Router navigation instead of reloading the page
}

// ...existing code...
</script>

<style scoped>
.hacer-pedido-btn {
  --background: #fff;
  --color: #000;
  border: 1.5px;
  border-radius: 8px;
  padding: 0 18px;
  font-weight: 500;
  min-width: unset;
  width: auto;
}

font-awesome-icon {
  font-size: 20px;
  color: #000;
}
</style>
