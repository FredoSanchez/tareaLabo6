package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (schema="public", name="importancia")
public class Importancia {
	
	@Id
	@Column (name = "c_importancia")
	private Integer cImportancia;
	
	@Column (name = "s_importancia")
	private String sImportancia;
	
	@OneToMany(mappedBy="importancia", fetch=FetchType.EAGER)
	private List<Contribuyente> contribuyentes;
	
	public Importancia() {
		super();
	}

	public Integer getcImportancia() {
		return cImportancia;
	}

	public void setcImportancia(Integer cImportancia) {
		this.cImportancia = cImportancia;
	}

	public String getsImportancia() {
		return sImportancia;
	}

	public void setsImportancia(String sImportancia) {
		this.sImportancia = sImportancia;
	}
	
	
}
