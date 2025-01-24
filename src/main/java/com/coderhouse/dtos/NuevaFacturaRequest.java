package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "DTO para una nueva solicitud de factura")
public class NuevaFacturaRequest {

    @Schema(description = "ID del cliente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long clienteId;

    @Schema(description = "Lista de detalles del producto", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DetalleProductoRequest> detalles;

    public static class DetalleProductoRequest {

        @Schema(description = "ID del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long productoId;

        @Schema(description = "Cantidad del producto", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer cantidad;

        // Constructores
        public DetalleProductoRequest() {
            super();
        }

        public DetalleProductoRequest(Long productoId, Integer cantidad) {
            this.productoId = productoId;
            this.cantidad = cantidad;
        }

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

    // Constructores 
    public NuevaFacturaRequest() {
        super();
    }

    public NuevaFacturaRequest(Long clienteId, List<DetalleProductoRequest> detalles) {
        this.clienteId = clienteId;
        this.detalles = detalles;
    }

    // Getters y Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<DetalleProductoRequest> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleProductoRequest> detalles) {
        this.detalles = detalles;
    }
}
