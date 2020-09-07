package com.cervejaria.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervejaria.brewer.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	
	@GetMapping("/novo")
	public String novo(Usuario usuario) {
		return "usuario/cadastroUsuario";
	}
//
//	@PostMapping("/novo")
//	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attr) {
//		
//		if (result.hasErrors()) {
//			model.addAttribute(cerveja);
//			return novo(cerveja);
//		} else {
//			attr.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
//			System.out.println("Cadastrar : " + cerveja.getNome());
//			return "redirect:/cervejas/novo"; 
//		}
//	}

}

