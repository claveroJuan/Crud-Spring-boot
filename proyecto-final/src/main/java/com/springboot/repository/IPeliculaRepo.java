package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Pelicula;

public interface IPeliculaRepo extends JpaRepository<Pelicula, Integer>{
	

}