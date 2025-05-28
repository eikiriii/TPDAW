function calcularOperacionesAJAX(){
    let operacion = document.getElementById("operacion").value;
    let numeroUno = document.getElementById("n1").value;
    let numeroDos = document.getElementById("n2").value; 

    let url = "";
    if (operacion === "suma") url = "/operaciones/suma";
    else if (operacion === "resta") url = "/operaciones/resta";
    else if (operacion === "multiplicacion") url = "/operaciones/multiplicacion";
    else if (operacion === "division") url = "/operaciones/division";
    
    $.ajax({
        method: "POST",
        url : url,
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            n1: numeroUno,
            n2: numeroDos
        }),
        success: function( resultadoAJAX ){
            if(resultadoAJAX.estado==1){
                document.getElementById("muestra-resultado").textContent=resultadoAJAX.resultado; 
            }
            else{
                alert(resultadoAJAX.mensaje); 
            }
        },
        error:function(xhr, status, error){
            alert("Error en la petición AJAX");
        }
    }); 
}

