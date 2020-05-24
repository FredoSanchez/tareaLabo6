package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "c_contribuyente")
	private Integer cContribuyente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;
	
	@Size(message = "El campo no debe contener mas de 30 caracteres", max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column (name = "s_nombre")
	private String nombre;
	
	@Size(message = "El campo no debe contener mas de 30 caracteres", max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column (name = "s_apellido")
	private String apellido;
	
	@NotEmpty(message="El NIT no puede ir vacio")
	@Pattern(regexp = "^[0-9]{14}$", message = "El NIT debe tener exactamente 14 digitos sin guion")	
	@Column (name = "s_nit")
	private String nit;
	
	@Column (name = "f_fecha_ingreso")
	private String fechaIngreso;
	
	public Contribuyente() {
		super();
	}
	
	public Integer getcContribuyente() {
		return cContribuyente;
	}
	public void setcContribuyente(Integer cContribuyente) {
		this.cContribuyente = cContribuyente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
