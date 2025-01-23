package com.coderhouse.dtos;

import java.math.BigDecimal;

public class ProductoDTO {
    private String nombreProducto;
    private BigDecimal precioVentaProducto;
    private Integer cantidadStockProducto;
    
 // Constructores
	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

public ProductoDTO(String nombreProducto, BigDecimal precioVentaProducto, Integer cantidadStockProducto) {
	super();
	this.nombreProducto = nombreProducto;
	this.precioVentaProducto = precioVentaProducto;
	this.cantidadStockProducto = cantidadStockProducto;
}

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
    
    //getters y setters

    
}