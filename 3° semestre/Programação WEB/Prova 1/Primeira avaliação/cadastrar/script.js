function logout() {
    localStorage.removeItem('login')
    this.isLogged()
}

function isLogged() {
    document.getElementById('this').style.backgroundColor = 'lightgray'
    if (localStorage.getItem('login') == null) {
        location.href = '../login/index.html'
    } else {
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
    }
}

function cadastrar() {
    const nome = document.getElementById('nome').value
    const sobrenome = document.getElementById('sobrenome').value
    const email = document.getElementById('email').value
    const data = document.getElementById('date').value
    const masculino = document.getElementById('masculino')
    const feminino = document.getElementById('feminino')
    const sexo = masculino.checked == true ? masculino.value : feminino.value
    const robo = document.getElementById('robo')
    if (nome == null | sobrenome == null || email == null || data == null || sexo == null || robo == null) {
        alert('Insira todos os dados!')
    } else {
        alert(`Nome: ${nome}, Sobrenome: ${sobrenome}, Email: ${email}, Data de nascimento: ${data}, Sexo: ${sexo}`)
    }
}

function custom() {
    const selected = document.getElementById('custom-page').value
    if (selected === 'custom') {
        const header = document.getElementById('header')
        header.style.backgroundColor = 'rgba(12, 12, 12, 0.895)'
        const main = document.getElementById('main')
        main.style.backgroundColor = 'black'
        const footer = document.getElementById('footer')
        footer.style.backgroundColor = 'rgba(12, 12, 12, 0.895)'
        const form = document.getElementById('form')
        form.style.backgroundColor = 'rgba(12, 12, 12, 0.895)'
        const body = document.getElementsByTagName('body')[0]
        body.style.fontFamily = 'roboto'
        body.style.fontStyle = 'italic'
    } else {
        const header = document.getElementById('header')
        header.style.backgroundColor = 'black'
        const main = document.getElementById('main')
        main.style.backgroundColor = 'rgba(12, 12, 12, 0.895)'
        const footer = document.getElementById('footer')
        footer.style.backgroundColor = 'black'
        const form = document.getElementById('form')
        form.style.backgroundColor = 'black'
        const body = document.getElementsByTagName('body')[0]
        body.style.fontFamily = 'arial'
        body.style.fontStyle = 'normal'
    }
}

