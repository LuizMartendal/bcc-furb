function autenticar() {
    const login = document.getElementById('login')
    const password = document.getElementById('password')

    if (login.value === '' || password.value === '') {
        alert('Informe os dados de autenticação!')
    } else {
        localStorage.setItem('login', login.value)
    }
}

function isLogged() {
    document.getElementById('login-page').style.backgroundColor = 'lightgray'
    
    if (localStorage.getItem('login') != null) {
        location.href = '../home/index.html'
    }
}