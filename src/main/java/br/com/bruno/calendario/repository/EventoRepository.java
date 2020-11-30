package br.com.bruno.calendario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.calendario.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
