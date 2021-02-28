package academy.gama.apialunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academy.gama.apialunos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>  {

	@Query("select n from Aluno n where n.nome like %?1%")
	List<Aluno> findByNome(String nome);
}
