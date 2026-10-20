import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import ProtocolosView from '../views/ProtocolosView.vue'
import SessoesView from '../views/SessoesView.vue'

const routes = [
  { path: '/login', name: 'Login', component: LoginView, meta: { isPublic: true } },
  { path: '/protocolos', name: 'Protocolos', component: ProtocolosView },
  { path: '/sessoes', name: 'Sessoes', component: SessoesView },
  { path: '/', redirect: '/protocolos' }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const sessao = localStorage.getItem('legisup_sessao')
  
  if (!to.meta.isPublic && !sessao) {
    next('/login')
  } else if (to.path === '/login' && sessao) {
    next('/protocolos')
  } else {
    next()
  }
})

export default router