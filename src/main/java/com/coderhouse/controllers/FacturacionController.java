package com.coderhouse.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coderhouse.service.FacturacionService;
import com.coderhouse.dtos.NuevaFacturaRequest;
import com.coderhouse.dtos.FacturaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Tag(name = "Compras", description = "API para la gestión de compras de productos")
@RestController
@RequestMapping("/api/v1/compras")
public class FacturacionController {

    private final FacturacionService facturacionService;

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @Operation(summary = "Realizar una Compra", description = "Realizar una compra, generarando una nueva factura a partir de la solicitud proporcionada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Factura creada con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<FacturaDTO> crearFactura(@RequestBody NuevaFacturaRequest request) {
        return ResponseEntity.ok(facturacionService.crearFactura(request));
    }

    @Operation(summary = "Obtener una compra/factura por ID", description = "Obtiene una factura específica por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Factura encontrada con éxito"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable Long id) {
        return ResponseEntity.ok(facturacionService.obtenerFactura(id));
    }
}
