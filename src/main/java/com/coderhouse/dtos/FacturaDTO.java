package com.coderhouse.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class FacturaDTO {
	private Long id;
    private String numeroFactura;
    private Long clienteId;
    private String nombreCliente;
    private String direccionCliente;
    private LocalDateTime fechaEmision;
    private BigDecimal totalFactura;
    private List<DetalleFacturaDTO> detalles;

    // Constructores
    
	public FacturaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaDTO(String numeroFactura, Long clienteId, String nombreCliente, String direccionCliente, LocalDateTime fechaEmision, BigDecimal totalFactura, List<DetalleFacturaDTO> detalles) {
        this.numeroFactura = numeroFactura;
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.fechaEmision = fechaEmision;
        this.totalFactura = totalFactura;
        this.detalles = detalles;
    }
	
	// Constructor, getters y setters

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public BigDecimal getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	public List<DetalleFacturaDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFacturaDTO> detalles) {
		this.detalles = detalles;
	}
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    
    
    
}