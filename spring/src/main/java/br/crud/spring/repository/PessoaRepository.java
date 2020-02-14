package br.crud.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
/*
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.stereotype.Repository;

import br.crud.spring.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Pessoa findPessoaById(Long id);
	/*
	@Modifying
	@Query("select nome from Pessoa")
	Pessoa findPessoaByIdade(Integer idade);
	*/
}
