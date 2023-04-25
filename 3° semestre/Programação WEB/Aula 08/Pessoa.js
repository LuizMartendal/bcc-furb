class Pessoa {
    constructor(pNome, pDtNascimento) {
        this.nome = pNome
        this.dtNascimento = new Date(pDtNascimento)
    }

    getNmPessoa() {
        return this.nome
    }

    getIdade() {
        return new Date().getFullYear() - this.dtNascimento.getFullYear()
    }

    getDtNascimento() {
        return this.dtNascimento
    }
}

class Aluno extends Pessoa {
    constructor(aNome, aDtNascimento, aCurso) {
        super(aNome, aDtNascimento)
        this.curso = aCurso
    }

    getNmCurso() {
        return this.curso
    }
}

class Professor extends Pessoa {
    constructor(pNome, pDtNascimento, pDepto) {
        super(oNome, pDtNascimento)
        this.depto = pDepto
    }

    getNmDepto() {
        return this.depto
    }
}