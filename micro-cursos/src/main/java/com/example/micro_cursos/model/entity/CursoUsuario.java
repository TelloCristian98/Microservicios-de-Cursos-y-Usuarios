package com.example.micro_cursos.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cursos_usuarios")
public class CursoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_id",unique = true)
    private Long usuarioId;
    public Long getId() {
        return id;
    }
    //id de curso se configura en la parte de join


    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    //vamos a modificar el metodo equals para borrar en todos los casos


    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(!(obj instanceof CursoUsuario)){
            return false;
        }
        CursoUsuario o=(CursoUsuario) obj;
        return this.usuarioId !=null&&this.usuarioId.equals(o.usuarioId);
    }

    //@Override
    //public int hashCode() {
    // return Objects.hash(id, usuarioId);
    //}
}
