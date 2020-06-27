package br.edu.infnet.bootalunoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;

@Service
public class AlunoService {

	private AlunoRepository alunoRepositorio;
	
	@Autowired //injetando a depencia - no construtor
	public AlunoService(AlunoRepository alunoRepositorio) {
		this.alunoRepositorio = alunoRepositorio;
	}
	
	@Transactional
	public void salvar(Aluno aluno) {
		alunoRepositorio.save(aluno);
	}

	public List<Aluno> listAll() {
		return alunoRepositorio.findAll();
	}

	public Aluno getAluno(String id) {
		//testar se o string nao é null
		return alunoRepositorio.getOne(Integer.valueOf(id));
	}

	@Transactional
	public void delete(String id) {
		alunoRepositorio.delete(getAluno(id));
	}
	
}
