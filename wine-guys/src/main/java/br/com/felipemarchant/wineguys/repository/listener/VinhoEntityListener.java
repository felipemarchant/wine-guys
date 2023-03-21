package br.com.felipemarchant.wineguys.repository.listener;

import javax.persistence.PostLoad;

import br.com.felipemarchant.wineguys.WineGuysApplication;
import br.com.felipemarchant.wineguys.model.Vinho;
import br.com.felipemarchant.wineguys.storage.FotoStorage;

public class VinhoEntityListener {

	@PostLoad
	public void postLoad(final Vinho vinho) {
		FotoStorage fotoStorage = WineGuysApplication.getBean(FotoStorage.class);
		
		vinho.setUrlFoto(fotoStorage.getUrl(vinho.getFotoOuMock()));
		vinho.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + vinho.getFotoOuMock()));
	}
	
}
