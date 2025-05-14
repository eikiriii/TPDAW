function agregar(digito){
    display = document.getElementById("display").value;
    digitos = display + digito;
    document.getElementById("display").value = digitos;

}

function limpiar(){
    document.getElementById("display").value = "";
}

function calcularResultado(){
    expresion = document.getElementById("display").value;
    resultado = eval(expresion);
    document.getElementById("display").value = resultado;
    return resultado; 
}

function raiz(){
    valor = calcularResultado();
    resultado = Math.sqrt(valor);
    document.getElementById("display").value = resultado;
}

function logaritmo(){
    valor = calcularResultado();
    resultado = Math.log(valor);
    document.getElementById("display").value = resultado;
}   

function cuadrado(){
    valor = calcularResultado();
    resultado = Math.pow(valor, 2);
    document.getElementById("display").value = resultado;
}
