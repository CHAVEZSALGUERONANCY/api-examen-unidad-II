package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonaServiceImplementation implements PersonaService {

	
	   @Autowired
	    private PersonaRepository personaRepository;
	   
	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		 return personaRepository.save(persona);
	}

	@Override
	@Transactional
	public Persona update(UUID id, Persona persona) {
	    Optional<Persona> personaOptional = personaRepository.findById(id);
	    if (personaOptional.isPresent()) {
	        Persona existingPersona = personaOptional.get();
	        // Actualizar los campos de existingPersona con los valores de persona
	        existingPersona.setNombre(persona.getNombre());
	        existingPersona.setEdad(persona.getEdad());
	        existingPersona.setUniversidad(persona.getUniversidad());
	        existingPersona.setCorreo(persona.getCorreo());
	        existingPersona.setFechaDeNacimiento(persona.getFechaDeNacimiento());
	        return personaRepository.save(existingPersona);
	    } else {
	        throw new EntityNotFoundException("Persona with id " + id + " not found");
	    }
	}


	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		  return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findById(UUID id) {
		// TODO Auto-generated method stub
		 return personaRepository.findById(id);
	}

	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub
		  personaRepository.deleteById(id);
	}

}
