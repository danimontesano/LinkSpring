package com.utn.tp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class PromocionMedioDePago extends Promocion {
	
	@Enumerated(EnumType.STRING)
	private MetodoDePago metodoDePago;

	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public PromocionMedioDePago(TipoDescuento tipoDescuento, Float valorFloat, Boolean estaActivo,
			MetodoDePago metodoDePago) {
		super(tipoDescuento, valorFloat, estaActivo);
		this.metodoDePago = metodoDePago;
	}

	public PromocionMedioDePago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromocionMedioDePago(TipoDescuento tipoDescuento, Float valorFloat, Boolean estaActivo) {
		super(tipoDescuento, valorFloat, estaActivo);
		// TODO Auto-generated constructor stub
	}

}
