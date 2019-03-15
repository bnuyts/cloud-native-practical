package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.mappers.ShoppingListMapper;
import com.ezgroceries.shoppinglist.model.ShoppingListsManager;
import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService implements ShoppingListsManager {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public void addCocktailToShoppingList(UUID shoppingListId, List<AddCocktailRequest> cocktails) {

    }

    @Override
    public ShoppingList create(String name) {
        ShoppingListEntity shoppingList = new ShoppingListEntity();
        shoppingList.setId(UUID.randomUUID());
        shoppingList.setName(name);
        shoppingListRepository.save(shoppingList);
        return ShoppingListMapper.toShoppingList(shoppingList);
    }

    @Override
    public ShoppingList getShoppingList(UUID shoppingListId) {
        return shoppingListRepository.findById(shoppingListId).map(ShoppingListMapper::toShoppingList).get();
    }

    @Override
    public List<ShoppingList> getShoppingLists() {
        List<ShoppingListEntity> shoppingListEntities = (List<ShoppingListEntity>) shoppingListRepository.findAll();
        return shoppingListEntities.stream().map(ShoppingListMapper::toShoppingList).collect(Collectors.toList());
    }
}
