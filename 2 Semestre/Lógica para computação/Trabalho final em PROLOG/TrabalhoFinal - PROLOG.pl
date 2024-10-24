%a) Criar um conjunto de fatos que contemple as informações do Quadro 1
% e faça a distinção entre sexo dos acadêmicos (homem e mulher).
homem(magaiver).
homem(arnold).
homem(will).

mulher(katy).
mulher(patricia).
mulher(deisi).

aluno(katy, logica, 6.5, 80, morestudy).
aluno(patricia, logica, 10 ,100, bestacademy).
aluno(deisi, logica,9.5,100,nenhuma).
aluno(magaiver, logica, 8, 80, bestacademy).
aluno(arnold, logica, 7,100, morestudy).
aluno(will, logica, 5,75,nenhuma).

aluno(katy, programacao, 7.5,90,morestudy).
aluno(patricia, programacao, 10,100,bestacademy).
aluno(deisi, programacao, 10,100,nenhuma).
aluno(magaiver, programacao, 8, 90, bestacademy).
aluno(arnold, programacao, 7,100, morestudy).
aluno(will, programacao, 5,80,nenhuma).

aluno(katy, estatistica, 7,100,morestudy).
aluno(patricia, estatistica, 10,90,bestacademy).
aluno(deisi, estatistica, 9,100,nenhuma).
aluno(magaiver, estatistica, 7, 90, bestacademy).
aluno(arnold, estatistica, 7.5,100, morestudy).
aluno(will, estatistica, 6,80,nenhuma).

aluno(katy, empreendedorismo, 6,85,morestudy).
aluno(patricia, empreendedorismo, 9.5,100,bestacademy).
aluno(deisi, empreendedorismo, 8.5,90,nenhuma).
aluno(magaiver, empreendedorismo, 9, 90, bestacademy).
aluno(arnold, empreendedorismo, 8,100, morestudy).
aluno(will, empreendedorismo, 9,75,nenhuma).

bolsaSemBolsaEstudos(Bolsa) :- (Bolsa = nenhuma).
mediaSemBolsaEstudos(Nota) :- (Nota >= 6).
frequenciaSemBolsaEstudos(Frequencia) :- (Frequencia >= 75).
aprovadoSemBolsaEstudos(Nota, Frequencia, Bolsa) :- (bolsaSemBolsaEstudos(Bolsa), mediaSemBolsaEstudos(Nota), frequenciaSemBolsaEstudos(Frequencia)).
reprovadoSemBolsaEstudos(Nota, Frequencia, Bolsa) :- (bolsaSemBolsaEstudos(Bolsa), (not(mediaSemBolsaEstudos(Nota)) ; not(frequenciaSemBolsaEstudos(Frequencia)))).

bolsaIsMoreStudy(Bolsa) :- (Bolsa = morestudy).
mediaBolsaMS(Nota) :- (Nota >= 7).
frequenciaBolsaMS(Frequencia) :- (Frequencia >= 80).
aprovadoMoreStudy(Nota, Frequencia, Bolsa) :- (bolsaIsMoreStudy(Bolsa), mediaBolsaMS(Nota), frequenciaBolsaMS(Frequencia)).
reprovadoMoreStudy(Nota, Frequencia, Bolsa) :- (bolsaIsMoreStudy(Bolsa), (not(mediaBolsaMS(Nota)) ; not(frequenciaBolsaMS(Frequencia)))).

bolsaIsBestAcademy(Bolsa) :- (Bolsa = bestacademy).
mediaBolsaBA(Nota) :- (Nota >= 8).
frequenciaBolsaBA(Frequencia) :- (Frequencia >= 90).
aprovadoBestAcademy(Nota, Frequencia, Bolsa) :- (bolsaIsBestAcademy(Bolsa), mediaBolsaBA(Nota), frequenciaBolsaBA(Frequencia)).
reprovadoBestAcademy(Nota, Frequencia, Bolsa) :- (bolsaIsBestAcademy(Bolsa), (not(mediaBolsaBA(Nota)) ; not(frequenciaBolsaBA(Frequencia)))).

% filtrar resultados repetidos setof(X, predicado(X), Resultado).

% b) Criar um conjunto de regras para as seguintes situações:

% (R1) Identificar alunos aprovados.
alunosAprovados(Nome, Disciplina) :- (homem(Nome), aluno(Nome, Disciplina, Nota, Frequencia, Bolsa), ((aprovadoSemBolsaEstudos(Nota, Frequencia, Bolsa)) ; (aprovadoMoreStudy(Nota, Frequencia, Bolsa)) ; (aprovadoBestAcademy(Nota, Frequencia, Bolsa)))).

% (R2) Identificar alunas aprovadas.
alunasAprovadas(Nome, Disciplina) :- (mulher(Nome), aluno(Nome, Disciplina, Nota, Frequencia, Bolsa), ((aprovadoSemBolsaEstudos(Nota, Frequencia, Bolsa)) ; (aprovadoMoreStudy(Nota, Frequencia, Bolsa)) ; (aprovadoBestAcademy(Nota, Frequencia, Bolsa)))).


%(R3) Identificar alunos que irão perder o benefício da bolsa de estudos.
elesPerderamBolsaDeEstudos(Nome, Bolsa) :- (homem(Nome), aluno(Nome, _Disciplina, Nota, Frequencia, Bolsa), ((reprovadoBestAcademy(Nota, Frequencia, Bolsa)) ; (reprovadoMoreStudy(Nota, Frequencia, Bolsa)))).
alunosQuePerderamBolsaDeEstudos(Nome, Bolsa) :- setof(Nome, elesPerderamBolsaDeEstudos(Nome, Bolsa), Nome).

% (R4) Identificar alunas que irão perder o benefício da bolsa de estudos.
elasPerderamBolsaDeEstudos(Nome, Bolsa) :- (mulher(Nome), aluno(Nome, _Disciplina, Nota, Frequencia, Bolsa), ((reprovadoBestAcademy(Nota, Frequencia, Bolsa)) ; (reprovadoMoreStudy(Nota, Frequencia, Bolsa)))).
alunasQuePerderamBolsaDeEstudos(Nome, Bolsa) :- setof(Nome, elasPerderamBolsaDeEstudos(Nome, Bolsa), Nome).

% (R5) Identificar alunos sem bolsa de estudo.
alunosSemBolsaDeEstudos(Nome) :- (homem(Nome), aluno(Nome, _Disciplina, _Nota, _Frequencia, Bolsa), bolsaSemBolsaEstudos(Bolsa)).

% (R6) Identificar alunas sem bolsa de estudo.
alunasSemBolsaDeEstudos(Nome) :- (mulher(Nome), aluno(Nome, _Disciplina, _Nota, _Frequencia, Bolsa), bolsaSemBolsaEstudos(Bolsa)).

% c) Fazer as seguintes consultas no sistema PROLOG e apresentar e discutir os resultados obtidos.

% ▪ Quais são os alunos aprovados na disciplina de Lógica (para ambas as
% situações de bolsa)? O resultado deve retornar o nome dos acadêmicos
% aprovados.
alunosAprovadosEmLogica(Nome) :- (alunosAprovados(Nome,Disciplina), Disciplina = logica).

% ▪ Quais são as alunas aprovadas na disciplina de Estatística (para
% ambas as situações de bolsa)? O resultado deve retornar o nome dos
% acadêmicos aprovados.
alunasAprovadasEmEstatistica(Nome) :- (alunasAprovadas(Nome, Disciplina), Disciplina = estatistica).

% ▪ Qual é o nome dos acadêmicos (alunos e alunas) que perderam o
% direito de renovação da bolsa de estudos? O resultado deve apresentar
% o nome do aluno(a) e a respectiva bolsa de estudo vigente.
alunosEalunasQuePerderamBolsaDeEstudos(Nome, Bolsa) :- alunosQuePerderamBolsaDeEstudos(Nome, Bolsa) ; alunasQuePerderamBolsaDeEstudos(Nome, Bolsa).

% ▪ Qual é o nome dos acadêmicos (alunos e alunas) que não possuem bolsa
% de estudo? O resultado deve apresentar o nome do aluno(a)
alunosEalunasSemBolsaDeEstudos(Nome) :- setof(Nome,(alunosSemBolsaDeEstudos(Nome) ; alunasSemBolsaDeEstudos(Nome)), Nome).
