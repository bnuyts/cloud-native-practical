package com.ezgroceries.shoppinglist.mappers;

import com.ezgroceries.shoppinglist.model.entities.Cocktail;
import com.ezgroceries.shoppinglist.model.entities.DrinkResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CocktailMapper {
    public static Cocktail mapCocktailDB(DrinkResource drinkResource) {
        List<String> ingredients = new ArrayList<>(Arrays.asList(drinkResource.getStrIngredient1(),
                drinkResource.getStrIngredient2(),
                drinkResource.getStrIngredient3()));
        ingredients.removeIf(String::isEmpty);

        return new Cocktail(
                UUID.nameUUIDFromBytes(drinkResource.getIdDrink().getBytes()),
                drinkResource.getStrDrink(),
                drinkResource.getStrGlass(),
                drinkResource.getStrInstructions(),
                drinkResource.getStrDrinkThumb(),
                ingredients
        );
    }
}
