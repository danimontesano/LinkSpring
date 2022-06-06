package com.utn.tp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Vendedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usuario_id")
	private Integer id;

	@MapsId
	@JoinColumn(name = "usuario_id")
	@OneToOne(optional = false)
	@JsonIgnoreProperties("vendedor")
	private Usuario usuario;
	
	private String razonSocial;
	
	private String cuit;
	

	@ManyToMany
	@JoinTable(
	name = "vendedores_proveedores", 
	joinColumns = @JoinColumn(name = "vendedor_id"), 
	inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
	private List<Proveedor> proveedores;

	@OneToMany(mappedBy = "vendedor")
	@JsonIgnoreProperties("vendedor")
	private List<Producto> productos;
	
//	private List<OrdenDeCompra> historialDeVentas;
	
	
	
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		//this.id = usuario.getId();
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
