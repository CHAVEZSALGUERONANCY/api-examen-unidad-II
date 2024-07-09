package edu.utvt.attendance.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.service.PersonaService;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {

	@Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return this.personaService.save(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable UUID id, @RequestBody Persona persona) {
        return this.personaService.update(id, persona);
    }

    @GetMapping
    public List<Persona> getAll() {
        return this.personaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> findById(@PathVariable UUID id) {
        return this.personaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        this.personaService.deleteById(id);
    }
}