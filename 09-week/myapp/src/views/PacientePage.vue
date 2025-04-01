<template>
  <LayoutCentroMedico>
    <div class="paciente-page">
      <div class="card">
        <h1>Información del Paciente</h1>
        <Persona 
          :nombre="nombre" 
          :apellido="apellido" 
          :edad="edad" 
          :correo="correo" 
        />
        <ul>
          <li><strong>Número de Historia Clínica:</strong> {{ numeroHistoriaClinica }}</li>
          <li><strong>Tipo de Afiliación:</strong> {{ tipoAfiliacion }}</li>
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

const nombre = 'María';
const apellido = 'Rodríguez';
const edad = 35;
const correo = 'maria.rodriguez@hospital.com';
const numeroHistoriaClinica = 'HC-987654';
const tipoAfiliacion = 'EPS';
</script>

<style scoped>
.paciente-page {
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
