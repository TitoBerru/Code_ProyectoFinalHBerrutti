package com.coderhouse.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Schema(description = "Modelo de Factura")
@Entity
@Table(name = "facturas")
public class Factura {

    @Schema(description = "Id de la factura, generado automáticamente por la base de datos", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Número de la factura, único y generado automáticamente", example = "F123456", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false, unique = true)
    private String numeroFactura;

    @Schema(description = "ID del cliente asociado a la factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Schema(description = "Detalles de la factura")
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DetalleFactura> detalles = new ArrayList<>();

    @Schema(description = "Fecha de emisión de la factura", example = "2025-01-17T00:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private LocalDateTime fechaEmision;

    @Schema(description = "Total de la factura", example = "999.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private BigDecimal totalFactura;

    @Schema(description = "Nombre del cliente", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private String nombreCliente;
    
    @Schema(description = "Apellido del cliente", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private String apellidoCliente;
    
    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private String direccionCliente;
    
    @Schema(description = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private String dniCliente;

    // Métodos de negocio
    public void calcularTotal() {
        this.totalFactura = detalles.stream()
            .map(DetalleFactura::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void copiarDatosCliente() {
        this.nombreCliente = cliente.getNombre();
        this.apellidoCliente = cliente.getApellido();
        this.direccionCliente = cliente.getDireccion();
        this.dniCliente = String.valueOf(cliente.getDni());
    }

    // Constructor
    public Factura() {
        super();
    }

    public Factura(Long id, String numeroFactura, Cliente cliente, List<DetalleFactura> detalles,
                   LocalDateTime fechaEmision, BigDecimal totalFactura, String nombreCliente, String apellidoCliente,
                   String direccionCliente, String dniCliente) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.detalles = detalles;
        this.fechaEmision = fechaEmision;
        this.totalFactura = totalFactura;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.dniCliente = dniCliente;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @JsonIgnore
    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(BigDecimal totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    @Override
    public String toString() {
        return "Factura [id=" + id + ", numeroFactura=" + numeroFactura + ", cliente=" + cliente + ", detalles="
                + detalles + ", fechaEmision=" + fechaEmision + ", totalFactura=" + totalFactura + ", nombreCliente="
                + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", direccionCliente=" + direccionCliente
                + ", dniCliente=" + dniCliente + "]";
    }
}
