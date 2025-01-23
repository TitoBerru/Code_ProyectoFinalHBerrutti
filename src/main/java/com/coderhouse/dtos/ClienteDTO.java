package com.coderhouse.dtos;

public class ClienteDTO {
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private String direccion;
    
    // Constructores
    
    public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public ClienteDTO(String nombre, String apellido, int dni, String email, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.direccion = direccion;
	}


	// Getter and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    

}