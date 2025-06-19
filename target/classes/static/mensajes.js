$(document).ready(function () {
  cargarMensajes(); 
}); 

function enviarMensaje() {
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
  $.ajax({
    url: `/api/mensajes`,
    method: 'GET',
    success: function (respuesta) {
      const contenedor = $("#mensaje");
      contenedor.html("");

      const carreras = respuesta.carreras;

      carreras.forEach(c => {
        contenedor.append(`<div class="direct-chat-text">${c.mensaje}</div>`);
      });

      contenedor.scrollTop(contenedor.prop("scrollHeight"));
    },
    error: function () {
      console.error("Error al cargar mensajes.");
    }
  });
}