package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TorneoRepositorio extends JpaRepository<Torneo, Long> {

}
