package com.example.micro_cursos.Services;

import com.example.micro_cursos.clients.EstudianteClientRest;
import com.example.micro_cursos.model.Estudiante;
import com.example.micro_cursos.model.entity.Curso;
import com.example.micro_cursos.model.entity.CursoEstudiante;
import com.example.micro_cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CursoServiceImpl implements CursoServices{
    @Autowired
    private CursoRepository cursoRepository;
    //@Autowired
    //private UsuarioClientRest usuarioClientRest;
    @Autowired
    private EstudianteClientRest estudianteClientRest;
    @Override
    public List<Curso> findAll() {

        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }
    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void delteById(Long id) {

        cursoRepository.deleteById(id);
    }
    /*@Override
    public Optional<Usuario> addUser(Usuario usuario, Long id) {
        Optional<Curso> optional =cursoRepository.findById(id);
        if(!(optional.isPresent())){
            Usuario usuarioTemp= usuarioClientRest.findById(usuario.getId());
            Curso curso=optional.get();
            CursoUsuario cursoUsuario=new CursoUsuario();
            cursoUsuario.setId(usuarioTemp.getId());
            curso.addCursoUsuario(cursoUsuario);
            cursoRepository.save(curso);
            return Optional.of(usuarioTemp);
        }
        return Optional.empty();
    }*/

    @Override
    public Optional<Estudiante> asignarStudent(Estudiante estudiante, Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        System.out.println(optional.get().getNombre());
        // Verifica si el curso existe
        if (optional.isPresent()) {
            // Busca el estudiante por su ID usando el cliente REST
            Estudiante estudianteTemp = estudianteClientRest.findById(estudiante.getId());
            System.out.println(estudianteTemp.getApellido());
            // Obtiene el curso desde el Optional
            Curso curso = optional.get();
            // Crea una nueva relación entre el curso y el estudiante
            CursoEstudiante cursoEstudiante = new CursoEstudiante();
            System.out.println(estudianteTemp.getId());
            //cursoEstudiante.setId(estudianteTemp.getId());
            cursoEstudiante.setEstudianteId(estudianteTemp.getId());
            // Agrega la relación al curso
            curso.addCursoEstudiante(cursoEstudiante);
            // Guarda los cambios en el curso
            cursoRepository.save(curso);
            // Retorna el estudiante encontrado
            return Optional.of(estudianteTemp);
        }

        // Si el curso no existe, retorna un Optional vacío
        return Optional.empty();
    }

}

