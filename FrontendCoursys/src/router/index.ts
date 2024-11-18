import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import CursosPage from '@/views/CursosPage.vue';
import EstudiantesPage from '@/views/EstudiantesPage.vue';
import ProfesoresPage from '@/views/ProfesoresPage.vue';

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
    path: '/cursos',
    name: 'Cursos',
    component: CursosPage
  },
  {
    path: '/estudiantes',
    name: 'Estudiantes',
    component: EstudiantesPage
  },
  {
    path: '/profesores',
    name: 'Profesores',
    component: ProfesoresPage
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
