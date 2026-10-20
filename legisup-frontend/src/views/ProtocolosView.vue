<script setup>
import { ref, computed, onMounted } from 'vue'
import Sidebar from '../components/layout/Sidebar.vue'
import { api } from '../services/api'

const protocolos = ref([])
const loading = ref(true)
const searchQuery = ref('')
const selectedStatus = ref('')
const showModal = ref(false)

const novoProtocolo = ref({
  numeroProtocolo: '',
  tipo: 'Projeto de Lei',
  autor: '',
  ementa: '',
  status: 'Em Tramitação'
})

const carregarProtocolos = async () => {
  loading.value = true
  try {
    const res = await api.get('/protocolos')
    if (res.ok) protocolos.value = await res.json()
  } catch (e) {
    console.error(e)
  } finally {
    loading.value = false
  }
}

const salvarProtocolo = async () => {
  if (!novoProtocolo.value.numeroProtocolo || !novoProtocolo.value.autor || !novoProtocolo.value.ementa) {
    alert('Preencha todos os campos.')
    return
  }
  try {
    const res = await api.post('/protocolos', novoProtocolo.value)
    if (res.ok) {
      await carregarProtocolos()
      showModal.value = false
      novoProtocolo.value = { numeroProtocolo: '', tipo: 'Projeto de Lei', autor: '', ementa: '', status: 'Em Tramitação' }
    }
  } catch (e) {
    console.error(e)
  }
}

const filteredProtocolos = computed(() => {
  return protocolos.value.filter(item => {
    const matchesSearch = item.numeroProtocolo.toLowerCase().includes(searchQuery.value.toLowerCase()) ||
                          item.ementa.toLowerCase().includes(searchQuery.value.toLowerCase()) ||
                          item.autor.toLowerCase().includes(searchQuery.value.toLowerCase())
    const matchesStatus = selectedStatus.value === '' || item.status === selectedStatus.value
    return matchesSearch && matchesStatus
  })
})

onMounted(carregarProtocolos)
</script>

<template>
  <div class="min-h-screen bg-slate-50 text-slate-800 flex">
    <Sidebar />
    
    <main class="flex-1 flex flex-col min-w-0">
      <header class="h-16 bg-white border-b flex items-center justify-between px-6">
        <h2 class="text-lg font-bold text-slate-800">Módulo de Protocolo Legislativo</h2>
        <button @click="showModal = true" class="bg-blue-600 hover:bg-blue-700 text-white text-sm font-semibold px-4 py-2 rounded-lg transition">+ Novo Protocolo</button>
      </header>

      <div class="p-6 space-y-6">
        <div class="bg-white rounded-xl border shadow-sm overflow-hidden">
          <div class="p-4 border-b flex gap-3 bg-slate-50/50">
            <input v-model="searchQuery" type="text" placeholder="Buscar por número, ementa ou autor..." class="w-80 px-3 py-2 border rounded-lg text-sm outline-none" />
            <select v-model="selectedStatus" class="px-3 py-2 border rounded-lg text-sm outline-none">
              <option value="">Todos os Status</option>
              <option value="Em Tramitação">Em Tramitação</option>
              <option value="Aprovado">Aprovado</option>
            </select>
          </div>

          <table class="w-full text-left border-collapse">
            <thead>
              <tr class="border-b bg-slate-100/70 text-xs font-semibold uppercase text-slate-600">
                <th class="py-3 px-4">Número</th>
                <th class="py-3 px-4">Tipo</th>
                <th class="py-3 px-4">Autor</th>
                <th class="py-3 px-4">Ementa</th>
                <th class="py-3 px-4">Status</th>
              </tr>
            </thead>
            <tbody class="divide-y text-sm">
              <tr v-for="item in filteredProtocolos" :key="item.id" class="hover:bg-slate-50">
                <td class="py-3.5 px-4 font-bold text-blue-600">{{ item.numeroProtocolo }}</td>
                <td class="py-3.5 px-4">{{ item.tipo }}</td>
                <td class="py-3.5 px-4 font-medium">{{ item.autor }}</td>
                <td class="py-3.5 px-4 max-w-md truncate">{{ item.ementa }}</td>
                <td class="py-3.5 px-4"><span class="px-2.5 py-1 rounded-full text-xs font-semibold bg-blue-100 text-blue-800">{{ item.status }}</span></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </main>

    <!-- Modal Novo Protocolo -->
    <div v-if="showModal" class="fixed inset-0 bg-slate-900/50 backdrop-blur-sm flex items-center justify-center p-4 z-50">
      <div class="bg-white rounded-2xl max-w-lg w-full p-6 space-y-4">
        <h3 class="font-bold text-lg">Novo Protocolo Legislativo</h3>
        <input v-model="novoProtocolo.numeroProtocolo" type="text" placeholder="Número (Ex: PL 105/2026)" class="w-full px-3 py-2 border rounded-lg text-sm outline-none" />
        <input v-model="novoProtocolo.autor" type="text" placeholder="Autor" class="w-full px-3 py-2 border rounded-lg text-sm outline-none" />
        <textarea v-model="novoProtocolo.ementa" placeholder="Ementa" class="w-full px-3 py-2 border rounded-lg text-sm outline-none"></textarea>
        <div class="flex justify-end gap-2 pt-2 border-t">
          <button @click="showModal = false" class="px-4 py-2 text-sm text-slate-600">Cancelar</button>
          <button @click="salvarProtocolo" class="px-4 py-2 text-sm bg-blue-600 text-white rounded-lg">Salvar</button>
        </div>
      </div>
    </div>
  </div>
</template>