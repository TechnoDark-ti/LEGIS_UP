<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { api } from '../services/api'

const router = useRouter()
const loginForm = ref({ login: '', senha: '' })
const loginErro = ref('')
const loginCarregando = ref(false)

const fazerLogin = async () => {
  loginErro.value = ''
  loginCarregando.value = true

  try {
    const res = await api.post('/auth/login', loginForm.value)
    if (res.ok) {
      const data = await res.json()
      localStorage.setItem('legisup_sessao', JSON.stringify(data))
      router.push('/protocolos')
    } else {
      loginErro.value = 'Usuário ou senha inválidos.'
    }
  } catch (error) {
    loginErro.value = 'Erro ao conectar ao servidor.'
  } finally {
    loginCarregando.value = false
  }
}
</script>

<template>
  <div class="min-h-screen bg-slate-900 flex items-center justify-center p-4">
    <div class="bg-white rounded-2xl shadow-2xl w-full max-w-md p-8 border border-slate-100">
      <div class="text-center mb-8">
        <div class="w-12 h-12 bg-blue-600 rounded-2xl mx-auto flex items-center justify-center font-black text-white text-2xl mb-3 shadow-lg shadow-blue-500/30">L</div>
        <h1 class="text-2xl font-black text-slate-900 tracking-tight">LEGIS_UP</h1>
        <p class="text-xs text-slate-500 mt-1">Portal do Processo Legislativo Eletrônico</p>
      </div>

      <form @submit.prevent="fazerLogin" class="space-y-4">
        <div v-if="loginErro" class="p-3 bg-red-50 border border-red-200 rounded-xl text-xs font-semibold text-red-600 text-center">
          {{ loginErro }}
        </div>

        <div>
          <label class="block text-xs font-bold text-slate-600 uppercase mb-1">Usuário / Login</label>
          <input v-model="loginForm.login" type="text" required placeholder="Ex: admin" class="w-full px-4 py-2.5 bg-slate-50 border rounded-xl text-sm outline-none focus:ring-2 focus:ring-blue-500" />
        </div>

        <div>
          <label class="block text-xs font-bold text-slate-600 uppercase mb-1">Senha</label>
          <input v-model="loginForm.senha" type="password" required placeholder="••••••••" class="w-full px-4 py-2.5 bg-slate-50 border rounded-xl text-sm outline-none focus:ring-2 focus:ring-blue-500" />
        </div>

        <button type="submit" :disabled="loginCarregando" class="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 rounded-xl text-sm shadow-lg transition disabled:opacity-50">
          {{ loginCarregando ? 'Autenticando...' : 'Entrar no Sistema' }}
        </button>
      </form>
    </div>
  </div>
</template>