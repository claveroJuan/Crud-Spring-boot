package com.springboot.exception;

import java.time.LocalDateTime;

public class ExceptionResponse extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime timestamp;
	private String mensaje;
	private String detalles;	
	
	public ExceptionResponse(LocalDateTime timestamp, String mensaje, String detalles) {		
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	
}

