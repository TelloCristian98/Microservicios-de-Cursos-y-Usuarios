package com.example.micro_cursos.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos_estudiantes")
public class CursoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estudiante_id", unique = true)
    private Long estudianteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    // Modificación del metodo equals para borrar correctamente en todos los casos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CursoEstudiante)) {
            return false;
        }
        CursoEstudiante o = (CursoEstudiante) obj;
        return this.estudianteId != null && this.estudianteId.equals(o.estudianteId);
    }

    //@Override
    //public int hashCode() {
    // return Objects.hash(id, estudianteId);
    //}
}
