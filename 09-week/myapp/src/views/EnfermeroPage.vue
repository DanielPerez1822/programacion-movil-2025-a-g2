<template>
  <LayoutCentroMedico>
    <div class="enfermero-page">
      <div class="card">
        <h1>Información del Enfermero</h1>
        <Persona 
          :nombre="nombre" 
          :apellido="apellido" 
          :edad="edad" 
          :correo="correo" 
        />
        <ul>
          <li><strong>Turno Asignado:</strong> {{ turnoAsignado }}</li>
          <li><strong>Área de Atención:</strong> {{ areaAtencion }}</li>
        </ul>
        <Crud /> <!-- Componente CRUD -->
      </div>
    </div>
  </LayoutCentroMedico>
</template>

<script setup lang="ts">
import LayoutCentroMedico from '@/components/LayoutCentroMedico.vue';
import Persona from '@/components/Persona.vue';
import Crud from '@/components/Crud.vue'; // Importar el componente Crud

const nombre = 'Ana';
const apellido = 'Gómez';
const edad = 30;
const correo = 'ana.gomez@hospital.com';
const turnoAsignado = 'Nocturno';
const areaAtencion = 'Urgencias';
</script>

<style scoped>
.enfermero-page {
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
