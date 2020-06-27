package br.edu.infnet.bootalunoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bootalunoapp.modelo.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
