package co.edu.sena.escenarios.repositorio;

import co.edu.sena.escenarios.modelo.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepositorio extends JpaRepository<Patrocinador, Long> {
}
