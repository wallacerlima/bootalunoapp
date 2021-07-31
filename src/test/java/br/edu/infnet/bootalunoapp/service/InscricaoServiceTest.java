package br.edu.infnet.bootalunoapp.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.modelo.Turma;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;
import br.edu.infnet.bootalunoapp.repository.TurmaRepository;

@SpringBootTest
public class InscricaoServiceTest {

	@Test
	public void alunoSoPodeSeIncreverEmTurmaAtiva() {


		TurmaRepository turmaRepo = Mockito.mock(TurmaRepository.class);
		AlunoRepository alunoRepo = Mockito.mock(AlunoRepository.class);
		
		InscricaoService service = new InscricaoService(alunoRepo, turmaRepo);

		Aluno alunoBD = createAlunoBD();
		Turma turmaBD = createTurmaBD();
		
		Aluno aluno = createAluno();
		Turma turma = createTurma();

		when(turmaRepo.findById(Mockito.any())).thenReturn(Optional.of(turmaBD));
		when(alunoRepo.findById(Mockito.any())).thenReturn(Optional.of(alunoBD));
		
		when(alunoRepo.save(Mockito.any())).thenReturn(alunoBD );
		when(turmaRepo.save(Mockito.any())).thenReturn(turmaBD);
		
		service.inscreverAluno(aluno, turma);
		
		
		Mockito.verify(alunoRepo).save(aluno);
		Mockito.verify(turmaRepo).save(turma);
		
		
		
	}

	private Turma createTurma() {
		return new Turma();
	}

	private Aluno createAluno() {
		return new Aluno();
	}

	private Turma createTurmaBD() {
		Turma turma = new Turma();
		turma.setAlunos(new ArrayList<Aluno>());
		turma.getAlunos().add(new Aluno());
		return turma;
	}

	private Aluno createAlunoBD() {
		Aluno aluno = new Aluno();
		aluno.setTurmas(new ArrayList<>());
		aluno.getTurmas().add(new Turma());
		return aluno;
	}
	
	
}
