package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Genero;

public interface IGeneroRepo extends JpaRepository<Genero, Integer>{
	

}
