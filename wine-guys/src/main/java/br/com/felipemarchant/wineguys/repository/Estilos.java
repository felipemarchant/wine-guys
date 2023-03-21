package br.com.felipemarchant.wineguys.repository;

import java.util.Optional;

import br.com.felipemarchant.wineguys.repository.helper.estilo.EstilosQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipemarchant.wineguys.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {

	public Optional<Estilo> findByNomeIgnoreCase(String nome);
	
}
