package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Comida;
import com.springboot.repository.IComidaRepo;
import com.springboot.service.IComidaService;

@Service
public class ComidaServiceImpl implements IComidaService {

	@Autowired
	IComidaRepo comidaRepo;
	
	@Override
	public Comida registrar(Comida obj) {
		// TODO Auto-generated method stub
		return comidaRepo.save(obj);
	}

	@Override
	public Comida modificar(Comida obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comida> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comida leerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
