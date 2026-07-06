package com.github.alayaaaa.clothing_inventory.service;

import com.github.alayaaaa.clothing_inventory.dto.ItemRequest;
import com.github.alayaaaa.clothing_inventory.dto.ItemResponse;
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

    public ItemResponse addInventory(ItemRequest request) {

        if (request.getQuantity() < 0) {

            throw new IllegalArgumentException("Quantity cannot be negative");

        }

        Item item = mapToItem(request);
        Item savedItem = itemRepository.save(item);

        return mapToResponse(savedItem);

    }

    private Item mapToItem(ItemRequest request) {

        Item item = new Item();

        item.setName(request.getName());
        item.setCategory(request.getCategory());
        item.setSize(request.getSize());
        item.setQuantity(request.getQuantity());

        return item;

    }

    private ItemResponse mapToResponse(Item item) {

        ItemResponse response = new ItemResponse();

        response.setId(item.getId());
        response.setName(item.getName());
        response.setCategory(item.getCategory());
        response.setSize(item.getSize());
        response.setQuantity(item.getQuantity());

        return response;

    }

    public List<ItemResponse> getItemsByCategory(String category) {

        return itemRepository.findByCategory(category)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }

    public ItemResponse getItemById(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id " + id + "."));

        return mapToResponse(item);

    }

    public void deleteItem(Long id) {

        if(!(itemRepository.existsById(id))) {

            throw new IllegalArgumentException("Item does not exist.");

        }

        itemRepository.deleteById(id);

    }

}
