package com.example.micro_estudaintes.services;

import com.example.micro_estudaintes.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiante> findAll();
    Optional<Estudiante> findById(Long id);
    Estudiante save(Estudiante estudiante);
    void deleteById(Long id);
}

