package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Cancha;
import co.edu.sena.escenarios.repositorio.CanchaRepositorio;
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
public class CanchaControlador {

	@Autowired
	private CanchaRepositorio repositorio;

	//este metodo sirve para listar todas las canchas
	@GetMapping("/canchas")
	public ResponseEntity<List<Cancha>> listarTodasLasCanchas() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	

	//este metodo sirve para guardar la cancha
	@PostMapping("/canchas")
	public ResponseEntity<Cancha> guardarCancha(@RequestBody Cancha cancha) {
		return new ResponseEntity<>(repositorio.save(cancha), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar una cancha
	@GetMapping("/canchas/{id}")
	public ResponseEntity<Cancha> obtenerCanchaPorId(@PathVariable Long id){
			Cancha cancha = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la cancha con el ID : " + id));
			return ResponseEntity.ok(cancha);
	}
	
	//este metodo sirve para actualizar la cancha
	@PutMapping("/canchas/{id}")
	public ResponseEntity<Cancha> actualizarCancha(@PathVariable Long id, @RequestBody Cancha detallesCancha){
		Cancha cancha = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la cancha con el ID : " + id));

		cancha.setNombre(detallesCancha.getNombre());
		cancha.setDisciplina(detallesCancha.getDisciplina());
		cancha.setCantidadEspec(detallesCancha.getCantidadEspec());
		cancha.setMedidas(detallesCancha.getMedidas());
		cancha.setEscenario(detallesCancha.getEscenario());

		Cancha canchaActualizado = repositorio.save(cancha);
		return ResponseEntity.ok(canchaActualizado);
    }
	
	//este metodo sirve para eliminar una cancha
	@DeleteMapping("/canchas/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarCancha(@PathVariable Long id){
		Cancha cancha = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la cancha con el ID : " + id));
		
		repositorio.delete(cancha);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














