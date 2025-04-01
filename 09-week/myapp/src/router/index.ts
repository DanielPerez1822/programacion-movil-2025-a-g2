import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import MedicoPage from '../views/MedicoPage.vue';
import EnfermeroPage from '../views/EnfermeroPage.vue'; // Importar EnfermeroPage
import RecepcionistaPage from '../views/RecepcionistaPage.vue'; // Importar RecepcionistaPage
import PacientePage from '../views/PacientePage.vue'; // Importar PacientePage

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/medico',
    name: 'Medico',
    component: MedicoPage
  },
  {
    path: '/enfermero', // Nueva ruta
    name: 'Enfermero',
    component: EnfermeroPage
  },
  {
    path: '/recepcionista', // Nueva ruta
    name: 'Recepcionista',
    component: RecepcionistaPage
  },
  {
    path: '/paciente', // Nueva ruta
    name: 'Paciente',
    component: PacientePage
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;




