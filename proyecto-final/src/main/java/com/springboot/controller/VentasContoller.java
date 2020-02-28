package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.VentaDTO;
import com.springboot.exception.ModeloNotFoundException;
import com.springboot.model.Venta;
import com.springboot.service.impl.VentaServiceImpl;

@CrossOrigin(origins = { "http://localhost:4200" }) // se especifica el dominio, en este caso para la transferencia y
// envío de datos al puerto de angular, es un arreglo
@RestController
@RequestMapping("/ventas")
public class VentasContoller {

	
	@Autowired
	private VentaServiceImpl service;
	
	

	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){
		
		Venta venta = null;
		Map<String, Object> response = new HashMap<>();
		try {
			venta = service.leerPorId(id);
		} catch(DataAccessException e) { //errores por lados del servidor
			response.put("mensaje", "Error al realizar la consulta en la base de datos!"); //colocamos el mensaje de error
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage())); //error mas especifico
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);//error en la bdd
		}
		
		if(venta==null) {
			response.put("mensaje", "la venta ID: ".concat(id.toString().concat(" no existe en la base de datos!"))); //colocamos el mensaje de error
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND); //el codigo de la respuesta
		}
		return new ResponseEntity<Venta>(venta, HttpStatus.OK); //cuando hay ventas
		
		
	}
	
		
	@PostMapping
	public ResponseEntity<Venta> registrar(@Valid @RequestBody VentaDTO ventaDTO) {
		System.out.println(ventaDTO.toString());
		Venta obj=null;
		try {
		 obj = service.registrarTransaccional(ventaDTO);		
		}catch(Exception e) {
			e.getStackTrace();
		}
		return new ResponseEntity<Venta>(obj, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		 List<Venta> lista = service.listar();
		return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta) {
		Venta obj = service.modificar(venta);
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Venta obj = service.leerPorId(id);
		if(obj.getIdVenta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
