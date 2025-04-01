<template>
  <LayoutCentroMedico>
    <div class="recepcionista-page">
      <div class="card">
        <h1>Información del Recepcionista</h1>
        <Persona 
          :nombre="nombre" 
          :apellido="apellido" 
          :edad="edad" 
          :correo="correo" 
        />
        <ul>
          <li><strong>Horario Laboral:</strong> {{ horarioLaboral }}</li>
          <li><strong>Extensión Telefónica:</strong> {{ extensionTelefonica }}</li>
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

const nombre = 'Carlos';
const apellido = 'López';
const edad = 28;
const correo = 'carlos.lopez@hospital.com';
const horarioLaboral = '8:00 AM - 4:00 PM';
const extensionTelefonica = '1234';
</script>

<style scoped>
.recepcionista-page {
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
