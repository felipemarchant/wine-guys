package br.com.felipemarchant.wineguys.repository;

import java.util.List;
import java.util.Optional;

import br.com.felipemarchant.wineguys.repository.helper.cliente.ClientesQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipemarchant.wineguys.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {

	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

	public List<Cliente> findByNomeStartingWithIgnoreCase(String nome);

}
