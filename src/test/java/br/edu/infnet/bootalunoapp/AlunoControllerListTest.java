package br.edu.infnet.bootalunoapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;
import br.edu.infnet.bootalunoapp.service.AlunoService;

@SpringBootTest
class AlunoControllerListTest {
	
	@InjectMocks
	private AlunoService service = new AlunoService();
	
	@Mock
	private AlunoRepository repository;
	
	@BeforeTestClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	
	@Test
	public void teste() {
		
		when(repository.save(any(Aluno.class))).thenReturn(new Aluno());
		assertNotNull(service.salvar(new Aluno()));
		
	}
	
	
	
}
