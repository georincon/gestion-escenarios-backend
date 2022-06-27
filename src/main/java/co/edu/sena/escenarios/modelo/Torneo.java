package co.edu.sena.escenarios.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "torneo")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "fecha_inicio")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaInicio;
    //private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaFin;
    //private LocalDate fechaFin;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "torneo_equipo",
            joinColumns = @JoinColumn(name = "torneo_id"),
            inverseJoinColumns = @JoinColumn(name = "equipo_id")
    )
    private List<Equipo> equipo = new ArrayList<Equipo>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "torneo_arbitro",
            joinColumns = @JoinColumn(name = "torneo_id"),
            inverseJoinColumns = @JoinColumn(name = "arbitro_id")
    )
    private List<Arbitro> arbitro = new ArrayList<Arbitro>();


    @OneToMany(mappedBy = "torneo")
    private List<Escenario> escenarios = new ArrayList<Escenario>();


    @ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_municipio")
    private Municipio municipio;

    public Torneo() {
    }

    public Torneo(String nombre, String categoria, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Torneo(String nombre, String categoria, String fechaInicio, String fechaFin, Municipio municipio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.municipio = municipio;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
