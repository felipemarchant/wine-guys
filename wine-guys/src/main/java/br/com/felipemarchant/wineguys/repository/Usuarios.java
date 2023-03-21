package br.com.felipemarchant.wineguys.repository;

import java.util.List;
import java.util.Optional;

import br.com.felipemarchant.wineguys.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipemarchant.wineguys.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findByCodigoIn(Long[] codigos);

}
