package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.ColegioArbitral;
import co.edu.sena.escenarios.repositorio.ColegioArbitralRepositorio;
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
public class ColegioArbitralControlador {

	@Autowired
	private ColegioArbitralRepositorio repositorio;

	//este metodo sirve para listar todos los colegios arbitrales
	@GetMapping("/colegios_arbitrales")
	public ResponseEntity<List<ColegioArbitral>> listarTodosLosColegiosArbitrales() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	

	//este metodo sirve para guardar el colegio arbitral
	@PostMapping("/colegios_arbitrales")
	public ResponseEntity<ColegioArbitral> guardarColegioArbitral(@RequestBody ColegioArbitral colegioArbitral) {
		return new ResponseEntity<>(repositorio.save(colegioArbitral), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un colegio arbitral
	@GetMapping("/colegios_arbitrales/{id}")
	public ResponseEntity<ColegioArbitral> obtenerColegioArbitralPorId(@PathVariable Long id){
			ColegioArbitral colegioArbitral = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el colegio arbitral con el ID : " + id));
			return ResponseEntity.ok(colegioArbitral);
	}
	
	//este metodo sirve para actualizar el colegio arbitral
	@PutMapping("/colegios_arbitrales/{id}")
	public ResponseEntity<ColegioArbitral> actualizarColegioArbitral(@PathVariable Long id, @RequestBody ColegioArbitral detallesColegioArbitral){
		ColegioArbitral colegioArbitral = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el colegio arbitral con el ID : " + id));
		
		colegioArbitral.setNit(detallesColegioArbitral.getNit());
		colegioArbitral.setNombre(detallesColegioArbitral.getNombre());
		colegioArbitral.setResolucion(detallesColegioArbitral.getResolucion());
		colegioArbitral.setDireccion(detallesColegioArbitral.getDireccion());
		colegioArbitral.setTelefono(detallesColegioArbitral.getTelefono());
		colegioArbitral.setCorreo(detallesColegioArbitral.getCorreo());

		ColegioArbitral colegioArbitralActualizado = repositorio.save(colegioArbitral);
		return ResponseEntity.ok(colegioArbitralActualizado);
    }
	
	//este metodo sirve para eliminar un colegio arbitral
	@DeleteMapping("/colegios_arbitrales/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarColegioArbitral(@PathVariable Long id){
		ColegioArbitral colegioArbitral = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el colegio arbitral con el ID : " + id));
		
		repositorio.delete(colegioArbitral);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














