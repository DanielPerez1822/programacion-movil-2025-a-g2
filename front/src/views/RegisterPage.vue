<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Registro</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <ion-input v-model="username" label="Usuario" required></ion-input>
      <ion-input v-model="email" label="Email" required type="email"></ion-input>
      <ion-input v-model="password" label="Contraseña" type="password" required></ion-input>
      <ion-button expand="block" @click="register">Registrarse</ion-button>
      <ion-text color="success">{{ message }}</ion-text>
    </ion-content>
  </ion-page>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const username = ref('')
const email = ref('')
const password = ref('')
const message = ref('')

const register = async () => {
  try {
    await axios.post('http://localhost:9000/auth/signup', {
      username: username.value,
      email: email.value,
      password: password.value
    })
    message.value = 'Registro exitoso. Revisa tu correo para el código de verificación.'
  } catch (error) {
    message.value = error.response?.data || 'Error al registrar.'
  }
}
</script>
