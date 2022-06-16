package com.utn.tp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author DM_E91222
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Promocion {
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private TipoDescuento tipoDescuento;
	
	private Float valorFloat;
	
	private Boolean estaActivo;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDescuento getTipoDescuento() {
		return tipoDescuento;
	}

	public void setTipoDescuento(TipoDescuento tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}

	public Float getValorFloat() {
		return valorFloat;
	}

	public void setValorFloat(Float valorFloat) {
		this.valorFloat = valorFloat;
	}
	
	public Boolean getEstaActivo() {
		return estaActivo;
	}
	
	public void setEstaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public Promocion(TipoDescuento tipoDescuento, Float valorFloat, Boolean estaActivo) {
		super();
		this.tipoDescuento = tipoDescuento;
		this.valorFloat = valorFloat;
		this.estaActivo = estaActivo;
	}

	public Promocion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
