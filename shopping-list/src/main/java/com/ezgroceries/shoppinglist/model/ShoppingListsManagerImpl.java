package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Component
public class ShoppingListsManagerImpl implements ShoppingListsManager {

    private final List<ShoppingList> shoppingLists;
    private final CocktailManager cocktailManager;

    public ShoppingListsManagerImpl(CocktailManager cocktailManager) {
        this.cocktailManager = cocktailManager;
        shoppingLists = new ArrayList<>();
    }

    @Override
    public void addCocktailToShoppingList(UUID shoppingListId, List<AddCocktailRequest> cocktails) {
        ShoppingList currentShoppingList = getShoppingList(shoppingListId);

        for (AddCocktailRequest cocktail : cocktails) {
            cocktailManager.getById(cocktail.cocktailId).getIngredients().forEach(currentShoppingList::addIngredient);
        }
    }

    @Override
    public ShoppingList create(String name) {
        ShoppingList shoppingList = new ShoppingList(name);
        shoppingLists.add(shoppingList);
        return shoppingList;
    }

    @Override
    public ShoppingList getShoppingList(UUID shoppingListId) {
        return shoppingLists.stream().filter(s -> s.getShoppingListId().equals(shoppingListId)).findFirst().orElse(null);
    }

    @Override
    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }
}
