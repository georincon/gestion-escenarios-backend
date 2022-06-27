package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Arbitro;
import co.edu.sena.escenarios.repositorio.ArbitroRepositorio;
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
public class ArbitroControlador {

	@Autowired
	private ArbitroRepositorio repositorio;

	//este metodo sirve para listar todos los arbitros
	@GetMapping("/arbitros")
	public ResponseEntity<List<Arbitro>> listarTodosLosArbitros() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	

	//este metodo sirve para guardar el arbitro
	@PostMapping("/arbitros")
	public ResponseEntity<Arbitro> guardarArbitro(@RequestBody Arbitro arbitro) {
		return new ResponseEntity<>(repositorio.save(arbitro), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un arbitro
	@GetMapping("/arbitros/{id}")
	public ResponseEntity<Arbitro> obtenerArbitroPorId(@PathVariable Long id){
			Arbitro arbitro = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el arbitro con el ID : " + id));
			return ResponseEntity.ok(arbitro);
	}
	
	//este metodo sirve para actualizar el arbitro
	@PutMapping("/arbitros/{id}")
	public ResponseEntity<Arbitro> actualizarArbitro(@PathVariable Long id, @RequestBody Arbitro detallesArbitro){
		Arbitro arbitro = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el arbitro con el ID : " + id));

		arbitro.setDocumento(detallesArbitro.getDocumento());
		arbitro.setNombre(detallesArbitro.getNombre());
		arbitro.setApellidos(detallesArbitro.getApellidos());
		arbitro.setGenero(detallesArbitro.getGenero());
		arbitro.setCelular(detallesArbitro.getCelular());
		arbitro.setDeporte(detallesArbitro.getDeporte());
		arbitro.setColegioArbitral(detallesArbitro.getColegioArbitral());

		Arbitro arbitroActualizado = repositorio.save(arbitro);
		return ResponseEntity.ok(arbitroActualizado);
    }
	
	//este metodo sirve para eliminar un arbitro
	@DeleteMapping("/arbitros/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarArbitro(@PathVariable Long id){
		Arbitro arbitro = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el arbitro con el ID : " + id));
		
		repositorio.delete(arbitro);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














