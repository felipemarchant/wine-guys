package br.com.felipemarchant.wineguys.repository;

import br.com.felipemarchant.wineguys.repository.helper.venda.VendasQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipemarchant.wineguys.model.Venda;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

}
