package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Deportista;
import co.edu.sena.escenarios.repositorio.DeportistaRepositorio;
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
public class DeportistaControlador {

	@Autowired
	private DeportistaRepositorio repositorio;

	//este metodo sirve para listar todos los deportistas
	@GetMapping("/deportistas")
	public ResponseEntity<List<Deportista>> listarTodosLosDeportistas() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	

	//este metodo sirve para guardar el deportista
	@PostMapping("/deportistas")
	public ResponseEntity<Deportista> guardarDeportista(@RequestBody Deportista deportista) {
		return new ResponseEntity<>(repositorio.save(deportista), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un deportista
	@GetMapping("/deportistas/{id}")
	public ResponseEntity<Deportista> obtenerDeportistaPorId(@PathVariable Long id){
			Deportista deportista = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el deportista con el ID : " + id));
			return ResponseEntity.ok(deportista);
	}
	
	//este metodo sirve para actualizar el deportista
	@PutMapping("/deportistas/{id}")
	public ResponseEntity<Deportista> actualizarDeportista(@PathVariable Long id, @RequestBody Deportista detallesDeportista){
		Deportista deportista = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el deportista con el ID : " + id));

		deportista.setDocumento(detallesDeportista.getDocumento());
		deportista.setNombre(detallesDeportista.getNombre());
		deportista.setApellidos(detallesDeportista.getApellidos());
		deportista.setDireccion(detallesDeportista.getDireccion());
		deportista.setCelular(detallesDeportista.getCelular());
		deportista.setCorreo(detallesDeportista.getCorreo());
		deportista.setRh(detallesDeportista.getRh());
		deportista.setEps(detallesDeportista.getEps());
		deportista.setFechaNacimiento(detallesDeportista.getFechaNacimiento());
		deportista.setGenero(detallesDeportista.getGenero());
		deportista.setEquipo(detallesDeportista.getEquipo());

		Deportista deportistaActualizado = repositorio.save(deportista);
		return ResponseEntity.ok(deportistaActualizado);
    }
	
	//este metodo sirve para eliminar un deportista
	@DeleteMapping("/deportistas/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarDeportista(@PathVariable Long id){
		Deportista deportista = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el deportista con el ID : " + id));
		
		repositorio.delete(deportista);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














