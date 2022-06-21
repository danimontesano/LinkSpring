package com.utn.tp.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Comprador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usuario_id")
	private UUID id;

	@MapsId
	@JoinColumn(name = "usuario_id", columnDefinition = "BINARY(16)")
	@OneToOne(optional = false)
	@JsonIgnoreProperties("comprador")
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	private Integer numeroDocumento;

	@OneToMany
	@JoinColumn(name = "comprador_id")
	private List<ItemProducto> carritoCompras;

	@OneToMany(mappedBy = "comprador")
	@JsonIgnoreProperties("comprador")
	private List<OrdenDeCompra> historialDeCompras;

//	private List<MetodoDePago> metodosDePago;

	

	public Comprador(Usuario usuario, TipoDocumento tipoDocumento, Integer numeroDocumento, List<ItemProducto> carritoCompras,
			List<OrdenDeCompra> historialDeCompras) {
		super();
		this.usuario = usuario;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.carritoCompras = carritoCompras;
		this.historialDeCompras = historialDeCompras;
	}
	
	public Comprador() {
		super();
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public List<ItemProducto> getCarritoCompras() {
		return carritoCompras;
	}

	public void setCarritoCompras(List<ItemProducto> carritoCompras) {
		this.carritoCompras = carritoCompras;
	}

	public List<OrdenDeCompra> getHistorialDeCompras() {
		return historialDeCompras;
	}

	public void setHistorialDeCompras(List<OrdenDeCompra> historialDeCompras) {
		this.historialDeCompras = historialDeCompras;
	}
//
//	public List<MetodoDePago> getMetodosDePago() {
//		return metodosDePago;
//	}
//
//	public void setMetodosDePago(List<MetodoDePago> metodosDePago) {
//		this.metodosDePago = metodosDePago;
//	}

}
