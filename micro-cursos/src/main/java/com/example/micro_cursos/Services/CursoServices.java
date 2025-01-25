package com.example.micro_cursos.Services;

import com.example.micro_cursos.model.Estudiante;
import com.example.micro_cursos.model.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoServices {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void delteById(Long id);
    //agregar la funcoonal de asignar un usuario
    //Optional<Usuario> addUser(Usuario usuario, Long id);
    //agregar la funcionalidad de asignar un estudiante
    Optional<Estudiante> asignarStudent(Estudiante estudiante, Long id);
}
