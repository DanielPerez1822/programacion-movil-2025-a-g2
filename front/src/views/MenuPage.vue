<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-button fill="clear" @click="goBack">
           <font-awesome-icon :icon="['fas', 'chevron-left']" style="font-size: 24px; color: #fff;" />
          </ion-button>
        </ion-buttons>
        <ion-title class="centered-title">Menu</ion-title>
        <ion-buttons slot="end">
          <ion-button fill="clear" @click="goToCreateProduct">
            <font-awesome-icon :icon="['fas', 'plus']" style="font-size: 24px; color: #fff;" />
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
      <ion-searchbar
        v-model="busqueda"
        placeholder="Buscar producto..."
        show-clear-button="always"
      />
    </ion-header>

    <ion-content :fullscreen="false" class="ion-padding">
      <div class="categoria-tabs">
        <ion-segment v-model="categoriaSeleccionadaId" scrollable>
          <ion-segment-button
            v-for="cat in categorias"
            :key="cat.id"
            :value="String(cat.id)"
          >
            {{ cat.nombreCategoria }}
          </ion-segment-button>
        </ion-segment>
      </div>

      <ion-list v-if="productosFiltrados.length">
        <ion-item-divider color="light">
          <ion-label>
            <strong>
              {{
                categorias.find(c => String(c.id) === categoriaSeleccionadaId)?.nombreCategoria
              }}
            </strong>
          </ion-label>
        </ion-item-divider>

        <ion-item v-for="producto in productosFiltrados" :key="producto.id">
          <ion-label>
            <h2>{{ producto.nombreProducto }}</h2>
            <p>{{ producto.descripcion }}</p>
            <p><strong>${{ producto.precio }}</strong></p>
          </ion-label>

          <div class="cantidad-controls" slot="end">
            <ion-button size="small" @click="decrementCantidad(producto.id)">-</ion-button>
            <span class="cantidad-text">{{ cart.cantidadPorProducto(producto.id) }}</span>
            <ion-button size="small" @click="incrementCantidad(producto.id)">+</ion-button>
          </div>
        </ion-item>
      </ion-list>

      <div v-else class="no-result">
        <ion-label class="ion-text-center">
          <p>No se encontraron productos.</p>
        </ion-label>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonContent, IonHeader, IonPage, IonTitle, IonToolbar,
  IonList, IonItem, IonLabel, IonButton, IonButtons,
  IonItemDivider, IonSegment, IonSegmentButton, IonSearchbar
} from '@ionic/vue';
import { ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useCartStore } from '@/store/cart';
import { ProductoService } from '@/services/ProductoService';
import { CategoriaService } from '@/services/CategoriaService';
import { Producto } from '@/models/Producto';
import { Categoria } from '@/models/Categoria';

// Font Awesome
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faChevronLeft, faPlus } from '@fortawesome/free-solid-svg-icons';
library.add(faChevronLeft, faPlus);

const productos = ref<Producto[]>([]);
const categorias = ref<Categoria[]>([]);
const categoriaSeleccionadaId = ref<string>('');
const busqueda = ref<string>('');
const cart = useCartStore();

const productosPorCategoria = computed(() => {
  const map: Record<number, Producto[]> = {};
  for (const producto of productos.value) {
    const catId = producto.categoriaId?.id;
    if (!catId) continue;
    if (!map[catId]) map[catId] = [];
    map[catId].push(producto);
  }
  return map;
});

const productosFiltrados = computed(() => {
  const texto = busqueda.value.trim().toLowerCase();
  const productosCat = productosPorCategoria.value[Number(categoriaSeleccionadaId.value)] || [];
  if (!texto) return productosCat;
  return productosCat.filter(p =>
    p.nombreProducto.toLowerCase().includes(texto) ||
    p.descripcion.toLowerCase().includes(texto)
  );
});

const fetchCategorias = async () => {
  try {
    const catRes = await CategoriaService.getAll();
    if (catRes?.status) {
      categorias.value = catRes.data.map((cat: any) =>
        new Categoria(cat.id, cat.nombreCategoria)
      );
      if (categorias.value.length > 0) {
        categoriaSeleccionadaId.value = String(categorias.value[0].id);
      }
    }
  } catch {
    categorias.value = [];
  }
};

const fetchProductos = async () => {
  try {
    const prodRes = await ProductoService.getAll();
    if (prodRes?.status) {
      productos.value = prodRes.data.map((product: any) => {
        const categoria = new Categoria(
          product.categoriaId.id,
          product.categoriaId.nombreCategoria
        );
        return new Producto(
          product.id,
          product.nombreProducto,
          product.precio,
          product.descripcion,
          product.status,
          categoria
        );
      });
    }
  } catch {
    productos.value = [];
  }
};

onMounted(async () => {
  await fetchCategorias();
  await fetchProductos();
});

const router = useRouter();

function goToCreateProduct() {
  router.push('/productos/crear');
}

function incrementCantidad(productoId: number) {
  cart.agregar(productoId);
}

function decrementCantidad(productoId: number) {
  cart.quitar(productoId);
}

function goBack() {
  router.push('/home');
}
</script>

<style scoped>
.fab-round {
  --border-radius: 50%;
  width: 44px;
  height: 44px;
  min-width: 44px;
  min-height: 44px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.18);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0;
  background: #222 !important;
  color: #fff !important;
  border: none;
}
.fab-round .fa-icon {
  font-size: 20px;
  color: #fff;
}
.back-fab {
  --border-radius: 50%;
  width: 44px;
  height: 44px;
  min-width: 44px;
  min-height: 44px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.18);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0;
  background: #222 !important;
  color: #fff !important;
  border: none;
}
.back-icon {
  font-size: 20px;
  color: #fff;
}
.categoria-tabs {
  margin-bottom: 16px;
  margin-top: 8px;
}
ion-item {
  margin-bottom: 12px;
}
.cantidad-controls {
  display: flex;
  align-items: center;
  gap: 8px;
}
.cantidad-text {
  min-width: 20px;
  text-align: center;
}
.no-result {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 40vh;
  color: #888;
  text-align: center;
}
.centered-title {
  text-align: center;
  width: 100%;
  left: 0;
  right: 0;
  margin: 0 auto;
  position: absolute;
  pointer-events: none;
}
</style>
