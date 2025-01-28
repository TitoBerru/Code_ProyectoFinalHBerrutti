package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;


@Schema(description = "DTO para Cliente")
public class ClienteDTO {

    @Schema(description = "Nombre del cliente", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Schema(description = "Apellido del cliente", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Schema(description = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value = 1, message = "El DNI debe ser mayor que 0")
    private int dni;

    @Schema(description = "Email del cliente", example = "juan.perez@example.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Email(message = "El email debe tener un formato válido")
    private String email;
    
    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    // Constructores
    public ClienteDTO() {
        super();
    }

    public ClienteDTO(String nombre, String apellido, int dni, String email, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.direccion = direccion;
    }

    // Getters y Setters
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
}
