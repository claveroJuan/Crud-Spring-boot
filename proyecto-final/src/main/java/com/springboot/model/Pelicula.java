package com.springboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPelicula;

	@Column(name = "nombre", nullable = false, unique = true, length = 255)
	private String nombre;

	@Column(name = "resena", nullable = false, length = 255)
	private String resena;

	@Column(name = "urlPortada", nullable = false, length = 255)
	private String urlPortada;

	@Column(name = "duracion", nullable = false, length = 3)
	private short duracion;

	@Column(name = "fechaPublicacion", nullable = false)
	private LocalDate fechaPublicacion;

	@OneToMany(mappedBy = "pelicula", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Venta> ventas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genero_id")
	private Genero genero;

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public short getDuracion() {
		return duracion;
	}

	public void setDuracion(short duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getUrlPortada() {
		return urlPortada;
	}

	public void setUrlPortada(String urlPortada) {
		this.urlPortada = urlPortada;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombre=" + nombre + ", resena=" + resena + ", duracion="
				+ duracion + ", fechaPublicacion=" + fechaPublicacion + ", urlPortada=" + urlPortada + "]";
	}

}
