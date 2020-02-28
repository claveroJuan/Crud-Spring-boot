package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
Usuario findByUsername(String username);
}

