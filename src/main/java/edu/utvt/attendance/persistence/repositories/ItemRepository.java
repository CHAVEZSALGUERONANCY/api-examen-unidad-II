package edu.utvt.attendance.persistence.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Item;

public interface ItemRepository extends JpaRepository<Item, UUID> {
	List<Item> findByNombre(String nombre);

	
}
