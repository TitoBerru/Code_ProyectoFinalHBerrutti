package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(description = "DTO para Producto")
public class ProductoDTO {

    @Schema(description = "Nombre del producto", example = "Smartphone", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreProducto;

    @Schema(description = "Precio de venta del producto", example = "599.99", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal precioVentaProducto;

    @Schema(description = "Cantidad en stock del producto", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer cantidadStockProducto;

    // Constructores
    public ProductoDTO() {
        super();
    }

    public ProductoDTO(String nombreProducto, BigDecimal precioVentaProducto, Integer cantidadStockProducto) {
        this.nombreProducto = nombreProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.cantidadStockProducto = cantidadStockProducto;
    }

    // Getters y Setters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(BigDecimal precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public Integer getCantidadStockProducto() {
        return cantidadStockProducto;
    }

    public void setCantidadStockProducto(Integer cantidadStockProducto) {
        this.cantidadStockProducto = cantidadStockProducto;
    }
}
