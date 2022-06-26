package co.edu.sena.escenarios.modelo;

import javax.persistence.*;

@Entity
@Table(name = "arbitro")
public class Arbitro {

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

    @Column(name = "celular")
    private String celular;

    @Column(name = "deporte")
    private String deporte;

    @ManyToOne   //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_colegioArbitral")
    private ColegioArbitral colegioArbitral;

    @ManyToOne  //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_torneo")
    private Torneo torneo;

    public Arbitro() {
    }

    public Arbitro(String documento, String nombre, String apellidos, String genero, String celular, String deporte) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.celular = celular;
        this.deporte = deporte;
    }

    public Arbitro(String documento, String nombre, String apellidos, String genero, String celular, String deporte, ColegioArbitral colegioArbitral) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.celular = celular;
        this.deporte = deporte;
        this.colegioArbitral = colegioArbitral;
    }

    public Arbitro(String documento, String nombre, String apellidos, String genero, String celular, String deporte, Torneo torneo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.celular = celular;
        this.deporte = deporte;
        this.torneo = torneo;
    }

    public Arbitro(String documento, String nombre, String apellidos, String genero, String celular, String deporte, ColegioArbitral colegioArbitral, Torneo torneo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.celular = celular;
        this.deporte = deporte;
        this.colegioArbitral = colegioArbitral;
        this.torneo = torneo;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public ColegioArbitral getColegioArbitral() {
        return colegioArbitral;
    }

    public void setColegioArbitral(ColegioArbitral colegioArbitral) {
        this.colegioArbitral = colegioArbitral;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero='" + genero + '\'' +
                ", celular='" + celular + '\'' +
                ", deporte='" + deporte + '\'' +
                '}';
    }
}
