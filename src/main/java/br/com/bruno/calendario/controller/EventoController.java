package br.com.bruno.calendario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.calendario.model.Evento;
import br.com.bruno.calendario.service.EventoService;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Evento> findEventoById(@PathVariable(value = "id") Long id){
		Evento evento = eventoService.findById(id);
		return ResponseEntity.ok(evento);
	}
	
	@GetMapping()
	public ResponseEntity<List<Evento>> findAll(){
		List<Evento> evento = eventoService.findAll();
		return ResponseEntity.ok(evento);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		eventoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ResponseEntity<Evento> save(@RequestBody Evento evento){
		eventoService.save(evento);
		return ResponseEntity.ok(evento);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Evento> update(@RequestBody Evento evento, @PathVariable(value = "id")Long id){
		Evento eventoUpdate = eventoService.update(evento, id);
		return ResponseEntity.ok(eventoUpdate);
	}
}
