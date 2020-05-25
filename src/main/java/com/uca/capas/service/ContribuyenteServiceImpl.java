package com.uca.capas.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	//@Autowired
	//ImportanciaService importanciaService;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		/*
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String fecha = dtf.format(localDate);
		
		contribuyente.setFechaIngreso(fecha);
		
		contribuyente.setImportancia(importanciaService.findOne(contribuyente.getImportancia()));
		*/
		contribuyenteDAO.insert(contribuyente);
	}

}
