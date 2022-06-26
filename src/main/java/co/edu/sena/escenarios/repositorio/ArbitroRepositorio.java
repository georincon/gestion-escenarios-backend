package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitroRepositorio extends JpaRepository<Arbitro, Long> {
}
