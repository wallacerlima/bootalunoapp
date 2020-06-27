package br.edu.infnet.bootalunoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoCtrl {

//	@RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String listaAlunos(Model model) {
		model.addAttribute("msg", "Springboot");
		return "home";
	}
	
}
