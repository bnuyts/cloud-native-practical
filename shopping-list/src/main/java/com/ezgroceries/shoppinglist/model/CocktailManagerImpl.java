package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.mappers.CocktailMapper;
import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import com.ezgroceries.shoppinglist.model.entities.CocktailDBResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CocktailManagerImpl implements CocktailManager {

    private final CocktailDBClient cocktailDBClient;

    public CocktailManagerImpl(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    @Override
    public List<Cocktail> search(String search) {
        return getResources(search);
    }

    @Override
    public Cocktail getById(UUID id) {
        // TODO: fix search with cache
        return getResources("russian").stream().filter(c -> c.getCocktailId().equals(id)).findFirst().orElse(null);
    }

    private List<Cocktail> getResources(String search) {
        CocktailDBResponse response = cocktailDBClient.searchCocktails(search);

        return response.getDrinks().stream().map(CocktailMapper::mapCocktailDB).collect(Collectors.toList());
    }
}
