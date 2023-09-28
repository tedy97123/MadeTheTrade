package com.tedy.Banking.Services.impl;

import com.tedy.Banking.DTO.IdentityGetResponseDTO;

import com.tedy.Banking.Entity.Item;
import com.tedy.Banking.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<IdentityGetResponseDTO.ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();

        // Convert to DTOs
        return items.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private IdentityGetResponseDTO.ItemDTO convertToDTO(Item item) {
        // Conversion logic here, consider using a mapper
        return null;  // return the converted DTO
    }
}