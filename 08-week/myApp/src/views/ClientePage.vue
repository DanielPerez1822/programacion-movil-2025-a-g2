<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Cliente</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <div id="container">
        <strong>Formulario de Cliente</strong>
        <p>Por favor, completa los datos del cliente.</p>
        <!-- Uso del componente PersonaForm -->
        <PersonaForm :initialData="clienteData" @guardar="handleClienteSubmit" />
    </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
// import PersonaForm from '../components/Persona/PersonaForm.vue'; // Asegúrate de que esta ruta sea correcta

import PersonaForm from '@/components/Persona/PeronaForm.vue'; // Asegúrate de que esta ruta sea correcta

// Datos iniciales del cliente
const clienteData = {
  nombre: '',
  apellido: '',
  documento: '',
  fechaNacimiento: '',
  direccion: '',
  telefono: '',
  correo: '',
};

// Manejo del evento submit
function handleClienteSubmit(data: any) {
  console.log('Cliente Data:', data);
  // Aquí puedes manejar los datos enviados desde PersonaForm
}
</script>