package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Menu;

public interface IMenuRepo extends JpaRepository<Menu, Integer>{
	

}
