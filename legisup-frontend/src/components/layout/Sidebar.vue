<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const usuario = ref({ login: '', perfil: '' })

onMounted(() => {
  const sessao = localStorage.getItem('legisup_sessao')
  if (sessao) {
    usuario.value = JSON.parse(sessao)
  }
})

const fazerLogout = () => {
  localStorage.removeItem('legisup_sessao')
  router.push('/login')
}
</script>

<template>
  <aside class="w-64 bg-slate-900 text-slate-300 flex flex-col justify-between p-4 hidden md:flex shrink-0 min-h-screen">
    <div>
      <div class="flex items-center gap-3 px-2 py-4 border-b border-slate-800">
        <div class="w-9 h-9 bg-blue-600 rounded-xl flex items-center justify-center font-extrabold text-white text-lg">L</div>
        <div>
          <h1 class="font-bold text-white text-base leading-tight tracking-wide">LEGIS_UP</h1>
          <p class="text-xs text-slate-400">Gestão Legislativa</p>
        </div>
      </div>

      <nav class="mt-6 space-y-1.5">
        <router-link 
          to="/protocolos" 
          active-class="bg-blue-600 text-white shadow-sm"
          class="flex items-center gap-3 px-3 py-2.5 rounded-lg hover:bg-slate-800 text-slate-400 font-medium text-sm transition"
        >
          Protocolo & Projetos
        </router-link>

        <router-link 
          to="/sessoes" 
          active-class="bg-blue-600 text-white shadow-sm"
          class="flex items-center gap-3 px-3 py-2.5 rounded-lg hover:bg-slate-800 text-slate-400 font-medium text-sm transition"
        >
          Sessões & Votação
        </router-link>
      </nav>
    </div>

    <div class="p-3 bg-slate-800/60 rounded-xl border border-slate-800 space-y-2">
      <div>
        <p class="text-[10px] uppercase font-bold tracking-wider text-slate-400">Sessão Ativa</p>
        <p class="text-sm font-semibold text-white mt-0.5">{{ usuario.login }}</p>
        <span class="inline-block mt-1 px-2 py-0.5 text-[10px] font-extrabold rounded bg-blue-500/20 text-blue-300 border border-blue-500/30 uppercase">
          {{ usuario.perfil }}
        </span>
      </div>
      <button 
        @click="fazerLogout" 
        class="w-full text-left text-xs font-semibold text-red-400 hover:text-red-300 pt-2 border-t border-slate-700 transition"
      >
        Terminar Sessão →
      </button>
    </div>
  </aside>
</template>