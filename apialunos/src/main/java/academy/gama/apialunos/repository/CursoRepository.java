package academy.gama.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.gama.apialunos.entity.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Long>{

}
