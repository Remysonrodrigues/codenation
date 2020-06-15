var answer = require('./answer.json');
var sha1 = require('js-sha1');

let { cifrado, numero_casas, decifrado, resumo_criptografico } = answer;

cifrado = cifrado.toLowerCase();

let v = [];

for (i = 0; i < cifrado.length; i++) {
    if (cifrado.charCodeAt(i) >= 97 && cifrado.charCodeAt(i) <= 122){
        let c = cifrado.charCodeAt(i) - numero_casas;
        if (c < 97) {
            v[i] = (cifrado.charCodeAt(i) + 26) - numero_casas;
        } else {
            v[i] = c;
        }
    } else {
        v[i] = cifrado.charCodeAt(i);
    }
}

decifrado = v.map((c, i) => String.fromCharCode(c) ).toString().replace(/,/g, '');

resumo_criptografico = sha1.hex(decifrado);

answer.decifrado = decifrado;
answer.resumo_criptografico = resumo_criptografico;

console.log(answer);
