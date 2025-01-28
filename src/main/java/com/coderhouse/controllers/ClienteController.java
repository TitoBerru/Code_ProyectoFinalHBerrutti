package com.coderhouse.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.dtos.ClienteDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Tag(name = "Clientes", description = "API para la gestión de clientes")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @Operation(summary = "Obtener todos los clientes", description = "Obtiene una lista de todos los clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        try {
            List<Cliente> clientes = clienteService.getAllClientes();
            return ResponseEntity.ok(clientes); // 200
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
    
    @Operation(summary = "Obtener un cliente por ID", description = "Obtiene un cliente específico por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado con éxito"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteByID(@PathVariable Long id){
        try {
            Cliente cliente = clienteService.findById(id);
            return ResponseEntity.ok(cliente); // 200
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();  // 404
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
    
    @Operation(summary = "Crear un nuevo cliente", description = "Crea un nuevo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente creado con éxito"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/create")
    public ResponseEntity<?> createCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
        	Cliente cliente = new Cliente();
        	
        	cliente.setNombre(clienteDTO.getNombre());
        	cliente.setApellido(clienteDTO.getApellido());
        	cliente.setDni(clienteDTO.getDni());
        	cliente.setEmail(clienteDTO.getEmail());
        	cliente.setDireccion(clienteDTO.getDireccion());
        	
            Cliente clienteCreado = clienteService.saveCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
        }
        catch(DataIntegrityViolationException  e) {
        	String errorMessage = "Error: Violación de restricción de integridad - Duplicado de DNI o email.";
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
    
    @Operation(summary = "Editar un cliente por ID", description = "Edita un cliente específico por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente editado con éxito"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editClienteById(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente clienteActualizado = clienteService.updateClienteById(id, clienteDTO);
            return ResponseEntity.ok(clienteActualizado); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
    
    @Operation(summary = "Borrar un cliente por ID", description = "Borra un cliente específico por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente borrado con éxito"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id){
        try {
            clienteService.deleteClienteById(id);
            return ResponseEntity.noContent().build(); // 204
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();  // 404
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
}
