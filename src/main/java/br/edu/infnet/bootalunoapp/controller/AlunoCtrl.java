package br.edu.infnet.bootalunoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;

@Controller
public class AlunoCtrl {

//	@RequestMapping(value="/", method = RequestMethod.GET)
	
	@Autowired
	private AlunoRepository repo;
	
	@GetMapping(value = "/")
	public String listaAlunos(Model model) {
		repo.save(new Aluno("Jose"));
		model.addAttribute("msg", "Springboot");
		return "home";
	}
	
}
