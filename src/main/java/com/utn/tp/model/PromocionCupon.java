package com.utn.tp.model;

import javax.persistence.Entity;

@Entity
public class PromocionCupon extends Promocion{
	
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public PromocionCupon(TipoDescuento tipoDescuento, Float valor, Boolean estaActivo, String codigo) {
		super(tipoDescuento, valor, estaActivo);
		this.codigo = codigo;
	}

	public PromocionCupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
