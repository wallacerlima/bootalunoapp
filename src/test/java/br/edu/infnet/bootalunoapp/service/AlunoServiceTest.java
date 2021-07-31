package br.edu.infnet.bootalunoapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;


@SpringBootTest
class AlunoServiceTest {

	
	@InjectMocks
	private AlunoService service;
	
	
	@Mock
	private AlunoRepository repository;
	
	@BeforeTestClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	void test() {
		
		when(repository.save(Mockito.any())).thenReturn(new Aluno());
		
		assertNotNull(service.salvar(new Aluno()));
		
	}

}
