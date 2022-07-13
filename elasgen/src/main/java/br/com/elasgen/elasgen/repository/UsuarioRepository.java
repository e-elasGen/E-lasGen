package br.com.elasgen.elasgen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elasgen.elasgen.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario>findAllByNomeContainingIgnoreCase(String nome);

}
