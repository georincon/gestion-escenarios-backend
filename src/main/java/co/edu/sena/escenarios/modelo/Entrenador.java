package co.edu.sena.escenarios.modelo;

import javax.persistence.*;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento")
    private String documento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "genero")
    private String genero;

    @OneToOne    //(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_equipo")
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(String documento, String nombre, String apellidos, String genero) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
    }

    public Entrenador(String documento, String nombre, String apellidos, String genero, Equipo equipo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.equipo = equipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
