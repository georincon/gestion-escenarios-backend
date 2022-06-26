package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Escenario;
import co.edu.sena.escenarios.repositorio.EscenarioRepositorio;
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
public class EscenarioControlador {

	@Autowired
	private EscenarioRepositorio repositorio;

	//este metodo sirve para listar todos los escenarios
	@GetMapping("/escenarios")
	public ResponseEntity<List<Escenario>> listarTodosLosEscenarios() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	//este metodo sirve para guardar el escenario
	@PostMapping("/escenarios")
	public ResponseEntity<Escenario> guardarEscenario(@RequestBody Escenario escenario) {
		return new ResponseEntity<>(repositorio.save(escenario), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un escenario
	@GetMapping("/escenarios/{id}")
	public ResponseEntity<Escenario> obtenerEscenarioPorId(@PathVariable Long id){
			Escenario escenario = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el escenario con el ID : " + id));
			return ResponseEntity.ok(escenario);
	}
	
	//este metodo sirve para actualizar el escenario
	@PutMapping("/escenarios/{id}")
	public ResponseEntity<Escenario> actualizarEscenario(@PathVariable Long id, @RequestBody Escenario detallesEscenario){
		Escenario escenario = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el escenario con el ID : " + id));

		escenario.setNombre(detallesEscenario.getNombre());
		escenario.setDireccion(detallesEscenario.getDireccion());
		escenario.setTelefono(detallesEscenario.getTelefono());
		escenario.setTorneo(detallesEscenario.getTorneo());

		Escenario escenarioActualizado = repositorio.save(escenario);
		return ResponseEntity.ok(escenarioActualizado);
    }
	
	//este metodo sirve para eliminar un escenario
	@DeleteMapping("/escenarios/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEscenario(@PathVariable Long id){
		Escenario escenario = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el escenario con el ID : " + id));
		
		repositorio.delete(escenario);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














