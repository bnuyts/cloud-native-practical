package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.model.entities.Cocktail;

import java.util.List;
import java.util.UUID;

public interface CocktailManager {
    List<Cocktail> search(String search);

    Cocktail getById(UUID id);
}
