package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ShoppingListsManager {

    private final List<ShoppingList> shoppingLists;
    private final CocktailManager cocktailManager;

    public ShoppingListsManager() {
        this.cocktailManager = new CocktailManager();
        this.shoppingLists = new ArrayList<ShoppingList>();
    }

    public void addCocktailToShoppingList(UUID shoppingListId, List<AddCocktailRequest> cocktails) {
        ShoppingList currentShoppingList = getShoppingList(shoppingListId);

        for (AddCocktailRequest cocktail : cocktails) {
            this.cocktailManager.getById(cocktail.cocktailId).getIngredients().forEach(currentShoppingList::addIngredient);
        }
    }

    public ShoppingList create(String name) {
        ShoppingList shoppingList = new ShoppingList(name);
        this.shoppingLists.add(shoppingList);
        return shoppingList;
    }

    public ShoppingList getShoppingList(UUID shoppingListId){
        return this.shoppingLists.stream().filter(s -> s.getShoppingListId().equals(shoppingListId)).findFirst().orElse(null);
    }

    public List<ShoppingList> getShoppingLists() {
        return this.shoppingLists;
    }
}
