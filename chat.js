function enviarMensaje() {
    alert("Enviando mensaje...");
    const mensaje = $("#message").val();
    if (!mensaje.trim()) {
        alert("No puedes enviar un mensaje vacío.");
        return;
    }

    $.ajax({
      url: '/api/mensajes',
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify({
        texto: mensaje
      }),
      success: function () {
        $("#message").val("");
        cargarMensajes();
      },
      error: function () {
        alert("Error al enviar el mensaje.");
      }
    });
}

function cargarMensajes() {
    alert("Cargando mensajes...");
    $.ajax({
      url: `/api/mensajes/`,
      method: 'GET',
      success: function (mensajes) {
        const contenedor = $("#mensajes"); // Cambiado de #mensaje a #mensajes
        contenedor.html("");
        mensajes.forEach(m => {
          contenedor.append(`<div class="direct-chat-text">${m.texto}</div>`); // Cambiado m.mensaje a m.texto
        });
        contenedor.scrollTop(contenedor.prop("scrollHeight"));
      },
      error: function () {
        console.error("Error al cargar mensajes.");
      }
    });
}