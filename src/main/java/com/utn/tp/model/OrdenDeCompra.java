package com.utn.tp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class OrdenDeCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	@JoinColumn(name = "orden_id")
	private List<ItemProducto> productos;
	
	private LocalDate hora;
	
	@ManyToOne
	@JoinColumn(name = "comprador_id")
	@NotNull
	@JsonIgnoreProperties("historialDeCompras")
	private Comprador comprador;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	@NotNull
	@JsonIgnoreProperties("historialDeVentas")
	private Vendedor vendedor;

	public OrdenDeCompra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OrdenDeCompra(List<ItemProducto> productos, LocalDate hora, @NotNull Comprador comprador,
			@NotNull Vendedor vendedor) {
		super();
		this.productos = productos;
		this.hora = hora;
		this.comprador = comprador;
		this.vendedor = vendedor;
	}

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<ItemProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<ItemProducto> productos) {
		this.productos = productos;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
