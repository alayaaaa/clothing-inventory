package com.github.alayaaaa.clothing_inventory.controller;

import com.github.alayaaaa.clothing_inventory.model.Item;
import com.github.alayaaaa.clothing_inventory.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {

        if(itemService == null) {

            throw new IllegalArgumentException("Dependency cannot be null.");

        }

        this.itemService = itemService;

    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {

        return itemService.addInventory(item);

    }

    @GetMapping("/category/{category}")
    public List<Item> getCategory(@PathVariable String category) {

        return itemService.getItemsByCategory(category);

    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {

        return itemService.getItemById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {

        itemService.deleteItem(id);

    }

}
