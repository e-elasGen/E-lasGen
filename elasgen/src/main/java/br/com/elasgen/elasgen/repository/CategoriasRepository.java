package br.com.elasgen.elasgen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elasgen.elasgen.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
 	public List<Categorias>findAllByTipoContainingIgnoreCase(String tipo);

}
