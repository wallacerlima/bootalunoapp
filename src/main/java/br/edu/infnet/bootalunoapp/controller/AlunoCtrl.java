package br.edu.infnet.bootalunoapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.service.AlunoService;

@Controller
public class AlunoCtrl {
	
   final static Logger logger = LoggerFactory.getLogger(AlunoCtrl.class);

	@Autowired //injeçao de dependencia - no atributo
	private AlunoService service;

	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String listaAlunos(Model model) {
		logger.debug("entrou...");
		List<Aluno> alunos =   service.listAll();		
		model.addAttribute("alunos", alunos);
		return "alunos/lista";
	}
	
	
	@RequestMapping( value = "/cadastro", method = RequestMethod.GET )
	public String form(Model model) {	
		logger.debug("entrou...");
		model.addAttribute("tipoForm", "Cadastro de");
		return "alunos/form";
	}
	
	@RequestMapping( value = "/formedit/{id}", method = RequestMethod.GET )
	public String formEdit( @PathVariable("id") String id,  Model model) {	
		logger.debug("entrou...");
		Aluno aluno = service.getAluno(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("tipoForm", "Editar");
		return "alunos/form";
	}
	

	@RequestMapping( value = "/delete/{id}", method = RequestMethod.GET )
	public String delete( @PathVariable("id") String id) {	
		service.delete(id);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Model model, Aluno aluno ) {
		service.salvar(aluno);		
		return "redirect:/";
	}	
}
