package br.com.felipemarchant.wineguys.repository.helper.venda;

import java.math.BigDecimal;
import java.util.List;

import br.com.felipemarchant.wineguys.dto.VendaMes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.felipemarchant.wineguys.dto.VendaOrigem;
import br.com.felipemarchant.wineguys.model.Venda;
import br.com.felipemarchant.wineguys.repository.filter.VendaFilter;

public interface VendasQueries {

	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
	
	public BigDecimal valorTotalNoAno();
	public BigDecimal valorTotalNoMes();
	public BigDecimal valorTicketMedioNoAno();
	
	public List<VendaMes> totalPorMes();
	public List<VendaOrigem> totalPorOrigem();
	
}
