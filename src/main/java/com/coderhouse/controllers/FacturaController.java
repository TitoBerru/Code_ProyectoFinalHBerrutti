package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.FacturaDTO;
import com.coderhouse.models.Factura;
import com.coderhouse.service.FacturaService;
import com.coderhouse.service.FacturacionService;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	@Autowired
    private FacturacionService facturacionService;
	
	// Obtener todas las facturas con detalles
	@GetMapping
	 public ResponseEntity<List<FacturaDTO>> getAllFacturas() {
        try {
            List<FacturaDTO> facturas = facturacionService.obtenerTodasLasFacturas();
            return ResponseEntity.ok(facturas); // 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
	// Obtener Factura por Id con detalles
	@GetMapping("/{id}")
	public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable Long id) {
        try {
            FacturaDTO factura = facturacionService.obtenerFactura(id);
            return ResponseEntity.ok(factura); // 200
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
	}
    
	
	// Crear Factura
	@PostMapping("/create")
	public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
		try {
			Factura facturaCreada = facturaService.crearFactura(factura);
			return ResponseEntity.status(HttpStatus.CREATED).body(facturaCreada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
	
		
	// Borrar Factura
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFacturaById(@PathVariable Long id) {
		try {
			facturaService.eliminarFactura(id);
			return ResponseEntity.noContent().build(); // 400
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
}
