var palavras = ['sagaz', 'âmago', 'mexer, êxito', 'termo',
                'nobre', 'senso', 'afeto', 'algoz', 'plena',
                'mutua', 'fazer', 'vigor', 'ideia', 'poder',
                'moral', 'honra', 'sonho', 'anexo', 'casal']

var palavra = palavras[parseInt(Math.random() * 19)]
var tentativas = 1;

function enterPress() {
    console.log(palavra);
    const input = document.getElementById('input')
    if (input.onkeyup.arguments[0].key === 'Enter') {
        verificar(input)
        input.value = ''
    }
}

async function verificar(input) {   
    const valor = input.value.toLowerCase()
    if (valor === palavra) {
        for (i = 0; i < valor.length; i++) {
            criarQuadrado(valor.charAt(i) , i)
        }
        acertou() 
        await new Promise(r => setTimeout(() => r(), 3000))
        location.reload()
    } else {
        if (tentativas == 6) {
            alert('Game over! A palavra do dia é: ' + palavra)
            location.reload()
        } else {
            for (i = 0; i < 5; i++) {
                criarQuadrado(valor.charAt(i) , i)
            } 
            tentativas++
        }
    }
}

function criarQuadrado(char, i) {
    if (char === '') {
        char = '-'
    }
    const novo = document.createElement('div')
    novo.innerHTML = char.toUpperCase()
    let cor = 'green'
    if (palavra.includes(char) && char != palavra.charAt(i)) {
        cor = 'yellow'
    } 
    if (!palavra.includes(char)) {
        cor = 'red'
    }
    novo.style.backgroundColor = cor
    document.getElementById('flexBox').appendChild(novo)
}

function acertou() {
    if (tentativas >= 4) {
        alert(`Caramba cara... ${tentativas} tentativas para achar a palavra? ...`)
    } else if (tentativas > 1) {
        alert(`Parabéns! Você adivinhou a palavra com apenas ${tentativas} tentativas.`)
    } else {
        alert(`Você é uma máquina!! Uma lenda! Conseguiu adivinhar a palavra de primeira! Cagão...`)
    }    
}