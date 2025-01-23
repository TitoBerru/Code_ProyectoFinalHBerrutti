package com.coderhouse.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DetalleFactura> detalles = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime fechaEmision;

    @Column(nullable = false)
    private BigDecimal totalFactura;

    // Datos del cliente 
    @Column(nullable = false)
    private String nombreCliente;
    
    @Column(nullable = false)
    private String apellidoCliente;
    
    @Column(nullable = false)
    private String direccionCliente;
    
    @Column(nullable = false)
    private String dniCliente;


    // Métodos de negocio
    public void calcularTotal() {
        this.totalFactura = detalles.stream()
            .map(DetalleFactura::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void copiarDatosCliente() {
        this.nombreCliente = cliente.getNombre();
        this.apellidoCliente = cliente.getApellido();
        this.direccionCliente = cliente.getDireccion();
        this.dniCliente = String.valueOf(cliente.getDni());
    }
    // Constructor

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura(Long id, String numeroFactura, Cliente cliente, List<DetalleFactura> detalles,
			LocalDateTime fechaEmision, BigDecimal totalFactura, String nombreCliente, String apellidoCliente,
			String direccionCliente, String dniCliente) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.cliente = cliente;
		this.detalles = detalles;
		this.fechaEmision = fechaEmision;
		this.totalFactura = totalFactura;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
		this.dniCliente = dniCliente;
	}
	 // Getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@JsonIgnore
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", numeroFactura=" + numeroFactura + ", cliente=" + cliente + ", detalles="
				+ detalles + ", fechaEmision=" + fechaEmision + ", totalFactura=" + totalFactura + ", nombreCliente="
				+ nombreCliente + ", apellidoCliente=" + apellidoCliente + ", direccionCliente=" + direccionCliente
				+ ", dniCliente=" + dniCliente + "]";
	}
   
   
	
}