package com.cervejaria.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cervejaria.brewer.model.Cerveja;
import com.cervejaria.brewer.model.Estilo;
import com.cervejaria.brewer.model.Origem;
import com.cervejaria.brewer.model.Sabor;
import com.cervejaria.brewer.service.CervejaService;
import com.cervejaria.brewer.service.EstiloService;


@Controller
@RequestMapping("/cervejas")
public class CervejasController {
	
	private CervejaService cervejaService;
	private EstiloService estiloService;

	@Autowired
	public CervejasController(CervejaService cervejaService, EstiloService estiloService) {
		this.cervejaService = cervejaService;
		this.estiloService = estiloService;
	}

	@GetMapping("/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/cadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estiloService.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return novo(cerveja);
		} else {
			
			cervejaService.save(cerveja);
			attr.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
			return new ModelAndView("redirect:/cervejas/novo"); 
		}

	}
	
}
