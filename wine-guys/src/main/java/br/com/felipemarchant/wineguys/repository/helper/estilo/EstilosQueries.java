package br.com.felipemarchant.wineguys.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.felipemarchant.wineguys.model.Estilo;
import br.com.felipemarchant.wineguys.repository.filter.EstiloFilter;

public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
	
}
