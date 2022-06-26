package co.edu.sena.escenarios.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deportista")
public class Deportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento")
    private String documento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo")
    private String correo;

    @Column(name = "RH")
    private String rh;

    @Column(name = "EPS")
    private String eps;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
   // private LocalDate fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    @ManyToOne  //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_equipo")
    private Equipo equipo;

    public Deportista() {
    }

    public Deportista(String documento, String nombre, String apellidos, String direccion, String celular, String correo, String rh, String eps, String fechaNacimiento, String genero) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.rh = rh;
        this.eps = eps;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Deportista(String documento, String nombre, String apellidos, String direccion, String celular, String correo, String rh, String eps, String fechaNacimiento, String genero, Equipo equipo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.rh = rh;
        this.eps = eps;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        return "Deportista{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", celular='" + celular + '\'' +
                ", correo='" + correo + '\'' +
                ", rh='" + rh + '\'' +
                ", eps='" + eps + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                '}';
    }
}
