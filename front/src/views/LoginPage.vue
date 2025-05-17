<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Login</ion-title>
        <ion-buttons slot="end">
          <ion-button router-link="/home">Home</ion-button>
          <ion-button router-link="/menu">Menu</ion-button>
          <ion-button router-link="/login" color="secondary">Login</ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <form id="login-form">
        <ion-item>
          <ion-label position="floating">Email</ion-label>
          <ion-input type="email" required></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Password</ion-label>
          <ion-input type="password" required></ion-input>
        </ion-item>
        <ion-button expand="block" type="submit">Login</ion-button>
        <ion-item>
          <ion-label>Don't have an account?</ion-label>
          <ion-button slot="end" router-link="/register" color="secondary">Register</ion-button>
        </ion-item>
      </form>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonItem, IonLabel, IonInput, IonButton, IonButtons } from '@ionic/vue';
</script>

<style scoped>
#login-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 16px;
}

ion-item {
  margin-bottom: 16px;
}

ion-button {
  margin-top: 12px;
}
</style>
