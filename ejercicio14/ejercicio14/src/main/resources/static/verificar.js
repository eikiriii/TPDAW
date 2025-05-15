document.getElementById("registroForm").addEventListener("submit", function(event) {
    event.preventDefault(); 

    const nombre = document.getElementById("nombre").value.trim();
    const apellidos = document.getElementById("apellidos").value.trim();
    const rfc = document.getElementById("rfc").value.trim().toUpperCase();
    const curp = document.getElementById("curp").value.trim().toUpperCase();
    const clave = document.getElementById("clave").value.trim().toUpperCase();

    const ValidarNombre = /^[A-Z a-z ÁÉÍÓÚÑáéíóúñ\s]{3,}$/; // Acepta mayusculas, minúsculas, acentos, y un mínimo de 3 letras
    const ValidarApellido = /^[A-Z a-z ÁÉÍÓÚÑáéíóúñ\s]{3,}$/; // Acepta mayusculas, minúsculas, acentos, y un mínimo de 3 letras
    const ValidarCURP = /^[A-Z]{4}[0-9]{6}[HM][A-Z]{5}[0-9A-Z]{2}$/; // 4 letras, 6 números, H o M, 5 letras, 2 alfanuméricos
    const ValidarRFC = /^[A-ZÑ&]{3,4}[0-9]{6}[A-Z0-9]{3}$/; // 3 o 4 letras, 6 números, 3 alfanuméricos
    const ValidarClave = /^[A-Z0-9]{10}$/; // 10 caracteres alfanuméricos

    let errores = [];

    if (!ValidarNombre.test(nombre)){
        errores.push("El nombre debe contener al menos 3 letras.");
    }
    if (!ValidarApellido.test(apellidos)){
        errores.push("El apellido debe contener al menos 3 letras.");
    } 
    if (!ValidarCURP.test(curp)){
        errores.push("CURP incorrecta.");
    } 
    if (!ValidarRFC.test(rfc)){
        errores.push("RFC incorrecto.");
    } 
    if (!ValidarClave.test(clave)){
        errores.push("Clave de plantel incorrecta.");
    } 
    if (errores.length > 0) {
        alert("INFORMACIÓN INVÁLIDA \nCorrige los siguientes errores para seguir con el registro: \n- " + errores.join("\n- "));
    } else {
        alert("¡Registro exitoso!");
    }
});