package br.edu.infnet.bootalunoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.modelo.Turma;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;
import br.edu.infnet.bootalunoapp.repository.TurmaRepository;

@Service
public class InscricaoService {

	private AlunoRepository alunoRepo;
	private TurmaRepository turmaRepo;


	@Autowired
	public InscricaoService(AlunoRepository alunoRepo, TurmaRepository turmaRepo) {
		this.alunoRepo = alunoRepo;
		this.turmaRepo = turmaRepo;
	}
	
	
	public void inscreverAluno(Aluno aluno, Turma turma) {
		
		Optional<Turma> turmaBD = turmaRepo.findById(turma.getId());
		turmaBD.get().getAlunos().add(aluno);
		
		Optional<Aluno> alunoBD = alunoRepo.findById(aluno.getId());
		alunoBD.get().getTurmas().add(turma);
		
		turmaRepo.save(turma);
		alunoRepo.save(aluno);
		
		System.out.println(aluno);
		
		
		
	}

}
