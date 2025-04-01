<template>
  <LayoutCentroMedico>
    <div id="container">
      <strong>Bienvenido a la plataforma de Gestión de Personal Médico.</strong>
      <p>Empieza a gestionar el personal médico de manera eficiente.</p>
      <div class="buttons">
        <button @click="goToMedicoPage">Ir a Médicos</button>
        <button @click="goToEnfermeroPage">Ir a Enfermeros</button>
        <button @click="goToPacientePage">Ir a Pacientes</button>
        <button @click="goToRecepcionistaPage">Ir a Recepcionistas</button>
      </div>
    </div>
  </LayoutCentroMedico>
</template>

<script setup lang="ts">
import LayoutCentroMedico from '@/components/LayoutCentroMedico.vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const goToMedicoPage = () => {
  router.push('/medico');
};

const goToEnfermeroPage = () => {
  router.push('/enfermero');
};

const goToPacientePage = () => {
  router.push('/paciente');
};

const goToRecepcionistaPage = () => {
  router.push('/recepcionista');
};
</script>

<style scoped>
#container {
  text-align: center;
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  transform: translateY(-50%);
}

#container strong {
  font-size: 20px;
  line-height: 26px;
}

#container p {
  font-size: 16px;
  line-height: 22px;
  color: #8c8c8c;
  margin: 0;
}

.buttons {
  margin-top: 20px;
  display: flex;
  flex-wrap: wrap;
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
