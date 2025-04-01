// import { createRouter, createWebHistory } from '@ionic/vue-router';
// import PersonaForm from "../components/Persona/PersonaForm.vue";

// const routes = [
//   { path: "/", redirect: "/persona" }, // Redirige a PersonaForm por defecto
//   { path: "/persona", component: PersonaForm, props: { tipoUsuario: "cliente" } }
// ];

import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import ClientePage from '@/views/ClientePage.vue';

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
    path: '/cliente',
    name: 'Cliente',
    component: ClientePage
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
