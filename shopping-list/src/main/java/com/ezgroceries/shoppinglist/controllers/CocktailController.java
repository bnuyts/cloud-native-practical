package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.CocktailManager;
import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private final CocktailManager cocktailManager;

    public CocktailController() {
        this.cocktailManager = new CocktailManager();
    }

    @GetMapping
    public List<Cocktail> get(@RequestParam String search) {
        return this.cocktailManager.search(search);
    }
    
}
