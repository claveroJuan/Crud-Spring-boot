package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.DetalleVenta;

public interface IDetalleVentaRepo extends JpaRepository<DetalleVenta, Integer>{
	

}
