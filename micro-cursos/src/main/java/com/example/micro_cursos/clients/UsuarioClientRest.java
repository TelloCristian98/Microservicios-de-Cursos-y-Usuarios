package com.example.micro_cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "micro_cursos",url = "localhost:8002/api/usuarios")
public interface UsuarioClientRest {
    //@GetMapping("/{id}")
    //Usuario findById(@PathVariable Long id);
}
