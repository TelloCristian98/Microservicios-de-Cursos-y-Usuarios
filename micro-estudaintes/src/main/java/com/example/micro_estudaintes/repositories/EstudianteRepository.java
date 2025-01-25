package com.example.micro_estudaintes.repositories;

import com.example.micro_estudaintes.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
