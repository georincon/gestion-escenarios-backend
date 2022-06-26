package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Torneo;
import co.edu.sena.escenarios.repositorio.TorneoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class TorneoControlador {

	@Autowired
	private TorneoRepositorio repositorio;

	//este metodo sirve para listar todos los torneos
	@GetMapping("/torneos")
	public ResponseEntity<List<Torneo>> listarTodosLosTorneos() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	//este metodo sirve para guardar el torneo
	@PostMapping("/torneos")
	public ResponseEntity<Torneo> guardarTorneo(@RequestBody Torneo torneo) {
		return new ResponseEntity<>(repositorio.save(torneo), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un torneo
	@GetMapping("/torneos/{id}")
	public ResponseEntity<Torneo> obtenerTorneoPorId(@PathVariable Long id){
			Torneo torneo = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el torneo con el ID : " + id));
			return ResponseEntity.ok(torneo);
	}
	
	//este metodo sirve para actualizar el torneo
	@PutMapping("/torneos/{id}")
	public ResponseEntity<Torneo> actualizarTorneo(@PathVariable Long id, @RequestBody Torneo detallesTorneo){
		Torneo torneo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el torneo con el ID : " + id));

		torneo.setNombre(detallesTorneo.getNombre());
		torneo.setCategoria(detallesTorneo.getCategoria());
		torneo.setFechaInicio(detallesTorneo.getFechaInicio());
		torneo.setFechaFin(detallesTorneo.getFechaFin());
		torneo.setMunicipio(detallesTorneo.getMunicipio());

		Torneo torneoActualizado = repositorio.save(torneo);
		return ResponseEntity.ok(torneoActualizado);
    }
	
	//este metodo sirve para eliminar un torneo
	@DeleteMapping("/torneos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarTorneo(@PathVariable Long id){
		Torneo torneo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el torneo con el ID : " + id));
		
		repositorio.delete(torneo);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














