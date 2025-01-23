package com.coderhouse.dtos;

import java.util.List;

public class NuevaFacturaRequest {
    private Long clienteId;
    private List<DetalleProductoRequest> detalles;

    public static class DetalleProductoRequest {
        private Long productoId;
        private Integer cantidad;
        
     // Constructores
		public DetalleProductoRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DetalleProductoRequest(Long productoId, Integer cantidad) {
			super();
			this.productoId = productoId;
			this.cantidad = cantidad;
		}
		//getters y setters
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
		// TODO Auto-generated constructor stub
	}

	public NuevaFacturaRequest(Long clienteId, List<DetalleProductoRequest> detalles) {
		super();
		this.clienteId = clienteId;
		this.detalles = detalles;
	}
	 // getters y setters

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