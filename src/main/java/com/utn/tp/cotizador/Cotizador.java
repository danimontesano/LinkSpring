package com.utn.tp.cotizador;

public final class Cotizador {
	
	private static Cotizador instance;
	
	public PrecioDolar value;
	
	private Cotizador() {
		this.value = new PrecioDolar();
	}
	
	public static Cotizador getInstancia() {
		if(instance == null) {
			instance = new Cotizador();
		}
		return instance;
	}

}
