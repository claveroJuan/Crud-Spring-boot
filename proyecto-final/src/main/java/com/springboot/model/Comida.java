package com.springboot.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comida")
public class Comida {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcomida;

	@Column(name = "nombre", nullable = false, length = 80)
	private String nombre;
	@Column(name = "precio", nullable = false, length = 2)
	private String precio;
	@Column(name = "foto", nullable = false)
	private byte[] foto;
	
	public Integer getIdcomida() {
		return idcomida;
	}

	public void setIdcomida(Integer idcomida) {
		this.idcomida = idcomida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Comida [idcomida=" + idcomida + ", nombre=" + nombre + ", precio=" + precio + ", foto="
				+ Arrays.toString(foto) + "]";
	}

}
