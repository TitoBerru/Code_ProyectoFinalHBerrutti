package com.coderhouse.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.coderhouse.models.*;
import com.coderhouse.repositories.*;
import com.coderhouse.dtos.*;
import com.coderhouse.utils.FacturaNumberGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturacionService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private FacturaNumberGenerator numberGenerator;
    
    @Autowired
    private TimeApiService timeApiService; // Esto asegura que sea gestionado por Spring

    @Transactional
    public FacturaDTO crearFactura(NuevaFacturaRequest request) {
       
        // Buscar cliente
        Cliente cliente = clienteRepository.findById(request.getClienteId())
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear factura
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setNumeroFactura(numberGenerator.generateNextNumber());
        factura.setFechaEmision(timeApiService.getCurrentTime());

        // Copiar datos del cliente
        factura.copiarDatosCliente();

        // Procesar detalles
        List<DetalleFactura> detalles = new ArrayList<>();
        BigDecimal totalFactura = BigDecimal.ZERO;

        for (NuevaFacturaRequest.DetalleProductoRequest detalle : request.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
            // Validaciones y logs
            System.out.println("producto encontrado: " + producto);
            BigDecimal precioVentaProducto = producto.getPrecioVentaProducto();
            if (precioVentaProducto == null) {
                System.out.println("El precio de venta del producto es nulo.");
                throw new RuntimeException("El producto " + producto.getNombreProducto() + " no tiene un precio de venta asignado.");
            } else {
                System.out.println("Precio de venta del producto: " + precioVentaProducto);
            }

            if (producto.getCantidadStockProducto() < detalle.getCantidad()) {
                System.out.println("El stock es insuficiente para el producto: " + producto);
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombreProducto());
            } else {
                System.out.println("Stock actualizado: " + detalle.getCantidad());
            }

            // Actualizar stock
            producto.setCantidadStockProducto(producto.getCantidadStockProducto() - detalle.getCantidad());
            productoRepository.save(producto);
            System.out.println("Stock restante: " + producto.getCantidadStockProducto());

            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setFactura(factura);
            detalleFactura.setProducto(producto);
            detalleFactura.setCantidad(detalle.getCantidad());
            detalleFactura.setPrecioUnitario(precioVentaProducto);

            detalleFactura.calcularSubtotal(); 

            BigDecimal subtotal = detalleFactura.getSubtotal(); // Obtener el subtotal calculado

            totalFactura = totalFactura.add(subtotal);

            detalles.add(detalleFactura);
        }

        // Calcular total de la factura
        totalFactura = detalles.stream()
                .map(DetalleFactura::getSubtotal)
                .filter(java.util.Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        factura.setDetalles(detalles); // Agrega los detalles a la entidad Factura
        factura.setTotalFactura(totalFactura);

        // Guardar la factura en la base de datos
        facturaRepository.save(factura);

        // Convertir Factura a FacturaDTO
        return convertToDTO(factura);
    }
   

    public FacturaDTO obtenerFactura(Long id) {
        Factura factura = facturaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        return convertToDTO(factura);
    }

    
    
    public List<FacturaDTO> obtenerTodasLasFacturas() {
        List<Factura> facturas = facturaRepository.findAll();
        return facturas.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    private FacturaDTO convertToDTO(Factura factura) {
        List<DetalleFacturaDTO> detalleFacturaDTOs = factura.getDetalles().stream()
            .map(detalle -> new DetalleFacturaDTO(
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getSubtotal()))
            .collect(Collectors.toList());

        FacturaDTO facturaDTO = new FacturaDTO(
                factura.getNumeroFactura(),
                factura.getCliente().getId(),
                factura.getCliente().getNombre(),
                factura.getCliente().getDireccion(), 
                factura.getFechaEmision(),
                factura.getTotalFactura(),
                detalleFacturaDTOs
            );

            facturaDTO.setId(factura.getId()); 

            return facturaDTO;
        }
}
