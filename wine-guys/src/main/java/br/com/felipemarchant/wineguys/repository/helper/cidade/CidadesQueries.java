package br.com.felipemarchant.wineguys.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.felipemarchant.wineguys.model.Cidade;
import br.com.felipemarchant.wineguys.repository.filter.CidadeFilter;

public interface CidadesQueries {

	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
	
}
