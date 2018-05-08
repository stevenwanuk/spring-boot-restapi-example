package com.sven.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.sven.model.Item;

@Repository
public class ItemRepository
{

    private List<Item> items = Collections.emptyList();

    @PostConstruct
    public void init()
    {

        items =
                IntStream.range(0, 10).mapToObj(
                        s -> Item.builder().id(s).name("item" + s).build()).collect(
                                Collectors.toList());

    }

    public List<Item> findAll()
    {
        return items;
    }

    public Item save(Item item)
    {
        items.add(item);
        return item;
    }

    public Optional<Item> findById(int id)
    {
        return items.stream().filter(s -> id == s.getId()).findAny();
    }
    
    public void deleteById(int id) {
        Optional<Item> itemOptional = this.findById(id);
        if (itemOptional.isPresent()) {
            items.remove(itemOptional.get());
        }
    }
}
