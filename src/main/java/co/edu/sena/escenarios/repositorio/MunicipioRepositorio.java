package co.edu.sena.escenarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.sena.escenarios.modelo.Municipio;

@Repository
public interface MunicipioRepositorio extends JpaRepository<Municipio, Long>{
    //Boolean existsByName(String nombre);

}
