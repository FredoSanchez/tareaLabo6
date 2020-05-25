package com.uca.capas.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	ImportanciaService importanciaService;

	@Autowired 
	ContribuyenteService contribuyenteService;
	
	@RequestMapping("/inicio")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> importancias = null;
		try {
			importancias = importanciaService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String fecha = dtf.format(localDate);
	    System.out.println(fecha); 
		
		mav.addObject("c_fecha_ingreso", fecha);
		*/
		
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", importancias);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/verContribuyentes")
	public ModelAndView verContribuyentes() {
		
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listaContribuyentes");
		return mav;
	}
	
	
	@PostMapping("/agregarContribuyente")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Importancia> importancias = null;
			try {
				importancias = importanciaService.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("contribuyente", contribuyente);
			mav.addObject("importancias", importancias);
			mav.setViewName("main");
		}else {
			contribuyenteService.insert(contribuyente);
			mav.setViewName("mensaje");
		}
		
		return mav;
	}
	
	
}
