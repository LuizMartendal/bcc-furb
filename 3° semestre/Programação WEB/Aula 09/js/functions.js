//document.getElementById('mensagem').innerHTML = 'Conteúdo inicial!';

x = 5;

//var x = 5;
//let x = 5;
const y = 7;
//var y = 'Marcos';

console.log(x+' '+(x+y));
x = 'Marcos';
console.log(x+' '+(x+y));
x = '5';
console.log(x+' '+(x+y));

x = 7;
if (x == y) {
    console.log('x e y são iguais!');
}
x = '7';
if (x == y) {
    console.log('x e y são iguais!');
}
if (x === y) {
    console.log('x e y são iguais!');
} else {
    console.log('x e y são diferentes!');
}
/*
a == b
a != b
a > >= < <= b
a === b
a !== b
&& - AND
|| - OR
! - NOT
*/

a = 5;
a++; //a = a + 1; a += 1;
a--; //a = a - 1; a -= 1;
a *= 5; // a = a * 5;

function mostraAlert2(pMensagem) {
    alert(pMensagem);
    console.log('O valor de pMensagem é '+pMensagem);
}