package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resulset = query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(contribuyente);
		
		/*
		try {
			if(contribuyente.getcContribuyente()==null) {
				entityManager.persist(contribuyente);
			}else {
				entityManager.merge(contribuyente);
				entityManager.flush();
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		*/
	}
	

}
