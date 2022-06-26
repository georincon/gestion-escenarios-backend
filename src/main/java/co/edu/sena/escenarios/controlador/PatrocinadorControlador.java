package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Patrocinador;
import co.edu.sena.escenarios.repositorio.PatrocinadorRepositorio;
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
public class PatrocinadorControlador {

	@Autowired
	private PatrocinadorRepositorio repositorio;

	//este metodo sirve para listar todos los patrocinadores
	@GetMapping("/patrocinadores")
	public ResponseEntity<List<Patrocinador>> listarTodosLosPatrocinadores() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	

	//este metodo sirve para guardar el patrocinador
	@PostMapping("/patrocinadores")
	public ResponseEntity<Patrocinador> guardarPatrocinador(@RequestBody Patrocinador patrocinador) {
		return new ResponseEntity<>(repositorio.save(patrocinador), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un patrocinador
	@GetMapping("/patrocinadores/{id}")
	public ResponseEntity<Patrocinador> obtenerPatrocinadorPorId(@PathVariable Long id){
			Patrocinador patrocinador = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el patrocinador con el ID : " + id));
			return ResponseEntity.ok(patrocinador);
	}
	
	//este metodo sirve para actualizar el patrocinador
	@PutMapping("/patrocinadores/{id}")
	public ResponseEntity<Patrocinador> actualizarPatrocinador(@PathVariable Long id, @RequestBody Patrocinador detallesPatrocinador){
		Patrocinador patrocinador = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el patrocinador con el ID : " + id));

		patrocinador.setIdentificacion(detallesPatrocinador.getIdentificacion());
		patrocinador.setNombre(detallesPatrocinador.getNombre());
		patrocinador.setDireccion(detallesPatrocinador.getDireccion());
		patrocinador.setTelefono(detallesPatrocinador.getTelefono());
		patrocinador.setTipoPersona(detallesPatrocinador.getTipoPersona());
		patrocinador.setCorreo(detallesPatrocinador.getCorreo());

		Patrocinador patrocinadorActualizado = repositorio.save(patrocinador);
		return ResponseEntity.ok(patrocinadorActualizado);
    }
	
	//este metodo sirve para eliminar un patrocinador
	@DeleteMapping("/patrocinadores/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarPatrocinador(@PathVariable Long id){
		Patrocinador patrocinador = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el patrocinador con el ID : " + id));
		
		repositorio.delete(patrocinador);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














