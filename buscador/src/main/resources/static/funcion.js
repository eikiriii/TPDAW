
        const input = document.getElementById("busqueda");
        const resultados = document.getElementById("resultados");

        input.addEventListener("input", () => {
            const texto = input.value.trim();
            if (texto.length < 3) {
                resultados.innerHTML = "";
                return;
            }

            fetch(`/api/search/suggestions?query=${encodeURIComponent(texto)}`)
                .then(res => res.json())
                .then(data => {
                    resultados.innerHTML = "";
                    data.forEach(item => {
                        const div = document.createElement("div");
                        div.className = "sugerencia";
                        div.textContent = item.nombre;
                        resultados.appendChild(div);
                    });
                });
        });