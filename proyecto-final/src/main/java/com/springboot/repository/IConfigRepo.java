package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Config;

public interface IConfigRepo extends JpaRepository<Config, Integer>{
	

}
