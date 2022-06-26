package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.ColegioArbitral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegioArbitralRepositorio extends JpaRepository<ColegioArbitral, Long> {
}
