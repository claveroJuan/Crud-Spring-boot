package com.springboot.service;

import com.springboot.dto.VentaDTO;
import com.springboot.model.Venta;

public interface IVentaService extends ICRUD<Venta> {

	public Venta registrarTransaccional(VentaDTO venta);
}
