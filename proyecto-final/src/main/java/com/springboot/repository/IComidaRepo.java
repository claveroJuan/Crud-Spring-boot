package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Comida;

public interface IComidaRepo extends JpaRepository<Comida, Integer>{
	

}
