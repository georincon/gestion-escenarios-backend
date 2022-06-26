package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaRepositorio extends JpaRepository<Cancha, Long> {
}
