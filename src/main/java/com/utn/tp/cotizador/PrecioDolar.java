package com.utn.tp.cotizador;

import java.util.Date;

public class PrecioDolar {
	
	private Date fecha;
	
	private Float compra;
	
	private Float venta;
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getCompra() {
		return compra;
	}

	public void setCompra(Float compra) {
		this.compra = compra;
	}

	public Float getVenta() {
		return venta;
	}

	public void setVenta(Float venta) {
		this.venta = venta;
	}

	public PrecioDolar() {
		super();
	}
	
	public void actualizar(Date fecha, Float compra, Float venta) {
		this.fecha = fecha;
		this.compra = compra;
		this.venta = venta;
	}
	
	public static class PrecioDolarDTO {
		
		private String fecha;
		
		private Float compra;
		
		private Float venta;

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public Float getCompra() {
			return compra;
		}

		public void setCompra(Float compra) {
			this.compra = compra;
		}

		public Float getVenta() {
			return venta;
		}

		public void setVenta(Float venta) {
			this.venta = venta;
		}

		public PrecioDolarDTO() {
			super();
		}
	}
	

}
