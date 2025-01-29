package com.examen.ramirezCervantes_backend.crud.service;

import com.examen.ramirezCervantes_backend.crud.model.Person;
import com.examen.ramirezCervantes_backend.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> obtenerTodos() {
        return personRepository.findAll();
    }

    public Person crear(Person persona) {
        return personRepository.save(persona);
    }

    public Person actualizar(Long id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    public boolean eliminar(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}