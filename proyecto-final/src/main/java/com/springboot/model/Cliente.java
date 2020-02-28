package com.springboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;
	@Column(name = "nombre", nullable = false, unique = true, length = 80)
	private String nombres;
	@Column(name = "apellidos", nullable = false, length = 80)
	private String apellidos;
	@Column(name = "fechaNac")
	private LocalDate fechaNac;
	@Column(name = "dni", nullable = false, unique = true, length = 8)
	private String dni;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Venta> ventas;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNac="
				+ fechaNac + ", dni=" + dni + "]";
	}

}
