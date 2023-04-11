function changeColor() {
    let footer = document.getElementById('footer');
    let header = document.getElementById('header');
    if (header.style.backgroundColor == 'lightblue' || footer.style.backgroundColor == 'lightblue') {
        header.style.backgroundColor = 'lightgreen';
        header.style.color = 'blue';
        footer.style.backgroundColor = 'lightgreen';
        footer.style.color = 'blue';
    } else {
        header.style.backgroundColor = 'lightblue';
        header.style.color = 'green';
        footer.style.backgroundColor = 'lightblue';
        footer.style.color = 'green';
    }
}

function addClass(value) {
    const element = document.getElementById(value);
    element.classList.addClass(value);
}

function deleteClass(value) {
    const element = document.getElementsByClassName(value);
    element.classList.deleteClass(value);
}

function toggleClass(value) {
    const element = document.getElementsByClassName(value);
    element.classList.toggleClass(value);
}

function hideElement(value) {
    document.getElementById(value).style.display = "none";
}

function reload() {
    location.reload();
}

function criarParagrafo(value) {
    const novo = document.createElement('p');
    novo.innerHTML = 'Novo parágrafo';
    document.getElementById(value).appendChild(novo);
}

function setHeader(id) {
    let msg = document.getElementById(id);
    let header = document.getElementById('header');
    header.innerText = msg.value;
}