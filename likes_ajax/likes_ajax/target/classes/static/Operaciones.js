function like(imagen) {
  fetch('/api/likes/' + imagen, { method: 'POST' })
    .then(response => response.json())
    .then(data => {
     
      setTimeout(() => {
        actualizarContadores(data);
      }, 1000); 
    });
}

function actualizarContadores(data) {
  document.getElementById("like1").innerText = data.imagen1;
  document.getElementById("like2").innerText = data.imagen2;
  document.getElementById("like3").innerText = data.imagen3;
}

setInterval(() => {
  fetch('/api/likes')
    .then(response => response.json())
    .then(data => actualizarContadores(data));
}, 2000);
