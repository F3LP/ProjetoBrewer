package com.cervejaria.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cervejaria.brewer.model.Cerveja;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

	@GetMapping("/novo")
	public String novo(Cerveja cerveja) {
		System.out.println("teste");

		return "cerveja/cadastroCerveja";
	}

	@PostMapping("/novo")
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			model.addAttribute(cerveja);
			return novo(cerveja);
		} else {
			attr.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
			System.out.println("Cadastrar : " + cerveja.getNome());
			return "redirect:/cervejas/novo"; 
		}
	}
	
	@GetMapping("/cadastro")
	public String cadastro(Model model) {
		model.addAttribute(new Cerveja());
		return "cerveja/cadastro-produto";
	}
}
