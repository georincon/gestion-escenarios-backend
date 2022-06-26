package co.edu.sena.escenarios.modelo;

import javax.persistence.*;

@Entity
@Table(name = "cancha")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "disciplina")
    private String disciplina;

    @Column(name = "cantidad_espec")
    private int cantidadEspec;

    @Column(name = "medidas")
    private String medidas;

    @ManyToOne   //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_escenario")
    private Escenario escenario;

    public Cancha() {
    }

    public Cancha(String nombre, String disciplina, int cantidadEspec, String medidas) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.cantidadEspec = cantidadEspec;
        this.medidas = medidas;
    }

    public Cancha(String nombre, String disciplina, int cantidadEspec, String medidas, Escenario escenario) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.cantidadEspec = cantidadEspec;
        this.medidas = medidas;
        this.escenario = escenario;
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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getCantidadEspec() {
        return cantidadEspec;
    }

    public void setCantidadEspec(int cantidadEspec) {
        this.cantidadEspec = cantidadEspec;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    @Override
    public String toString() {
        return "Cancha{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", cantidadEspec=" + cantidadEspec +
                ", medidas='" + medidas + '\'' +
                '}';
    }
}
