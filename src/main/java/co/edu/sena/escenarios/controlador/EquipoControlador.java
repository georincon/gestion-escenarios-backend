package co.edu.sena.escenarios.controlador;

import co.edu.sena.escenarios.excepciones.ResourceNotFoundException;
import co.edu.sena.escenarios.modelo.Equipo;
import co.edu.sena.escenarios.repositorio.EquipoRepositorio;
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
public class EquipoControlador {

	@Autowired
	private EquipoRepositorio repositorio;

	//este metodo sirve para listar todos los equipos
	@GetMapping("/equipos")
	public ResponseEntity<List<Equipo>> listarTodosLosEquipos() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	//este metodo sirve para guardar el equipo
	@PostMapping("/equipos")
	public ResponseEntity<Equipo> guardarEquipo(@RequestBody Equipo equipo) {
		return new ResponseEntity<>(repositorio.save(equipo), HttpStatus.OK);
	}
    
	//este metodo sirve para buscar un equipo
	@GetMapping("/equipos/{id}")
	public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable Long id){
			Equipo equipo = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el equipo con el ID : " + id));
			return ResponseEntity.ok(equipo);
	}
	
	//este metodo sirve para actualizar el equipo
	@PutMapping("/equipos/{id}")
	public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id, @RequestBody Equipo detallesEquipo){
		Equipo equipo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el equipo con el ID : " + id));

		equipo.setNombre(detallesEquipo.getNombre());
		equipo.setDeporte(detallesEquipo.getDeporte());
		equipo.setFechaCreacion(detallesEquipo.getFechaCreacion());
		equipo.setPatrocinador(detallesEquipo.getPatrocinador());

		Equipo equipoActualizado = repositorio.save(equipo);
		return ResponseEntity.ok(equipoActualizado);
    }
	
	//este metodo sirve para eliminar un equipo
	@DeleteMapping("/equipos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEquipo(@PathVariable Long id){
		Equipo equipo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el equipo con el ID : " + id));
		
		repositorio.delete(equipo);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














