package br.com.felipemarchant.wineguys.repository;

import java.util.List;
import java.util.Optional;

import br.com.felipemarchant.wineguys.repository.helper.cidade.CidadesQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipemarchant.wineguys.model.Cidade;
import br.com.felipemarchant.wineguys.model.Estado;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);

	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
	
}
