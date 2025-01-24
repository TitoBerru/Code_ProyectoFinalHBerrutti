package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "DTO para Factura")
public class FacturaDTO {

    @Schema(description = "Id de la factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Número de la factura", example = "F123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String numeroFactura;

    @Schema(description = "ID del cliente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long clienteId;

    @Schema(description = "Nombre del cliente", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreCliente;

    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123", requiredMode = Schema.RequiredMode.REQUIRED)
    private String direccionCliente;

    @Schema(description = "Fecha de emisión de la factura", example = "2025-01-17T00:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime fechaEmision;

    @Schema(description = "Total de la factura", example = "999.99", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal totalFactura;

    @Schema(description = "Detalles de la factura", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DetalleFacturaDTO> detalles;

    // Constructores
    public FacturaDTO() {
        super();
    }

    public FacturaDTO(String numeroFactura, Long clienteId, String nombreCliente, String direccionCliente, LocalDateTime fechaEmision, BigDecimal totalFactura, List<DetalleFacturaDTO> detalles) {
        this.numeroFactura = numeroFactura;
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.fechaEmision = fechaEmision;
        this.totalFactura = totalFactura;
        this.detalles = detalles;
    }

    // Getters y Setters
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
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

    public List<DetalleFacturaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaDTO> detalles) {
        this.detalles = detalles;
    }
}
