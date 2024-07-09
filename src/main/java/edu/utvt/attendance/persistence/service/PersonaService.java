package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.utvt.attendance.persistence.entities.Persona;


public interface PersonaService {

     public Persona save(Persona  persona);
     public Persona update(UUID id, Persona persona);
     public List<Persona> getAll();
     public Optional<Persona> findById(UUID id);
     public void deleteById(UUID id);
}
