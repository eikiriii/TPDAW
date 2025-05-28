package com.upiiz.ajax.Controllers;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperacionesController {

    @PostMapping("/operaciones/suma")
    public ResponseEntity<Map<String, Object>> SumaNumeros(@RequestBody Map<String, Object> numeros) {
        double n1, n2;
        try {
            n1 = Double.parseDouble(numeros.get("n1").toString());
            n2 = Double.parseDouble(numeros.get("n2").toString());
            double suma = n1 + n2;
            return ResponseEntity.ok(Map.of(
                "estado", 1,
                "mensaje", "Operación realizada con éxito",
                "resultado", suma
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "estado", 0,
                "mensaje", "No fue posible realizar la operación",
                "resultado", 0
            ));
        }
    }

    @PostMapping("/operaciones/resta")
    public ResponseEntity<Map<String, Object>> RestaNumeros(@RequestBody Map<String, Object> numeros) {
        double n1, n2;
        try {
            n1 = Double.parseDouble(numeros.get("n1").toString());
            n2 = Double.parseDouble(numeros.get("n2").toString());
            double resta = n1 - n2;
            return ResponseEntity.ok(Map.of(
                "estado", 1,
                "mensaje", "Operación realizada con éxito",
                "resultado", resta
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "estado", 0,
                "mensaje", "No fue posible realizar la operación",
                "resultado", 0
            ));
        }
    }

    @PostMapping("/operaciones/multiplicacion")
    public ResponseEntity<Map<String, Object>> MultiplicacionNumeros(@RequestBody Map<String, Object> numeros) {
        double n1, n2;
        try {
            n1 = Double.parseDouble(numeros.get("n1").toString());
            n2 = Double.parseDouble(numeros.get("n2").toString());
            double multiplicacion = n1 * n2;
            return ResponseEntity.ok(Map.of(
                "estado", 1,
                "mensaje", "Operación realizada con éxito",
                "resultado", multiplicacion
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "estado", 0,
                "mensaje", "No fue posible realizar la operación",
                "resultado", 0
            ));
        }
    }

    @PostMapping("/operaciones/division")
    public ResponseEntity<Map<String, Object>> DivisionNumeros(@RequestBody Map<String, Object> numeros) {
        double n1, n2;
        try {
            n1 = Double.parseDouble(numeros.get("n1").toString());
            n2 = Double.parseDouble(numeros.get("n2").toString());
            if (n2 == 0) {
                return ResponseEntity.badRequest().body(Map.of(
                    "estado", 0,
                    "mensaje", "No se puede dividir por cero",
                    "resultado", 0
                ));
            }
            double division = n1 / n2;
            return ResponseEntity.ok(Map.of(
                "estado", 1,
                "mensaje", "Operación realizada con éxito",
                "resultado", division
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "estado", 0,
                "mensaje", "No fue posible realizar la operación",
                "resultado", 0
            ));
        }
    }
}

