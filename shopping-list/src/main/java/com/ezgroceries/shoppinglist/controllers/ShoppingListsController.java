package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.ShoppingListsManager;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.ShoppingListRequest;
import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListsController {

    private final ShoppingListsManager shoppingListsManager;

    public ShoppingListsController() {
        this.shoppingListsManager = new ShoppingListsManager();
    }

    @GetMapping("/{shoppingListId}")
    public ShoppingList GetShoppingList(@PathVariable UUID shoppingListId) {
        return this.shoppingListsManager.getShoppingList(shoppingListId);
    }

    @GetMapping
    public List<ShoppingList> GetShoppingLists() {
        return this.shoppingListsManager.getShoppingLists();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList CreateShoppingList(@RequestBody ShoppingListRequest request) {
        return this.shoppingListsManager.create(request.getName());
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    @ResponseStatus(HttpStatus.OK)
    public List<AddCocktailRequest> AddCocktailToShoppingList(@PathVariable UUID shoppingListId, @RequestBody List<AddCocktailRequest> cocktails) {
        this.shoppingListsManager.addCocktailToShoppingList(shoppingListId, cocktails);
        return cocktails;
    }
}
