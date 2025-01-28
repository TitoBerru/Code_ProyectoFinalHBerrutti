package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "DTO para Producto")
public class ProductoDTO {

    @Schema(description = "Nombre del producto", example = "Smartphone", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombreProducto;

    @Schema(description = "Precio de venta del producto", example = "599.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El precio de venta es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor a 0")
    private BigDecimal precioVentaProducto;

    @Schema(description = "Cantidad en stock del producto", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "La cantidad en stock es obligatoria")
    @Min(value = 1, message = "La cantidad en stock debe ser al menos 1")
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
