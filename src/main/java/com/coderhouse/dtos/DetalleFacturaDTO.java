package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(description = "DTO para Detalle de Factura")
public class DetalleFacturaDTO {

    @Schema(description = "Nombre del producto", example = "Smartphone", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreProducto;

    @Schema(description = "Cantidad del producto", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer cantidad;

    @Schema(description = "Precio unitario del producto", example = "299.99", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal precioUnitario;

    @Schema(description = "Subtotal del detalle de factura", example = "599.98", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal subtotal;

    // Constructores
    public DetalleFacturaDTO() {}

    public DetalleFacturaDTO(String nombreProducto, Integer cantidad, BigDecimal precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    public DetalleFacturaDTO(String nombreProducto, Integer cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    // Getters y Setters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
