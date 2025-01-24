package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para Detalle de Producto en una solicitud")
public class DetalleProductoRequest {

    @Schema(description = "ID del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long productoId;

    @Schema(description = "Cantidad del producto", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer cantidad;

    // Getters y Setters
    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
