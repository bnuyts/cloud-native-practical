package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;

import java.util.List;
import java.util.UUID;

public interface ShoppingListsManager {
    void addCocktailToShoppingList(UUID shoppingListId, List<AddCocktailRequest> cocktails);

    ShoppingList create(String name);

    ShoppingList getShoppingList(UUID shoppingListId);

    List<ShoppingList> getShoppingLists();
}
