var palavras = ['sagaz', 'âmago', 'mexer, êxito', 'termo',
                'nobre', 'senso', 'afeto', 'algoz', 'plena',
                'mutua', 'fazer', 'vigor', 'ideia', 'poder',
                'moral', 'honra', 'sonho', 'anexo', 'casal']

var palavra = palavras[parseInt(Math.random() * 19)]

function verificar() {
    const input = document.getElementById('input')
    input.addEventListener('keyup', ({key}) => {
        if (key === 'Enter') {
            if (input.value === palavra) {
                console.log(input.value);
            } else {
                console.log(palavra);
            }
        }
    })
}