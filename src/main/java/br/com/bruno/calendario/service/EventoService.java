package br.com.bruno.calendario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.calendario.model.Evento;
import br.com.bruno.calendario.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento findById(Long id) {
		return eventoRepository.findById(id).orElseThrow();
	}
	
	public List<Evento> findAll(){
		return eventoRepository.findAll();
	}
	
	public Evento save(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public void delete(Long id) {
		Evento evento = eventoRepository.findById(id).orElseThrow();
		eventoRepository.delete(evento);
	}
	
	public Evento update(Evento evento, Long id) {
		Evento eventoUpdate = eventoRepository.findById(id).orElseThrow();
		eventoUpdate.setDescription(evento.getDescription());
		eventoUpdate.setEnd(evento.getEnd());
		eventoUpdate.setStart(evento.getStart());
		eventoUpdate.setTitle(evento.getTitle());
		eventoUpdate.setColor(evento.getColor());
		eventoUpdate.setAllDay(evento.isAllDay());
		return eventoRepository.save(eventoUpdate);
	}
	
	
}
