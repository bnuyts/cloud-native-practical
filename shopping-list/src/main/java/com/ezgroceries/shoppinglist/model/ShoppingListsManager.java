package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ShoppingListsManager {

    private List<ShoppingList> shoppingLists;
    private CocktailManager cocktailManager;

    public ShoppingListsManager(CocktailManager cocktailManager) {
        this.cocktailManager = cocktailManager;
        // TODO verwijder de extra ShoppingList in new Array<ShoppingList>
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
