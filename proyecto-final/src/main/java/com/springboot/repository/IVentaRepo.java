package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer>{
	

}
