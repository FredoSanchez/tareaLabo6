package com.uca.capas.dao;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Importancia;


public interface ImportanciaDAO {
	public Importancia findOne(Integer code) throws DataAccessException;
}