package br.com.felipemarchant.wineguys.repository.helper.vinho;

import java.util.List;

import br.com.felipemarchant.wineguys.model.Vinho;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.felipemarchant.wineguys.dto.VinhoDTO;
import br.com.felipemarchant.wineguys.dto.ValorItensEstoque;
import br.com.felipemarchant.wineguys.repository.filter.VinhoFilter;

public interface VinhosQueries {

	public Page<Vinho> filtrar(VinhoFilter filtro, Pageable pageable);
	
	public List<VinhoDTO> porSkuOuNome(String skuOuNome);
	
	public ValorItensEstoque valorItensEstoque();
	
}
