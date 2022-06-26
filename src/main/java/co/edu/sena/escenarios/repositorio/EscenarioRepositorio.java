package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.Escenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscenarioRepositorio extends JpaRepository<Escenario, Long> {
}
