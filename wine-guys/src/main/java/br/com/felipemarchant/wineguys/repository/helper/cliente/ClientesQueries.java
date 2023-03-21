package br.com.felipemarchant.wineguys.repository.helper.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.felipemarchant.wineguys.model.Cliente;
import br.com.felipemarchant.wineguys.repository.filter.ClienteFilter;

public interface ClientesQueries {

	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);
	
}
