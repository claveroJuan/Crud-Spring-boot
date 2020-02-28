package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.ModeloNotFoundException;
import com.springboot.model.Usuario;
import com.springboot.service.impl.UsuarioServiceImpl;

@CrossOrigin(origins = { "http://localhost:4200" }) // se especifica el dominio, en este caso para la transferencia y
													// envío de datos al puerto de angular, es un arreglo
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;

	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		 List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id){
		Usuario obj = service.leerPorId(id);
		if(obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK); 
	}

	@GetMapping("/buscar/{username}")
	public ResponseEntity<Usuario> listarPorUsername(@PathVariable("username") String username){
		Usuario obj = service.findByUsername(username);
		if(obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + username);
		}
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK); 
	}

	
	@PostMapping
	public ResponseEntity<?> registrar(@Valid @RequestBody Usuario usuario, BindingResult result) {
		
		Usuario usuarioeNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			usuarioeNew = service.registrar(usuario);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario ha sido creado con éxito!");
		response.put("usuario", usuarioeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario usuario) {
		Usuario obj = service.modificar(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Usuario obj = service.leerPorId(id);
		if(obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>("usuario eliminado",HttpStatus.OK);
	}


}
