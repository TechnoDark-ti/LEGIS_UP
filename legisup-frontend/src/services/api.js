const API_URL = 'http://localhost:8080/api'

export const getAuthHeaders = () => {
  const sessao = localStorage.getItem('legisup_sessao')
  if (!sessao) return { 'Content-Type': 'application/json' }
  const { token } = JSON.parse(sessao)
  return {
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${token}`
  }
}

export const api = {
  async post(endpoint, body) {
    const res = await fetch(`${API_URL}${endpoint}`, {
      method: 'POST',
      headers: getAuthHeaders(),
      body: JSON.stringify(body)
    })
    return res
  },

  async get(endpoint) {
    const res = await fetch(`${API_URL}${endpoint}`, {
      headers: getAuthHeaders()
    })
    return res
  }
}