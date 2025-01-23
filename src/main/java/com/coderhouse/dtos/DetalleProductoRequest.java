package com.coderhouse.dtos;

public class DetalleProductoRequest {
    private Long productoId;
    private Integer cantidad;
    // getters y setters
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