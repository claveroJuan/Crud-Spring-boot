package com.springboot.dto;

import java.util.List;

import com.springboot.model.Comida;
import com.springboot.model.Venta;

public class VentaDTO {

	private Venta venta;
	private List<Comida> lstcomida;
	
	
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<Comida> getLstcomida() {
		return lstcomida;
	}
	public void setLstcomida(List<Comida> lstcomida) {
		this.lstcomida = lstcomida;
	}
	@Override
	public String toString() {
		return "VentaDTO [venta=" + venta + ", lstcomida=" + lstcomida + "]";
	}
	
	
	
}
