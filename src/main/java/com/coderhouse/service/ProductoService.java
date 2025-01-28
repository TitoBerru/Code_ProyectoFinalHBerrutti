package com.coderhouse.service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.ProductoDTO;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {
		@Autowired
		private ProductoRepository productoRepository;
		
		//Todos los productos
		public List<Producto> getAllProductos(){
			return productoRepository.findAll();
		}
		
		//Obtener 1 producto por Id
		public Producto findById(Long id) {
			return productoRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
		}
		
		// Guardar 1 producto
		@Transactional
		public Producto createProducto(ProductoDTO productoDTO) {
		    Producto producto = new Producto();
		    producto.setNombreProducto(productoDTO.getNombreProducto());
		    producto.setPrecioVentaProducto(productoDTO.getPrecioVentaProducto());
		    producto.setCantidadStockProducto(productoDTO.getCantidadStockProducto());
		    
		    return productoRepository.save(producto);
		}
		// Editar producto
		@Transactional
		public Producto updateProductoById(Long id, ProductoDTO productoDTO) {
		    Producto productoEncontrado = productoRepository.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

		    if (productoDTO.getNombreProducto() != null && !productoDTO.getNombreProducto().isEmpty()) {
		        productoEncontrado.setNombreProducto(productoDTO.getNombreProducto());
		    }
		    if (productoDTO.getDescripcionProducto() != null && !productoDTO.getDescripcionProducto().isEmpty()) {
		        productoEncontrado.setDescripcionProducto(productoDTO.getDescripcionProducto());
		    }
		    if (productoDTO.getCategoriaProducto() != null && !productoDTO.getCategoriaProducto().isEmpty()) {
		        productoEncontrado.setCategoriaProducto(productoDTO.getCategoriaProducto());
		    }
		    if (productoDTO.getMarcaProducto() != null && !productoDTO.getMarcaProducto().isEmpty()) {
		        productoEncontrado.setMarcaProducto(productoDTO.getMarcaProducto());
		    }
		    if (productoDTO.getProveedorProducto() != null && !productoDTO.getProveedorProducto().isEmpty()) {
		        productoEncontrado.setProveedorProducto(productoDTO.getProveedorProducto());
		    }
		    if (productoDTO.getImgUrlProducto() != null && !productoDTO.getImgUrlProducto().isEmpty()) {
		        productoEncontrado.setImgUrlProducto(productoDTO.getImgUrlProducto());
		    }
		    if (productoDTO.getPrecioCompraProducto() != null && productoDTO.getPrecioCompraProducto().compareTo(BigDecimal.ZERO) > 0) {
		        productoEncontrado.setPrecioCompraProducto(productoDTO.getPrecioCompraProducto());
		    }
		    if (productoDTO.getPrecioVentaProducto() != null && productoDTO.getPrecioVentaProducto().compareTo(BigDecimal.ZERO) > 0) {
		        productoEncontrado.setPrecioVentaProducto(productoDTO.getPrecioVentaProducto());
		    }
		    if (productoDTO.getDescuentoProducto() != null && productoDTO.getDescuentoProducto() >= 0) {
		        productoEncontrado.setDescuentoProducto(productoDTO.getDescuentoProducto());
		    }
		    if (productoDTO.getMonedaProducto() != null && !productoDTO.getMonedaProducto().isEmpty()) {
		        productoEncontrado.setMonedaProducto(productoDTO.getMonedaProducto());
		    }
		    if (productoDTO.getCantidadStockProducto() != null && productoDTO.getCantidadStockProducto() >= 0) {
		        productoEncontrado.setCantidadStockProducto(productoDTO.getCantidadStockProducto());
		    }
		    if (productoDTO.getEstadoActivoProducto() != null) {
		        productoEncontrado.setEstadoActivoProducto(productoDTO.getEstadoActivoProducto());
		    }

		    return productoRepository.save(productoEncontrado);
		}

		
		// Borrar Producto
		public void deleteProductoById(Long id) {
			if(!productoRepository.existsById(id)) {
				throw new IllegalArgumentException("Producto no encontrado");
			}
			productoRepository.deleteById(id);
			
		}
}
