<template>
  <div class="persona">
    <ul>
      <li><strong>Nombre:</strong> {{ nombre }}</li>
      <li><strong>Apellido:</strong> {{ apellido }}</li>
      <li><strong>Edad:</strong> {{ edad }}</li>
      <li><strong>Correo Electrónico:</strong> {{ correo }}</li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';

defineProps({
  nombre: {
    type: String,
    required: true
  },
  apellido: {
    type: String,
    required: true
  },
  edad: {
    type: Number,
    required: true
  },
  correo: {
    type: String,
    required: true
  }
});
</script>

<style scoped>
.persona {
  font-family: Arial, sans-serif;
  margin: 20px;
  padding: 0;
}

.persona ul {
  list-style-type: none;
  padding: 0;
  color: black; /* Cambiar el color de la información a negro */
}

.persona li {
  margin-bottom: 10px;
  font-size: 16px;
  line-height: 24px;
}
</style>
