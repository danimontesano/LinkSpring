package com.utn.tp.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue//(generator = "UUID")
//    @GenericGenerator(
//        name = "UUID",
//        strategy = "org.hibernate.id.UUIDGenerator"
//    )
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;

	private String nombre;

	private String apellido;

	@OneToOne
	private Direccion direccion;

//	private Sesion sesion;

	@OneToOne(mappedBy = "usuario", optional = true, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnoreProperties("usuario")
	private Vendedor vendedor;

	@OneToOne(mappedBy = "usuario", optional = true, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnoreProperties("usuario")
	private Comprador comprador;

//	private Administrador admin;
//
//    //private Perfil perfil; //comprador  ->  vendedor
//	
	
	public Usuario() {
		super();
	}
	

	public Usuario(String nombre, String apellido, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}


	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
		// this.vendedor.setUsuario(this);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
