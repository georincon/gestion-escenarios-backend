package co.edu.sena.escenarios.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "municipio")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "municipio") //, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Torneo> torneos = new ArrayList<Torneo>();

	public Municipio() {
	}

	public Municipio(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Municipio{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
