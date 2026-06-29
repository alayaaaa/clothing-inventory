package com.github.alayaaaa.clothing_inventory.service;

import com.github.alayaaaa.clothing_inventory.model.Item;
import com.github.alayaaaa.clothing_inventory.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {

        if(itemRepository == null) {

            throw new IllegalArgumentException("Dependency cannot be null.");

        }

        this.itemRepository = itemRepository;

    }

    public Item addInventory(Item item) {

        if (item.getQuantity() < 0) {

            throw new IllegalArgumentException("Quantity cannot be negative");

        }

        return itemRepository.save(item);

    }

    public List<Item> getItemsByCategory(String category) {

        return itemRepository.findByCategory(category);

    }

    public Item getItemById(Long id) {

        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id " + id + "."));

    }

    public void deleteItem(Long id) {

        if(!(itemRepository.existsById(id))) {

            throw new IllegalArgumentException("Item does not exist.");

        }

        itemRepository.deleteById(id);

    }

}
