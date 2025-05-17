<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-button fill="clear" @click="goBack">
            <font-awesome-icon :icon="['fas', 'chevron-left']" style="font-size: 24px; color: #fff;" />
          </ion-button>
        </ion-buttons>
        <ion-title class="ion-text-center">{{ isEditing ? "Editar Producto" : "Nuevo Producto" }}</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <form @submit.prevent="submitForm">
        <ion-list>
          <ion-item>
            <ion-label position="stacked">Nombre</ion-label>
            <ion-input v-model="product.nombreProducto" required />
          </ion-item>
          <ion-item>
            <ion-label position="stacked">Precio</ion-label>
            <ion-input type="number" v-model.number="product.precio" required />
          </ion-item>
          <ion-item>
            <ion-label position="stacked">Descripción</ion-label>
            <ion-textarea v-model="product.descripcion" required />
          </ion-item>
          <ion-item>
            <ion-label position="stacked">Categoría</ion-label>
            <ion-select v-model="product.categoriaId.id" interface="popover" placeholder="Selecciona una categoría" required>
              <ion-select-option v-for="cat in categorias" :key="cat.id" :value="cat.id">
                {{ cat.nombreCategoria }}
              </ion-select-option>
            </ion-select>
          </ion-item>
          <ion-item>
            <ion-label position="stacked">Activo</ion-label>
            <ion-toggle v-model="product.status" />
          </ion-item>
        </ion-list>
        <ion-button expand="block" type="submit" color="primary">Guardar</ion-button>
        <ion-button expand="block" color="medium" @click="cancel" type="button">Cancelar</ion-button>
        <div v-if="errorMessage" style="color:red; margin-top:10px;">{{ errorMessage }}</div>
      </form>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import {
  IonContent, IonHeader, IonPage, IonTitle, IonToolbar,
  IonList, IonItem, IonLabel, IonInput, IonTextarea,
  IonButton, IonButtons, IonSelect, IonSelectOption, IonToggle
} from '@ionic/vue';

import { ProductoService } from '@/services/ProductoService';
import { CategoriaService } from '@/services/CategoriaService';
import { Producto } from '@/models/Producto';
import { Categoria } from '@/models/Categoria';

import { library } from '@fortawesome/fontawesome-svg-core';
import { faChevronLeft, faPlus } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

// Agregamos los íconos a la librería
library.add(faChevronLeft, faPlus);

// Registramos el componente para usarlo en el template
defineExpose({
  components: {
    FontAwesomeIcon
  }
});

const router = useRouter();
const route = useRoute();
const isEditing = ref(false);

const product = ref<Producto>({
  id: 0,
  nombreProducto: "",
  precio: 0,
  descripcion: "",
  status: true,
  categoriaId: {} as Categoria,
});
const categorias = ref<Categoria[]>([]);
const errorMessage = ref("");

const loadProduct = async (id: number) => {
  try {
    const response = await ProductoService.getById(id);
    product.value = response.data;
  } catch (error) {
    console.error("Error al cargar el producto:", error);
  }
};

const loadCategorias = async () => {
  try {
    const response = await CategoriaService.getAll();
    categorias.value = response.data;
  } catch (error) {
    console.error("Error al cargar las categorías:", error);
  }
};

const submitForm = async () => {
  try {
    if (!product.value.nombreProducto || !product.value.precio || !product.value.categoriaId.id) {
      errorMessage.value = "Por favor, completa todos los campos obligatorios.";
      return;
    }

    const producto = {
      id: product.value.id,
      nombreProducto: product.value.nombreProducto,
      precio: product.value.precio,
      descripcion: product.value.descripcion,
      status: product.value.status,
      categoriaId: {
        id: product.value.categoriaId.id,
        nombreCategoria: product.value.categoriaId.nombreCategoria
      }
    };

    if (isEditing.value) {
      await ProductoService.update(product.value.id, producto);
    } else {
      await ProductoService.create(producto);
    }
    reloadPage();
  } catch (error: any) {
    console.error("Error al guardar el producto:", error);
    if (error.response) {
      errorMessage.value = error.response.data?.message || "Error interno del servidor.";
    } else {
      errorMessage.value = "Error al guardar el producto. Por favor, inténtalo de nuevo.";
    }
  }
};

const cancel = () => {
  router.replace("/menu");
};

const reloadPage = () => {
  router.replace("/menu");
};

const goBack = () => {
  router.replace("/menu");
};

onMounted(() => {
  loadCategorias();
  const productId = route.params.id;
  if (!isEditing.value) {
    product.value.id = null;
  }
});
</script>

<style scoped>
ion-item {
  margin-bottom: 12px;
}

font-awesome-icon {
  color: #000; /* Ajusta según el fondo */
  font-size: 20px;
}
</style>
