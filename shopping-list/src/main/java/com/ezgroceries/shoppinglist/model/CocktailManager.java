package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.mappers.CocktailMapper;
import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import com.ezgroceries.shoppinglist.model.entities.CocktailDBResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CocktailManager {

    private CocktailDBClient cocktailDBClient;

    public CocktailManager(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    public List<Cocktail> search(String search) {
        return getResources(search);
    }

    public Cocktail getById(UUID id) {
        // TODO: fix search with cache
        return getResources("russian").stream().filter(c -> c.getCocktailId().equals(id)).findFirst().orElse(null);
    }

    private List<Cocktail> getResources(String search) {
        CocktailDBResponse response = cocktailDBClient.searchCocktails(search);

        return response.getDrinks().stream().map(CocktailMapper::MapCocktailDB).collect(Collectors.toList());
    }
}
