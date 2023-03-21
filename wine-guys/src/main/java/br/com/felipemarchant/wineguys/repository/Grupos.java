package br.com.felipemarchant.wineguys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipemarchant.wineguys.model.Grupo;

public interface Grupos extends JpaRepository<Grupo, Long> {

}
