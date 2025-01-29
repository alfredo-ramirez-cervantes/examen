package com.examen.ramirezCervantes_backend.crud.controller;

import com.examen.ramirezCervantes_backend.crud.model.Person;
import com.examen.ramirezCervantes_backend.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonController {

    @Autowired
    private PersonService personService;

    // Obtener todos los personas
    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        List<Person> personas = personService.obtenerTodos();
        return ResponseEntity.ok(buildResponse(
            true, 
            "Personas obtenidas correctamente", personas));
    }

    // Crear una nueva persona
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Person person) {
        Person personCreado = personService.crear(person);
        return ResponseEntity.status(201).body(buildResponse(
            true, 
            "Persona creada exitosamente", personCreado));
    }

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Person person) {
        Person personActualizado = personService.actualizar(id, person);
        return ResponseEntity.ok(buildResponse(
            true, 
            "Persona actualizada correctamente", personActualizado));
    }

    // Eliminar una persona
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = personService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok(buildResponse(
                true, 
                "Persona eliminada correctamente", null));
        }
        return ResponseEntity.status(404).body(buildResponse(
            false, 
            "Persona no encontrada", null));
    }

    // Método para construir la respuesta en formato JSON
    private Object buildResponse(boolean status, String msg, Object data) {
        return new ResponseFormat(status, msg, data);
    }

    // Clase para el formato de la respuesta
    public static class ResponseFormat {
        private boolean status;
        private String msg;
        private Object data;

        public ResponseFormat(boolean status, String msg, Object data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
        }

        public boolean isStatus() {
            return status;
        }

        public String getMsg() {
            return msg;
        }

        public Object getData() {
            return data;
        }
    }
}