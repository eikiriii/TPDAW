function calcular() {
    const valor = document.getElementById("display").value;
    const operacion = document.getElementById("operacion").value;
    let resultado = "";
    const numero = parseInt(valor);
    switch (operacion) {
        case "primo":
            resultado = esPrimo(numero) ? "Sí es primo" : "No es primo";
            break;
        case "par":
            resultado = (numero % 2 === 0) ? "Sí es par" : "No es par";
            break;
        case "factorial":
            resultado = factorial(numero);
            break;
        case "SumaP":
            resultado = sumaPares(numero);
            break;
        case "SumaI":
            resultado = sumaImpares(numero);
            break;
        default:
            resultado = "Operación no válida";
    }
    document.getElementById("resultado").value = resultado;
    }

    function esPrimo(n) {
    if (n <= 1) return false;
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return false;
    }
    return true;
}

function factorial(n) {
    if (n < 0) return "No existe factorial negativo";
    let res = 1;
    for (let i = 2; i <= n; i++) {
        res *= i;
    }
    return res;
}

function sumaPares(n) {
    let suma = 0;
    for (let i = 2; i <= n; i += 2) {
        suma += i;
    }
    return suma;
}

function sumaImpares(n) {
    let suma = 0;
    for (let i = 1; i <= n; i += 2) {
        suma += i;
    }
    return suma;
}

function limpiar() {
    document.getElementById("display").value = "";
    document.getElementById("resultado").value = "";
}
