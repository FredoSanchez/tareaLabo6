package com.uca.capas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Importancia importancia = entityManager.find(Importancia.class, code);
		return importancia;
	}

}
