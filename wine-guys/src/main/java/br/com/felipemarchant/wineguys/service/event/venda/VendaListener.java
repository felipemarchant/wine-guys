package br.com.felipemarchant.wineguys.service.event.venda;

import br.com.felipemarchant.wineguys.repository.Vinhos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.felipemarchant.wineguys.model.Vinho;
import br.com.felipemarchant.wineguys.model.ItemVenda;

@Component
public class VendaListener {

	@Autowired
	private Vinhos vinhos;
	
	@EventListener
	public void vendaEmitida(VendaEvent vendaEvent) {
		for (ItemVenda item : vendaEvent.getVenda().getItens()) {
			Vinho vinho = vinhos.getOne(item.getVinho().getCodigo());
			vinho.setQuantidadeEstoque(vinho.getQuantidadeEstoque() - item.getQuantidade());
			vinhos.save(vinho);
		}
	}
	
}
