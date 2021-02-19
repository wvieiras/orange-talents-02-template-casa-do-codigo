package br.com.orangetalents.cdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.cdc.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
