package com.coderhouse.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coderhouse.service.FacturacionService;
import com.coderhouse.dtos.NuevaFacturaRequest;
import com.coderhouse.dtos.FacturaDTO;

@RestController
@RequestMapping("/api/v1/compras")
public class FacturacionController {
    private final FacturacionService facturacionService;

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> crearFactura(@RequestBody NuevaFacturaRequest request) {
        return ResponseEntity.ok(facturacionService.crearFactura(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable Long id) {
        return ResponseEntity.ok(facturacionService.obtenerFactura(id));
    }
}