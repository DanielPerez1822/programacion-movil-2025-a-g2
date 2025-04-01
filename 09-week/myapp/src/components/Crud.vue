<template>
  <div class="crud">
    <h2>Gestión CRUD</h2>
    <div class="buttons">
      <button @click="agregar">Agregar</button>
      <button @click="modificar">Modificar</button>
      <button @click="eliminar">Eliminar</button>
      <button @click="consultar">Consultar</button>
    </div>
  </div>
</template>

<script setup lang="ts">
const agregar = () => {
  alert('Función Agregar ejecutada');
};

const modificar = () => {
  alert('Función Modificar ejecutada');
};

const eliminar = () => {
  alert('Función Eliminar ejecutada');
};

const consultar = () => {
  alert('Función Consultar ejecutada');
};
</script>

<style scoped>
.crud {
  font-family: Arial, sans-serif;
  text-align: center;
  margin: 20px;
}

.crud h2 {
  color: #0078D4;
  margin-bottom: 20px;
}

.buttons {
  display: flex;
  justify-content: center;
  gap: 10px;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  background-color: #0078D4;
  color: white;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #005a9e;
}
</style>
