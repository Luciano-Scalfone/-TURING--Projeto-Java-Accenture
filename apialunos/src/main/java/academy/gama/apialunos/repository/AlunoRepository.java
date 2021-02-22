package academy.gama.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.gama.apialunos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>  {

}
