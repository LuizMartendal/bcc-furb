var images = ['../imgs/cadastrar.png', '../imgs/home.png', '../imgs/logged.png', '../imgs/login.png', '../imgs/logo.png']
var index = 0

function logout() {
    localStorage.removeItem('login')
    this.isLogged()
}

setInterval(() => {
    const img = document.getElementById('home-images')
    if (index == 5) {
        index = 0;
    }
    img.src = images[index]
    index++
}, 5000)

function isLogged() {
    document.getElementById('this').style.backgroundColor = 'lightgray'
    const login = document.getElementById('login-page')
    const logout = document.getElementById('logout-page')
    const user = document.getElementById('user')
    
    if (localStorage.getItem('login') != null) {
        let image = document.createElement('img')
        image.src = '../imgs/logged.png'
        image.style.height = '6vh'
        image.style.backgroundColor = 'white'
        image.style.borderRadius = '1vw'
        image.style.padding = '1vh'
        image.style.marginLeft = '1vw'

        let a = document.createElement('a')
        a.href = '../cadastrar/index.html'
        a.style.textDecoration = 'none'
        a.appendChild(image)

        user.innerHTML = localStorage.getItem('login')
        user.appendChild(a)

        login.hidden = true
        logout.hidden = false
    } else {
        user.innerHTML = 'Usuário não autenticado'

        login.hidden = false
        logout.hidden = true
    }
}

