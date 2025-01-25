package com.example.micro_cursos.controller;

import com.example.micro_cursos.Services.CursoServices;
import com.example.micro_cursos.model.Estudiante;
import com.example.micro_cursos.model.entity.Curso;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoServices cursoServices;
    @PostMapping
    public ResponseEntity<?> crear (@Valid @RequestBody Curso curso, BindingResult result){
        if(validar(result)!=null){
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoServices.save(curso));
    }
    @GetMapping
    public List<Curso> listar(){
        return cursoServices.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@Valid @PathVariable Long id){
        Optional<Curso> cursoOptional=cursoServices.findById(id);
        if(cursoOptional.isPresent()){
            return ResponseEntity.ok().body(cursoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso,@PathVariable Long id){
        Optional<Curso> cursoOptional=cursoServices.findById(id);
        if (cursoOptional.isPresent()){
            Curso cursoDB=cursoOptional.get();
            cursoDB.setNombre(curso.getNombre());
            cursoDB.setDescripcion(curso.getDescripcion());
            cursoDB.setCreditos(curso.getCreditos());
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoServices.save(cursoDB));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Curso> cursoOptional=cursoServices.findById(id);
        if (cursoOptional.isPresent()){
            cursoServices.delteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<?> validar(BindingResult result){

        if(result.hasErrors()){
            Map<String,String> errores=new HashMap<>();
            result.getFieldErrors().forEach(
                    err->errores.put(
                            err.getField(),err.getDefaultMessage()
                    )
            );
            return ResponseEntity.badRequest().body(errores);
        }
        return null;
    }
    @PutMapping("/asignar-estudiante/{cursoId}")
    public ResponseEntity<?> asignarUsuario(@RequestBody Estudiante estudiante, @PathVariable Long cursoId){
        Optional<Estudiante> o;
        try {
            o=cursoServices.asignarStudent(estudiante,cursoId);
        }catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje","No existe el estudiante por"+cursoId
                            +"el id o error de comunicación"+e.getMessage()));

        }
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }

}
