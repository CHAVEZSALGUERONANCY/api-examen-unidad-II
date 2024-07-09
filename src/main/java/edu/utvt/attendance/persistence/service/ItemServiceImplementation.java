package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImplementation implements ItemService {

	 @Autowired
	    private ItemRepository itemRepository;

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		   return itemRepository.save(item);
	}

	@Override
	public Item update(UUID id, Item item) {
		 Optional<Item> itemOptional = itemRepository.findById(id);
	        
	        if (itemOptional.isPresent()) {
	            Item existingItem = itemOptional.get();
	            existingItem.setNombre(item.getNombre());
	            existingItem.setPersona(item.getPersona());
	            return itemRepository.save(existingItem);
	        } else {
	            throw new IllegalArgumentException("Item not found");
	        }
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Optional<Item> findById(UUID id) {
		// TODO Auto-generated method stub
		return itemRepository.findById(id);
	}

	@Override
	public void deleteById(UUID id) {
		itemRepository.deleteById(id);
	}

}
