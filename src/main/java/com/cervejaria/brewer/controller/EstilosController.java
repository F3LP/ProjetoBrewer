package com.cervejaria.brewer.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cervejaria.brewer.model.Estilo;
import com.cervejaria.brewer.service.EstiloService;
import com.cervejaria.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
@RequestMapping("/estilos")
public class EstilosController {
	
	private EstiloService service;

	@Autowired
	public EstilosController(EstiloService service) {
		this.service = service;
	}

	@GetMapping("/novo")
	public ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("estilo/cadastroEstilo");
		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return novo(estilo);
			
		} else {
			try {
				service.save(estilo);
			} catch (NomeEstiloJaCadastradoException e) {
				result.rejectValue("nome", e.getMessage(), e.getMessage());
				
				return novo(estilo);
			}
			
			attr.addFlashAttribute("mensagem", "Estilo salvo com sucesso.");
			return new ModelAndView("redirect:/estilos/novo"); 
		}
	}
	
	@PostMapping(consumes= { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		try {
			estilo = service.save(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(estilo);
	}
}
