package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.requests.AddCocktailRequest;
import com.ezgroceries.shoppinglist.model.requests.ShoppingListRequest;
import com.ezgroceries.shoppinglist.services.ShoppingListsService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListsController {

    private final ShoppingListsService shoppingListsService;

    public ShoppingListsController(ShoppingListsService shoppingListsService) {
        this.shoppingListsService = shoppingListsService;
    }

    @GetMapping("/{shoppingListId}")
    public ShoppingList getShoppingList(@PathVariable UUID shoppingListId) {
        return shoppingListsService.getShoppingList(shoppingListId);
    }

    @GetMapping
    public List<ShoppingList> getShoppingLists() {
        return shoppingListsService.getShoppingLists();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList createShoppingList(@RequestBody ShoppingListRequest request) {
        return shoppingListsService.create(request.getName());
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    @ResponseStatus(HttpStatus.OK)
    public List<AddCocktailRequest> addCocktailToShoppingList(@PathVariable UUID shoppingListId, @RequestBody List<AddCocktailRequest> cocktails) {
        shoppingListsService.addCocktailToShoppingList(shoppingListId, cocktails);
        return cocktails;
    }
}
