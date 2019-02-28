package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.CocktailManager;
import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    // TODO maak deze final
    private CocktailManager cocktailManager;

    public CocktailController(CocktailManager cocktailManager) {
        this.cocktailManager = cocktailManager;
    }

    @GetMapping
    public List<Cocktail> get(@RequestParam String search) {
        return this.cocktailManager.search(search);
    }
    
}
