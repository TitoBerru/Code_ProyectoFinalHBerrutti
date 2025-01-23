package com.coderhouse.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreProducto;
    
    @Column(length = 500)
	private String descripcionProducto;

    @Column(length = 50)
	private String categoriaProducto;

	@Column(length = 50)
	private String marcaProducto;

	@Column(length = 100)
	private String proveedorProducto;

	@Column(length = 200)
	private String imgUrlProducto;

	private int precioCompraProducto;

    @Column(nullable = false)
    private BigDecimal precioVentaProducto;
    
    private int descuentoProducto;

	@Column(length = 3)
	private String monedaProducto;

	private LocalDate fechaAltaProducto;
	
	private LocalDate fechaModificacionProducto;

	@Column(nullable = false)
	private boolean estadoActivoProducto;


    @Column(nullable = false)
    private Integer cantidadStockProducto;


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
		// TODO Auto-generated constructor stub
	}
public Producto(Long id, String nombreProducto, String descripcionProducto, String categoriaProducto,
		String marcaProducto, String proveedorProducto, String imgUrlProducto, int precioCompraProducto,
		BigDecimal precioVentaProducto, int descuentoProducto, String monedaProducto, LocalDate fechaAltaProducto,
		LocalDate fechaModificacionProducto, boolean estadoActivoProducto, Integer cantidadStockProducto,
		List<DetalleFactura> detallesFactura) {
	super();
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