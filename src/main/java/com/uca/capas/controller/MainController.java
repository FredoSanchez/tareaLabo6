package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	ImportanciaService importanciaService;

	@RequestMapping("/inicio")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		try {
			importancias = importanciaService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancias", importancias);
		mav.setViewName("main");
		return mav;
	}
	
	/*
	@PostMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	*/
}
