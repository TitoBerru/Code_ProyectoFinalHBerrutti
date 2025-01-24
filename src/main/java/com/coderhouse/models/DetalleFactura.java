package com.coderhouse.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Schema(description = "Modelo de Detalle de Factura")
@Entity
@Table(name = "detalles_factura")
public class DetalleFactura {

    @Schema(description = "Id del detalle de factura, generado automáticamente por la base de datos", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Factura asociada a este detalle")
    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;

    @Schema(description = "Producto incluido en este detalle")
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Schema(description = "Cantidad del producto", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private Integer cantidad;

    @Schema(description = "Precio unitario del producto", example = "99.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @Schema(description = "Subtotal del detalle de factura", example = "199.98", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private BigDecimal subtotal;

    // Constructores
    public DetalleFactura(Long id, Factura factura, Producto producto, Integer cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.id = id;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public DetalleFactura() {
    
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    // Métodos de negocio
    public void calcularSubtotal() {
        this.subtotal = this.precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
               "id=" + id +
               ", producto=" + (producto != null ? producto.getNombreProducto() : "") +
               ", cantidad=" + cantidad +
               ", precioUnitario=" + precioUnitario +
               ", subtotal=" + subtotal +
               '}';
    }
}
