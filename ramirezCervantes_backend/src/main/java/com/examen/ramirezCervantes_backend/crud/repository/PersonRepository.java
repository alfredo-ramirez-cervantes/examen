package com.examen.ramirezCervantes_backend.crud.repository;

import com.examen.ramirezCervantes_backend.crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}