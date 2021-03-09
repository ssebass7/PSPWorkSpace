package com.uem.resttemplate.modelo.entidad;

public class Coche {
	private int id;
	private String modelo;
	private String matricula;
	private double precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "Coche [id=" + id + ", modelo=" + modelo + ", matricula=" + matricula + ", precio=" + precio + "]";
	}
	
	
	
	
}
