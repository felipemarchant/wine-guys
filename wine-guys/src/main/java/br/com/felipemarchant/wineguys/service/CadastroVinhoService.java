package br.com.felipemarchant.wineguys.service;

import javax.persistence.PersistenceException;

import br.com.felipemarchant.wineguys.model.Vinho;
import br.com.felipemarchant.wineguys.repository.Vinhos;
import br.com.felipemarchant.wineguys.service.exception.ImpossivelExcluirEntidadeException;
import br.com.felipemarchant.wineguys.storage.FotoStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhos;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@Transactional
	public void salvar(Vinho vinho) {
		vinhos.save(vinho);
	}
	
	@Transactional
	public void excluir(Vinho vinho) {
		try {
			String foto = vinho.getFoto();
			vinhos.delete(vinho);
			vinhos.flush();
			fotoStorage.excluir(foto);
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar vinho. Já foi usada em alguma venda.");
		}
	}
	
}
