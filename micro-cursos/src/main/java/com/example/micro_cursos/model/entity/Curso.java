package com.example.micro_cursos.model.entity;

import com.example.micro_cursos.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cursos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nombre"})
})
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name")
    @NotEmpty
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int creditos;


    //unir a la tabla curso
    //orphanremoval true si se elmina un curso se elmiina todos
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoUsuario> cursoUsuarios;



    //unir a la tabla curso
    //orphanremoval true si se elmina un curso se elmiina todos
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoEstudiante> cursoEstudiantes;

    //recibir datos de usuarios
    @Transient
    private List<Usuario> usuarios;
    //generamos constructor en blanco con una lista vacía
    @Transient
    private List<Usuario> estudiantes;
    //generamos constructor en blanco con una lista vacía
    public Curso() {
        cursoUsuarios=new ArrayList<>();
        usuarios=new ArrayList<>();
        //generar vacio en el constructor
        cursoEstudiantes=new ArrayList<>();
        estudiantes=new ArrayList<>();
    }
    public void addCursoUsuario(CursoUsuario cursoUsuario){

        cursoUsuarios.add(cursoUsuario);
    }
    public void removeCursoUsuario(CursoUsuario cursoUsuario){
        cursoUsuarios.remove(cursoUsuario);
    }
    public void addCursoEstudiante(CursoEstudiante cursoEstudiante) {
        cursoEstudiantes.add(cursoEstudiante);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public List<CursoUsuario> getCursoUsuarios() {
        return cursoUsuarios;
    }

    public void setCursoUsuarios(List<CursoUsuario> cursoUsuarios) {
        this.cursoUsuarios = cursoUsuarios;
    }
    public List<CursoEstudiante> getCursoEstudiantes() {
        return cursoEstudiantes;
    }

    public void setCursoEstudiantes(List<CursoEstudiante> cursoEstudiantes) {
        this.cursoEstudiantes = cursoEstudiantes;
    }


}

