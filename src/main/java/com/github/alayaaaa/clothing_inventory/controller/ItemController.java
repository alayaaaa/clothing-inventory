package com.github.alayaaaa.clothing_inventory.controller;

import com.github.alayaaaa.clothing_inventory.dto.ItemRequest;
import com.github.alayaaaa.clothing_inventory.dto.ItemResponse;
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
    public ItemResponse addItem(@RequestBody ItemRequest request) {

        return itemService.addInventory(request);

    }

    @GetMapping("/category/{category}")
    public List<ItemResponse> getCategory(@PathVariable String category) {

        return itemService.getItemsByCategory(category);

    }

    @GetMapping("/{id}")
    public ItemResponse getItemById(@PathVariable Long id) {

        return itemService.getItemById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {

        itemService.deleteItem(id);

    }

}
