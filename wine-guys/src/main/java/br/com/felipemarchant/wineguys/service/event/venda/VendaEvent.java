package br.com.felipemarchant.wineguys.service.event.venda;

import br.com.felipemarchant.wineguys.model.Venda;

public class VendaEvent {

	private Venda venda;

	public VendaEvent(Venda venda) {
		this.venda = venda;
	}

	public Venda getVenda() {
		return venda;
	}

}
