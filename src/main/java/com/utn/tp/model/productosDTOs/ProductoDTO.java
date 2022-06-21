package com.utn.tp.model.productosDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.tp.model.Vendedor;

public class ProductoDTO {
	private Integer id;
	
	private String nombre;

	private String descripcion;
	
	private String imagen;

	private Float precioDolar;
	
	private Float precioPesos;

	@JsonIgnoreProperties({"usuario", "proveedores", "productos", "historialDeVentas"})
	private Vendedor vendedor;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Float getPrecioDolar() {
		return precioDolar;
	}

	public void setPrecioDolar(Float precioDolar) {
		this.precioDolar = precioDolar;
	}

	public Float getPrecioPesos() {
		return precioPesos;
	}

	public void setPrecioPesos(Float precioPesos) {
		this.precioPesos = precioPesos;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public ProductoDTO(Integer id, String nombre, String descripcion, String imagen, Float precioDolar, Float precioPesos,
			Vendedor vendedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precioDolar = precioDolar;
		this.precioPesos = precioPesos;
		this.vendedor = vendedor;
	}
	
}
