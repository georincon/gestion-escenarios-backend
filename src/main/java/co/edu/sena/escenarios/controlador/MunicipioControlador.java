package co.edu.sena.escenarios.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.sena.escenarios.modelo.Municipio;
import co.edu.sena.escenarios.repositorio.MunicipioRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class MunicipioControlador {

	@Autowired
	private MunicipioRepositorio repositorio;
/*
	private void municipioExiste(String nombre){
		if(repositorio.existsByName(nombre)){
			throw new DuplicateKeyException("the name of category is already registered");
		}
	}
*/
	//este metodo sirve para listar todos los municipios
	@GetMapping("/municipios")
	public ResponseEntity<List<Municipio>> listarTodosLosMunicipios() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	

	//este metodo sirve para guardar el municipio
	@PostMapping("/municipios")
	public ResponseEntity<Municipio> guardarMunicipio(@RequestBody Municipio municipio) {
		//Municipio municipioNoExiste = new Municipio();
		//this.municipioExiste(municipio.getNombre());
		//BeanUtils.copyProperties(municipio, municipioNoExiste);
		return new ResponseEntity<>(repositorio.save(municipio), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un municipio
	@GetMapping("/municipios/{id}")
	public ResponseEntity<Municipio> obtenerMunicipioPorId(@PathVariable Long id){
			Municipio municipio = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el municipio con el ID : " + id));
			return ResponseEntity.ok(municipio);
	}
	
	//este metodo sirve para actualizar el municipio
	@PutMapping("/municipios/{id}")
	public ResponseEntity<Municipio> actualizarMunicipio(@PathVariable Long id, @RequestBody Municipio detallesMunicipio){
		Municipio municipio = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el municipio con el ID : " + id));
		
		municipio.setNombre(detallesMunicipio.getNombre());
		
		Municipio municipioActualizado = repositorio.save(municipio);
		return ResponseEntity.ok(municipioActualizado);
    }
	
	//este metodo sirve para eliminar un municipio
	@DeleteMapping("/municipios/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarMunicipio(@PathVariable Long id){
		Municipio municipio = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el municipio con el ID : " + id));
		
		repositorio.delete(municipio);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














