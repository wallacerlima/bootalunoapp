package br.edu.infnet.bootalunoapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;

@SpringBootTest
public class AlunoServiceTest {

	
	@InjectMocks
	private AlunoService service;
	
	@Mock
	private AlunoRepository repo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void deveriaSalvarUmAlunoExemplo2() {
		
		Aluno aluno = new Aluno();
		aluno.setId(1);
		when(repo.save(Mockito.any(Aluno.class))).thenReturn(aluno);
	
		
//		act
		Aluno alunoSalvo = service.salvar(new Aluno());
		
		//verifique
		assertNotNull(alunoSalvo);
		assertEquals(1, aluno.getId());
		
		
	}
	
//	
//	@Test
//	public void deveriaSalvarUmAluno() {
//		
//		//Arrange
//		AlunoRepository repo = Mockito.mock(AlunoRepository.class);
//		AlunoService service = new AlunoService(repo);
//		Aluno aluno = new Aluno();
//		aluno.setId(1);
//		when(repo.save(Mockito.any(Aluno.class))).thenReturn(aluno);
//		
//		
//		//act
//		Aluno alunoSalvo = service.salvar(new Aluno());
//		
//		//verifique
//		assertNotNull(alunoSalvo);
//		assertEquals(1, aluno.getId());
//		
//	}

}
