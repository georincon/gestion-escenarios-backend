package co.edu.sena.escenarios.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "deporte")
    private String deporte;

    @Column(name = "fecha_creacion")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaCreacion;
    //private LocalDate fechaCreacion;

    @OneToOne(mappedBy = "equipo")
    private Entrenador entrenador;

    @ManyToMany(mappedBy = "equipo")
    private List<Torneo> torneo = new ArrayList<Torneo>();

    @OneToMany(mappedBy = "equipo")  //, cascade = CascadeType.ALL, orphanRemoval = true
    private List<Deportista> deportistas = new ArrayList<Deportista>();

    @ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_patrocinador")
    private Patrocinador patrocinador;

    public Equipo() {
    }

    public Equipo(String nombre, String deporte, String fechaCreacion) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.fechaCreacion = fechaCreacion;
    }

    public Equipo(String nombre, String deporte, String fechaCreacion, Patrocinador patrocinador) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.fechaCreacion = fechaCreacion;
        this.patrocinador = patrocinador;
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
