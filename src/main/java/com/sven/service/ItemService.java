package com.sven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sven.model.Item;
import com.sven.repository.ItemRepository;

@Service
public class ItemService
{

    private ItemRepository repository;
    
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }
    
    public List<Item> findAll() {
        return repository.findAll();
    }
    
    public Item save(Item item) {
        return repository.save(item);
    }
    
    public Optional<Item> findById(int id) {
        return repository.findById(id);
    }
    
    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
}
