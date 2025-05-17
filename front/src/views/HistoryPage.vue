<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-button fill="clear" @click="goBack">
            <font-awesome-icon :icon="['fas', 'chevron-left']" style="font-size: 24px; color: #fff;" />
          </ion-button>
        </ion-buttons>
        <ion-title class="ion-text-center">Historal de Ordenes</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <div v-if="orders.length">
        <div
          v-for="order in orders"
          :key="order.id"
        >
          <div
            v-for="detalle in order.detalles"
            :key="detalle.id"
            class="ticket-box"
          >
            <div class="ticket-title">
              Pedido # {{ detalle.id < 10 ? '0' + detalle.id : detalle.id }}
            </div>
            <div class="ticket-date">
              Fecha: {{ formatDate(order.date) }}
            </div>
            <div class="ticket-section">
              <span class="ticket-section-title">Pedido:</span>
              <div class="ticket-products">
                <div class="ticket-product-row">
                  <span>
                    {{ detalle.cantidad }} {{ detalle.productoNombre }}
                  </span>
                  <span>
                    ${{ formatCurrency(detalle.subtotal) }}
                  </span>
                </div>
              </div>
              <div class="ticket-total-row">
                <span>Total:</span>
                <span class="ticket-total-amount">${{ formatCurrency(detalle.subtotal) }}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div v-else>
        <p>No orders found.</p>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonContent, IonHeader, IonPage, IonTitle, IonToolbar,
  IonList, IonItem, IonLabel, IonButton, IonButtons, IonImg
} from '@ionic/vue';
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

// FontAwesome
import { library } from '@fortawesome/fontawesome-svg-core';
import { faChevronLeft } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
library.add(faChevronLeft);

import { FacturasService } from '@/services/FacturaService';
import { DetalleFacturaService } from '@/services/DetalleFactura';

const router = useRouter();

const goBack = () => {
  if (window.history.length > 1) {
    router.back();
  } else {
    router.replace('/home'); // Ruta de fallback si no hay historial
  }
};

const orders = ref([]);

const loadOrdersWithDetalles = async () => {
  // Obtener facturas del backend
  const facturasRes = await FacturasService.getAll();
  const facturas = facturasRes.data || [];
  // Obtener todos los detalles de factura una sola vez
  const detallesRes = await DetalleFacturaService.getAll();
  const detallesAll = detallesRes.data || [];

  // Para cada factura, obtener detalles y agregarlos
  const ordersWithDetalles = await Promise.all(facturas.map(async (factura: any) => {
    // Filtrar detalles de esta factura
    let detalles = detallesAll.filter((d: any) => d.factura?.id === factura.id);

    // Mapear detalles para extraer nombre del producto correctamente
    detalles = detalles.map((d: any) => {
      let productoNombre = d.productoNombre;
      // Si no existe productoNombre, intenta extraerlo del pedido
      if (!productoNombre && d.factura?.pedido?.productos?.length > 0) {
        productoNombre = d.factura.pedido.productos[0].nombreProducto;
      }
      return {
        ...d,
        productoNombre: productoNombre || 'Producto'
      };
    });

    return {
      id: factura.id,
      date: factura.fecha,
      total: factura.total,
      detalles
    };
  }));
  orders.value = ordersWithDetalles;
};

function formatDate(dateStr: string) {
  if (!dateStr) return '';
  const date = new Date(dateStr);
  const day = date.getDate().toString().padStart(2, '0');
  const month = (date.getMonth() + 1).toString().padStart(2, '0');
  const year = date.getFullYear().toString().slice(-2);
  const hours = date.getHours().toString().padStart(2, '0');
  const minutes = date.getMinutes().toString().padStart(2, '0');
  return `${day}/${month}/${year} - ${hours}:${minutes}`;
}

function formatCurrency(value: number) {
  return value?.toLocaleString('es-CO', { minimumFractionDigits: 0 });
}

onMounted(() => {
  loadOrdersWithDetalles();
});
</script>

<style scoped>
.ticket-box {
  background: #e0e0e0;
  border-radius: 14px;
  margin-bottom: 22px;
  padding: 18px 28px 18px 28px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.07);
  border: none;
  max-width: 420px;
  margin-left: auto;
  margin-right: auto;
}

.ticket-title {
  font-size: 2rem;
  font-weight: bold;
  text-align: center;
  margin-bottom: 4px;
}

.ticket-date {
  font-size: 1.1rem;
  text-align: center;
  margin-bottom: 14px;
}

.ticket-section {
  margin-top: 10px;
}

.ticket-section-title {
  font-weight: bold;
  font-size: 1.1rem;
  margin-bottom: 6px;
  display: block;
}

.ticket-products {
  margin-bottom: 8px;
}

.ticket-product-row {
  display: flex;
  justify-content: space-between;
  font-size: 1.15rem;
  margin-bottom: 2px;
}

.ticket-total-row {
  display: flex;
  justify-content: space-between;
  font-weight: bold;
  font-size: 1.25rem;
  margin-top: 10px;
}

.ticket-total-amount {
  color: #000;
}

p {
  text-align: center;
  color: #8c8c8c;
}

font-awesome-icon {
  font-size: 20px;
  color: #000;
}
</style>
