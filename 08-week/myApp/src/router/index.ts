import { createRouter, createWebHistory } from '@ionic/vue-router';
import PersonaForm from "../components/Persona/PersonaForm.vue";


// const routes: Array<RouteRecordRaw> = [
//   {
//     path: '/',
//     redirect: '/home'
//   },
//   {
//     path: '/home',
//     name: 'Home',
//     component: HomePage
//   }
// ]
const routes = [
  { path: "/", redirect: "/persona" }, // Redirige a PersonaForm por defecto
  { path: "/persona", component: PersonaForm, props: { tipoUsuario: "cliente" } }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router




