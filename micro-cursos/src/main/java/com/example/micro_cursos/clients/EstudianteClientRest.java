package com.example.micro_cursos.clients;

import com.example.micro_cursos.model.Estudiante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-estudiantes", url = "localhost:8003/api/estudiantes")
public interface EstudianteClientRest {
    @GetMapping("/{id}")
    Estudiante findById(@PathVariable Long id);
}

