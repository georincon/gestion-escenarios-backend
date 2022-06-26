package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.Deportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportistaRepositorio extends JpaRepository<Deportista, Long> {
}
