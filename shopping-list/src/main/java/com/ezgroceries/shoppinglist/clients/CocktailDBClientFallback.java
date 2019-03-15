package com.ezgroceries.shoppinglist.clients;

import com.ezgroceries.shoppinglist.model.entities.CocktailDBResponse;
import com.ezgroceries.shoppinglist.model.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.model.entities.DrinkResource;
import com.ezgroceries.shoppinglist.repositories.CocktailRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CocktailDBClientFallback implements CocktailDBClient {

    private final CocktailRepository cocktailRepository;

    public CocktailDBClientFallback(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    @Override
    public CocktailDBResponse searchCocktails(String search) {
        List<CocktailEntity> cocktailEntities = cocktailRepository.findByNameContainingIgnoreCase(search);

        CocktailDBResponse cocktailDBResponse = new CocktailDBResponse();
        cocktailDBResponse.setDrinks(cocktailEntities.stream().map(cocktailEntity -> {
            DrinkResource drinkResource = new DrinkResource();
            drinkResource.setIdDrink(cocktailEntity.getIdDrink());
            drinkResource.setStrDrink(cocktailEntity.getName());
            drinkResource.setStrGlass(cocktailEntity.getGlass());
            drinkResource.setStrDrinkThumb(cocktailEntity.getImage());
            drinkResource.setStrInstructions(cocktailEntity.getInstructions());
            setIngredients(drinkResource, cocktailEntity.getIngredients());
            return drinkResource;
        }).collect(Collectors.toList()));

        return cocktailDBResponse;
    }

    private void setIngredients(DrinkResource drinkResource, Set<String> ingredients) {
        List<String> ingredientsList = new ArrayList<>(ingredients);
        drinkResource.setStrIngredient1(ingredientsList.get(0));
        drinkResource.setStrIngredient2(ingredientsList.get(1));
        drinkResource.setStrIngredient3(ingredientsList.get(2));
    }
}