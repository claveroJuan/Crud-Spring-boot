package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDetalle;

	@Column(name = "asiento ", nullable = false, length = 3)
	private String asiento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venta_id")
	private Venta venta;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	@Override
	public String toString() {
		return "DetalleVenta [idDetalle=" + idDetalle + ", asiento=" + asiento + "]";
	}

}
