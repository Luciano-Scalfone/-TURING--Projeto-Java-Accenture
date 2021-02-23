package academy.gama.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.gama.apialunos.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
