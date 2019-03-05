package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.model.ShoppingListsManager;
import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListService implements ShoppingListsManager {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

//    public ShoppingListResource create(ShoppingListResource shoppingListResource) {
//        ...
//    }

    @Override
    public void addCocktailToShoppingList(UUID shoppingListId, List<AddCocktailRequest> cocktails) {

    }

    @Override
    public ShoppingList create(String name) {
        return null;
    }

    @Override
    public ShoppingList getShoppingList(UUID shoppingListId) {
        return null;
    }

    @Override
    public List<ShoppingList> getShoppingLists() {
        return null;
    }
}
