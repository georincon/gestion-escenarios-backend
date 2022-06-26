package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Entrenador;
import co.edu.sena.escenarios.repositorio.EntrenadorRepositorio;
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
public class EntrenadorControlador {

	@Autowired
	private EntrenadorRepositorio repositorio;

	//este metodo sirve para listar todos los entrenadores
	@GetMapping("/entrenadores")
	public ResponseEntity<List<Entrenador>> listarTodosLosEntrenadores() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	//este metodo sirve para guardar el entrenador
	@PostMapping("/entrenadores")
	public ResponseEntity<Entrenador> guardarEntrenador(@RequestBody Entrenador entrenador) {
		return new ResponseEntity<>(repositorio.save(entrenador), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un entrenador
	@GetMapping("/entrenadores/{id}")
	public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable Long id){
			Entrenador entrenador = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el entrenador con el ID : " + id));
			return ResponseEntity.ok(entrenador);
	}
	
	//este metodo sirve para actualizar el entrenador
	@PutMapping("/entrenadores/{id}")
	public ResponseEntity<Entrenador> actualizarEntrenador(@PathVariable Long id, @RequestBody Entrenador detallesEntrenador){
		Entrenador entrenador = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el entrenador con el ID : " + id));

		entrenador.setDocumento(detallesEntrenador.getDocumento());
		entrenador.setNombre(detallesEntrenador.getNombre());
		entrenador.setApellidos(detallesEntrenador.getApellidos());
		entrenador.setGenero(detallesEntrenador.getGenero());
		entrenador.setEquipo(detallesEntrenador.getEquipo());

		Entrenador entrenadorActualizado = repositorio.save(entrenador);
		return ResponseEntity.ok(entrenadorActualizado);
    }
	
	//este metodo sirve para eliminar un entrenador
	@DeleteMapping("/entrenadores/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEntrenador(@PathVariable Long id){
		Entrenador entrenador = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el entrenador con el ID : " + id));
		
		repositorio.delete(entrenador);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














