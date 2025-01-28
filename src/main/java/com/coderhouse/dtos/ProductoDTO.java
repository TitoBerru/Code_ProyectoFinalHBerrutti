package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "DTO para Producto")
public class ProductoDTO {

    @Schema(description = "Nombre del producto", example = "Smartphone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombreProducto;

    @Schema(description = "Descripción del producto", example = "Un smartphone de última generación", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String descripcionProducto;

    @Schema(description = "Categoría del producto", example = "Electrónica", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String categoriaProducto;

    @Schema(description = "Marca del producto", example = "Samsung", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String marcaProducto;

    @Schema(description = "Proveedor del producto", example = "Proveedor XYZ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String proveedorProducto;

    @Schema(description = "URL de la imagen del producto", example = "http://example.com/producto.jpg", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String imgUrlProducto;

    @Schema(description = "Precio de compra del producto", example = "300.00", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de compra debe ser mayor a 0")
    private BigDecimal precioCompraProducto;

    @Schema(description = "Precio de venta del producto", example = "599.99", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor a 0")
    private BigDecimal precioVentaProducto;

    @Schema(description = "Descuento del producto", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Min(value = 0, message = "El descuento no puede ser negativo")
    private Integer descuentoProducto;

    @Schema(description = "Moneda del producto", example = "ARS", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String monedaProducto;

    @Schema(description = "Cantidad en stock del producto", example = "50", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Min(value = 0, message = "La cantidad en stock no puede ser negativa")
    private Integer cantidadStockProducto;

    @Schema(description = "Estado activo del producto", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean estadoActivoProducto;

    // Constructores
    public ProductoDTO() {}

    public ProductoDTO(String nombreProducto, String descripcionProducto, String categoriaProducto, String marcaProducto, String proveedorProducto, String imgUrlProducto, BigDecimal precioCompraProducto, BigDecimal precioVentaProducto, Integer descuentoProducto, String monedaProducto, Integer cantidadStockProducto, Boolean estadoActivoProducto) {
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
        this.cantidadStockProducto = cantidadStockProducto;
        this.estadoActivoProducto = estadoActivoProducto;
    }

    // Getters y Setters
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

    public BigDecimal getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(BigDecimal precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public BigDecimal getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(BigDecimal precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public Integer getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(Integer descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public String getMonedaProducto() {
        return monedaProducto;
    }

    public void setMonedaProducto(String monedaProducto) {
        this.monedaProducto = monedaProducto;
    }

    public Integer getCantidadStockProducto() {
        return cantidadStockProducto;
    }

    public void setCantidadStockProducto(Integer cantidadStockProducto) {
        this.cantidadStockProducto = cantidadStockProducto;
    }

    public Boolean getEstadoActivoProducto() {
        return estadoActivoProducto;
    }

    public void setEstadoActivoProducto(Boolean estadoActivoProducto) {
        this.estadoActivoProducto = estadoActivoProducto;
    }
}
