package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.ShoppingListsManager;
import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import com.ezgroceries.shoppinglist.model.requests.ShoppingListRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListsController {

    private final ShoppingListsManager shoppingListsManager;

    public ShoppingListsController(ShoppingListsManager shoppingListsManager) {
        this.shoppingListsManager = shoppingListsManager;
    }

    @GetMapping("/{shoppingListId}")
    public ShoppingList getShoppingList(@PathVariable UUID shoppingListId) {
        return shoppingListsManager.getShoppingList(shoppingListId);
    }

    @GetMapping
    public List<ShoppingList> getShoppingLists() {
        return shoppingListsManager.getShoppingLists();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList createShoppingList(@RequestBody ShoppingListRequest request) {
        return shoppingListsManager.create(request.getName());
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    @ResponseStatus(HttpStatus.OK)
    public List<AddCocktailRequest> addCocktailToShoppingList(@PathVariable UUID shoppingListId, @RequestBody List<AddCocktailRequest> cocktails) {
        shoppingListsManager.addCocktailToShoppingList(shoppingListId, cocktails);
        return cocktails;
    }
}
