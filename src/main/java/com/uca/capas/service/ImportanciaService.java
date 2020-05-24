package com.uca.capas.service;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Importancia;

public interface ImportanciaService {
	public Importancia findOne(Integer code) throws DataAccessException;
}
