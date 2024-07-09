package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.utvt.attendance.persistence.entities.Item;

public interface ItemService {
	public Item save(Item item);
    public Item update(UUID id, Item item);
    public List<Item> getAll();
    public Optional<Item> findById(UUID id);
    public void deleteById(UUID id);
}
