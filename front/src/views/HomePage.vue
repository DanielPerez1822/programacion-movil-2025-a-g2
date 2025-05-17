<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Home</ion-title>
        <ion-buttons slot="end">
          <ion-button router-link="/home">Home</ion-button>
          <ion-button router-link="/menu">Menu</ion-button>
          <ion-button router-link="/login" color="secondary">Login</ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Home</ion-title>
        </ion-toolbar>
      </ion-header>

      <div class="menu-container">
        <img src="/assets/Logo.png" alt="Logo" style="width: 200px; height: 200px;" />
        <ion-button router-link="/menu" class="menu-button" fill="clear">
          <div class="button-content">
            <font-awesome-icon :icon="['fas', 'burger']" class="fa-icon" />
            <span>Producto</span>
          </div>
        </ion-button>

        <ion-button router-link="/order" class="menu-button" fill="clear">
          <div class="button-content">
            <font-awesome-icon :icon="['fas', 'print']" class="fa-icon" />
            <span>Pedido</span>
          </div>
        </ion-button>

        <ion-button router-link="/history" class="menu-button" fill="clear">
          <div class="button-content">
            <font-awesome-icon :icon="['far', 'clipboard']" class="fa-icon" />
            <span>Historial</span>
          </div>
        </ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButton, IonButtons } from '@ionic/vue';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faBurger, faPrint } from '@fortawesome/free-solid-svg-icons';
import { faClipboard } from '@fortawesome/free-regular-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faBurger, faPrint, faClipboard);
</script>

<style scoped>
.menu-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 70vh;
}

.menu-button {
  margin-bottom: 16px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 20px;
  padding: 18px 36px;
  color: black;
  font-weight: bold;
  width: 260px;
  font-size: 1.4rem;
}

.button-content {
  display: flex;
  align-items: center;
  gap: 16px; /* Esto sí asegura separación */
}

.fa-icon {
  font-size: 2rem;
  color: black;
}
</style>
