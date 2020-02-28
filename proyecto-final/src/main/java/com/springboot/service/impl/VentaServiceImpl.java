package com.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.VentaDTO;
import com.springboot.model.Comida;
import com.springboot.model.Venta;
import com.springboot.repository.IVentaRepo;
import com.springboot.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	IVentaRepo repo;

	
	@Override
	public Venta registrar(Venta obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta modificar(Venta obj) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(obj);
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Venta leerPorId(Integer id) {
		// TODO Auto-generated method stub
		 Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

	@Override
	public Venta registrarTransaccional(VentaDTO venta) {
		// TODO Auto-generated method stub 
		List<Comida> lst_comidas = new ArrayList<Comida>();
		Venta ventaFinal= venta.getVenta();
       repo.save(ventaFinal);		
		return ventaFinal ;
	}

}
