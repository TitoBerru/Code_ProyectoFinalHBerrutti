package com.coderhouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.ClienteDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.repositories.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	// Obtener todos los clientes
	public List<Cliente> getAllClientes(){
		
		return clienteRepository.findAll();
	}
	//Obtener cliente by id
	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}
	// Crear Cliente
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	// Editar Cliente

	@Transactional
	public Cliente updateClienteById(Long id, ClienteDTO clienteDTO) {
	    Cliente clienteExistente = clienteRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

	    // Actualizar campos
	    if (clienteDTO.getNombre() != null) clienteExistente.setNombre(clienteDTO.getNombre());
	    if (clienteDTO.getApellido() != null) clienteExistente.setApellido(clienteDTO.getApellido());
	    if (clienteDTO.getDireccion() != null) clienteExistente.setDireccion(clienteDTO.getDireccion());
	    if (clienteDTO.getEmail() != null && !clienteDTO.getEmail().isEmpty()) clienteExistente.setEmail(clienteDTO.getEmail());
	    if (clienteDTO.getDni() > 0) clienteExistente.setDni(clienteDTO.getDni());

	    // Retornar cliente actualizado
	    return clienteRepository.save(clienteExistente);
	}

	// Borrar cliente
	public void deleteClienteById(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		clienteRepository.deleteById(id);
		
	}
	
	
}
