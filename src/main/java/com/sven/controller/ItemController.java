package com.sven.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sven.model.Item;
import com.sven.service.ItemService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/items")
public class ItemController
{

    private ItemService itemService;

    public ItemController(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @GetMapping()
    public List<Item> findAll() {
        
        return itemService.findAll();
    }
    
    @PostMapping()
    public Item add(@RequestBody Item item) {
        
        return itemService.save(item);
    }
    
    @DeleteMapping("/{id}")
    public void add(@PathVariable int id) {
        
        itemService.deleteById(id);
    }
}
