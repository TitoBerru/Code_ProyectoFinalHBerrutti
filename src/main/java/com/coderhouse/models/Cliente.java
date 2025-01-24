package com.coderhouse.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Modelo de Cliente")
@Entity
@Table(name = "clientes")
public class Cliente {

    @Schema(description = "Id de Cliente, generado automáticamente por la base de datos", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Schema(description = "Nombre del cliente", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false, length = 100)
    private String nombre;

    @Schema(description = "Apellido del cliente", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false, length = 100)
    private String apellido;

    @Schema(description = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false, unique = true)
    private int dni;

    @Schema(description = "Email del cliente", example = "juan.perez@example.com")
    @Column(unique = true, length = 100)
    private String email;

    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable=false, length = 150)
    private String direccion;

    @Schema(description = "Localidad del cliente", example = "CABA")
    @Column(length = 100)
    private String localidad;

    @Schema(description = "Provincia del cliente", example = "Buenos Aires")
    @Column(length = 100)
    private String provincia;

    @Schema(description = "Fecha de nacimiento del cliente", example = "1990-01-01")
    @Column
    private Date fechaNac;

    @Schema(description = "Fecha de registro del cliente")
    private LocalDate fechaRegistro;

    @Schema(description = "Fecha de modificación del registro del cliente")
    private LocalDate fechaModificacionRegistro;

    @Schema(description = "Estado activo del cliente", example = "true")
    private boolean estadoActivo;

    @Schema(description = "Fecha de creación del cliente")
    private LocalDateTime createdAt;

    // Constructores, Getters y Setters

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nombre, String apellido, int dni, String email, String direccion, String localidad,
            String provincia, Date fechaNac, LocalDate fechaRegistro, LocalDate fechaModificacionRegistro,
            boolean estadoActivo, LocalDateTime createdAt) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.fechaNac = fechaNac;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacionRegistro = fechaModificacionRegistro;
        this.estadoActivo = estadoActivo;
        this.createdAt = createdAt;
    }

    // Getters y Setters
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaModificacionRegistro() {
        return fechaModificacionRegistro;
    }

    public void setFechaModificacionRegistro(LocalDate fechaModificacionRegistro) {
        this.fechaModificacionRegistro = fechaModificacionRegistro;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email="
                + email + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
                + ", fechaNac=" + fechaNac + ", fechaRegistro=" + fechaRegistro + ", fechaModificacionRegistro="
                + fechaModificacionRegistro + ", estadoActivo=" + estadoActivo + ", createdAt=" + createdAt + "]";
    }
}
