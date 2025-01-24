package com.coderhouse.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Schema(description = "Modelo de Producto")
@Entity
@Table(name = "productos")
public class Producto {

    @Schema(description = "Id del producto, generado automáticamente por la base de datos", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre del producto", example = "Smartphone", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private String nombreProducto;

    @Schema(description = "Descripción del producto", example = "Un smartphone de última generación")
    @Column(length = 500)
    private String descripcionProducto;

    @Schema(description = "Categoría del producto", example = "Electrónica")
    @Column(length = 50)
    private String categoriaProducto;

    @Schema(description = "Marca del producto", example = "MarcaX")
    @Column(length = 50)
    private String marcaProducto;

    @Schema(description = "Proveedor del producto", example = "ProveedorX")
    @Column(length = 100)
    private String proveedorProducto;

    @Schema(description = "URL de la imagen del producto", example = "http://imagen.com/producto.jpg")
    @Column(length = 200)
    private String imgUrlProducto;

    @Schema(description = "Precio de compra del producto", example = "500")
    private int precioCompraProducto;

    @Schema(description = "Precio de venta del producto", example = "599.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private BigDecimal precioVentaProducto;

    @Schema(description = "Descuento del producto", example = "10")
    private int descuentoProducto;

    @Schema(description = "Moneda del precio del producto", example = "USD")
    @Column(length = 3)
    private String monedaProducto;

    @Schema(description = "Fecha de alta del producto", example = "2023-01-01")
    private LocalDate fechaAltaProducto;

    @Schema(description = "Fecha de modificación del producto", example = "2023-01-15")
    private LocalDate fechaModificacionProducto;

    @Schema(description = "Estado activo del producto", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private boolean estadoActivoProducto;

    @Schema(description = "Cantidad de stock del producto", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false)
    private Integer cantidadStockProducto;

    @Schema(description = "Detalles de la factura asociados al producto")
    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<DetalleFactura> detallesFactura;

    // Métodos de negocio
    public void actualizarStock(int cantidad) {
        if (this.cantidadStockProducto < cantidad) {
            throw new IllegalStateException("Stock insuficiente");
        }
        this.cantidadStockProducto -= cantidad;
    }

    // Constructor, getters y setters
    public Producto() {
        super();
    }

    public Producto(Long id, String nombreProducto, String descripcionProducto, String categoriaProducto,
                    String marcaProducto, String proveedorProducto, String imgUrlProducto, int precioCompraProducto,
                    BigDecimal precioVentaProducto, int descuentoProducto, String monedaProducto, LocalDate fechaAltaProducto,
                    LocalDate fechaModificacionProducto, boolean estadoActivoProducto, Integer cantidadStockProducto,
                    List<DetalleFactura> detallesFactura) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.categoriaProducto = categoriaProducto;
        this.marcaProducto = marcaProducto;
        this.proveedorProducto = proveedorProducto;
        this.imgUrlProducto = imgUrlProducto;
        this.precioCompraProducto = precioCompraProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.descuentoProducto = descuentoProducto;
        this.monedaProducto = monedaProducto;
        this.fechaAltaProducto = fechaAltaProducto;
        this.fechaModificacionProducto = fechaModificacionProducto;
        this.estadoActivoProducto = estadoActivoProducto;
        this.cantidadStockProducto = cantidadStockProducto;
        this.detallesFactura = detallesFactura;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getProveedorProducto() {
        return proveedorProducto;
    }

    public void setProveedorProducto(String proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public String getImgUrlProducto() {
        return imgUrlProducto;
    }

    public void setImgUrlProducto(String imgUrlProducto) {
        this.imgUrlProducto = imgUrlProducto;
    }

    public int getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(int precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public BigDecimal getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(BigDecimal precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public int getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(int descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public String getMonedaProducto() {
        return monedaProducto;
    }

    public void setMonedaProducto(String monedaProducto) {
        this.monedaProducto = monedaProducto;
    }

    public LocalDate getFechaAltaProducto() {
        return fechaAltaProducto;
    }

    public void setFechaAltaProducto(LocalDate fechaAltaProducto) {
        this.fechaAltaProducto = fechaAltaProducto;
    }

    public LocalDate getFechaModificacionProducto() {
        return fechaModificacionProducto;
    }

    public void setFechaModificacionProducto(LocalDate fechaModificacionProducto) {
        this.fechaModificacionProducto = fechaModificacionProducto;
    }

    public boolean isEstadoActivoProducto() {
        return estadoActivoProducto;
    }

    public void setEstadoActivoProducto(boolean estadoActivoProducto) {
        this.estadoActivoProducto = estadoActivoProducto;
    }

    public Integer getCantidadStockProducto() {
        return cantidadStockProducto;
    }

    public void setCantidadStockProducto(Integer cantidadStockProducto) {
        this.cantidadStockProducto = cantidadStockProducto;
    }

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", descripcionProducto=" + descripcionProducto
                + ", categoriaProducto=" + categoriaProducto + ", marcaProducto=" + marcaProducto + ", proveedorProducto="
                + proveedorProducto + ", imgUrlProducto=" + imgUrlProducto + ", precioCompraProducto="
                + precioCompraProducto + ", precioVentaProducto=" + precioVentaProducto + ", descuentoProducto="
                + descuentoProducto + ", monedaProducto=" + monedaProducto + ", fechaAltaProducto=" + fechaAltaProducto
                + ", fechaModificacionProducto=" + fechaModificacionProducto + ", estadoActivoProducto="
                + estadoActivoProducto + ", cantidadStockProducto=" + cantidadStockProducto + ", detallesFactura="
                + detallesFactura + "]";
    }
}
