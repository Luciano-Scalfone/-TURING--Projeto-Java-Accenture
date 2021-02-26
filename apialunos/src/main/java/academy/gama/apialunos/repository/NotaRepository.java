package academy.gama.apialunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import academy.gama.apialunos.entity.Aluno;
import academy.gama.apialunos.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	@Query("select n from Nota n where n.aluno = ?1")
	List<Nota> getNotasByAlunoId(Aluno aluno);
//	@Query("select n.nota_um, n.nota_dois, n.nota_trabalho, n.nota_apresentacao, n.media_conceito, n.statusAprovacao from Nota n where aluno = ?1")
//	@Query(value = "select n.nota_um from Nota n where aluno_id = ?1", nativeQuery = true)
	
//	@Query(value = "SELECT n.id n.nota_dois, n.nota_um, n.nota_trabalho, n.nota_apresentacao, n.media_conceito, n.aluno_id, n.disciplina_id FROM NOTA as n where aluno_id = ?1", nativeQuery = true)
//	List<Nota> getNotasByAlunoId(Aluno aluno);
	
	
//	@Query(value = "SELECT n.id n.nota_dois, n.nota_um, n.nota_trabalho, n.nota_apresentacao, n.media_conceito, n.aluno_id, n.disciplina_id FROM NOTA as n where aluno_id = :aluno", nativeQuery = true)
//	List<Nota> getNotasByAlunoId(@Param("aluno") Long aluno);
}
