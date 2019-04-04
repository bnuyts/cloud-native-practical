package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import java.util.List;
import java.util.UUID;

public interface CocktailService {

    List<Cocktail> search(String search);

    Cocktail getById(UUID id);
}
