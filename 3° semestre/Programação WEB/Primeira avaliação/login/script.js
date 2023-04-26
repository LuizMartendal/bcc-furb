function autenticar() {
    const login = document.getElementById('login')
    const password = document.getElementById('password')

    if (login.value === '' || password.value === '') {
        alert('Informe os dados de autenticação!')
    } else {
        localStorage.setItem('login', login.value)
    }
}

setInterval(isLogged(), 1000)

function isLogged() {
    const login = document.getElementById('login-page')
    const logout = document.getElementById('logout-page')
    
    if (localStorage.getItem('login') != null) {
        location.href = '/Primeira%20avaliação/home/index.html'
    }
}