<template>
  <ion-page>
    <ion-header>
      <ion-toolbar color="primary">
        <ion-title>Gestión de Personal Médico</ion-title>
        <ion-buttons slot="end">
          <ion-button @click="goToHome">Inicio</ion-button>
          <ion-button @click="goToMedico">Médicos</ion-button>
          <ion-button @click="goToEnfermero">Enfermeros</ion-button>
          <ion-button @click="goToRecepcionista">Recepcionistas</ion-button>
          <ion-button @click="goToPaciente">Pacientes</ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <slot />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButtons, IonButton } from '@ionic/vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const goToHome = () => {
  router.push('/home');
};

const goToMedico = () => {
  router.push('/medico');
};

const goToEnfermero = () => {
  router.push('/enfermero');
};

const goToRecepcionista = () => {
  router.push('/recepcionista');
};

const goToPaciente = () => {
  router.push('/paciente');
};
</script>

<style scoped>
ion-toolbar {
  --background: #0078D4;
  --color: white;
}

ion-title {
  color: white; /* Cambiar el color de la letra a blanco */
}

ion-button {
  --color: white; /* Cambiar el color del texto de los botones a blanco */
}
</style>
