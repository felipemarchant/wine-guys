package br.com.felipemarchant.wineguys.repository;

import br.com.felipemarchant.wineguys.model.Vinho;
import br.com.felipemarchant.wineguys.repository.helper.vinho.VinhosQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vinhos extends JpaRepository<Vinho, Long>, VinhosQueries {

}
