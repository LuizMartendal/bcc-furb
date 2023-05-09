class Pessoa {
    constructor(pNome, pDtNasc) {
        this.nmPessoa = pNome;
        this.dtNasc = new Date(pDtNasc);
    }

    getNmPessoa() {
        return this.nmPessoa;
    }
    getIdade() {
        var hoje = new Date();
        return hoje.getFullYear() - this.dtNasc.getFullYear();
    }
}

class Aluno extends Pessoa {
    constructor(pNome, pDtNasc, pCurso) {
        super(pNome,pDtNasc);
        this.nmCurso = pCurso;
    }
    getNmCurso() {
        return this.nmCurso;
    }
}

class Professor extends Pessoa {
    constructor(pNome, pDtNasc, pDepto) {
        super(pNome,pDtNasc);
        this.nmDepto = pDepto;
    }
    getNmDepto() {
        return this.nmDepto;
    }
}