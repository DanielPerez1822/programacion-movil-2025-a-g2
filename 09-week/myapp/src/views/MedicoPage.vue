<template>
  <LayoutCentroMedico>
    <div class="medico-page">
      <div class="card">
        <h1>Información del Médico</h1>
        <Persona 
          :nombre="nombre" 
          :apellido="apellido" 
          :edad="edad" 
          :correo="correo" 
        />
        <ul>
          <li><strong>Especialidad:</strong> {{ especialidad }}</li>
          <li><strong>Número de Licencia Médica:</strong> {{ numeroLicencia }}</li>
        </ul>
        <Crud /> <!-- Agregar el componente Crud -->
      </div>
    </div>
  </LayoutCentroMedico>
</template>

<script setup lang="ts">
import LayoutCentroMedico from '@/components/LayoutCentroMedico.vue';
import Persona from '@/components/Persona.vue';
import Crud from '@/components/Crud.vue'; // Importar el componente Crud

const nombre = 'Juan';
const apellido = 'Pérez';
const edad = 45;
const correo = 'juan.perez@hospital.com';
const especialidad = 'Cardiología';
const numeroLicencia = 'CMP-123456';
</script>

<style scoped>
.medico-page {
  font-family: Arial, sans-serif;
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.card {
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 20px;
  width: 100%;
  max-width: 500px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.card h1 {
  color: #0078D4;
  margin-bottom: 20px;
}

.card ul {
  list-style-type: none;
  padding: 0;
  margin-top: 20px;
  color: #333;
}

.card li {
  margin-bottom: 10px;
}
</style>
