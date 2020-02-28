package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{
	

}
