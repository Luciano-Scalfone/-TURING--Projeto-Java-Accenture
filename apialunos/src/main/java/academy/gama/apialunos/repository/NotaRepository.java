package academy.gama.apialunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academy.gama.apialunos.entity.Aluno;
import academy.gama.apialunos.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	@Query("select n from Nota n where n.aluno = ?1")
	List<Nota> getNotasByAlunoId(Aluno aluno);
	
	List<Nota> findByAluno(Aluno aluno);
	
}
