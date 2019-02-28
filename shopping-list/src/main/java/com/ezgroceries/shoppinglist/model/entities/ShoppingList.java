package com.ezgroceries.shoppinglist.model.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
public class ShoppingList {

    private UUID shoppingListId;
    private String name;
    private Set<String> ingredients;

    public ShoppingList(String name)
    {
        this.name = name;
        this.shoppingListId = UUID.randomUUID();
        this.ingredients = new HashSet<>();
    }

    // TODO gebruik hier StringUtils.isNotEmpty
    // De huidige code kan een Nullpointer gooien
    public void addIngredient(String ingredient) {
        if(!ingredient.isEmpty()) {
            this.ingredients.add(ingredient);
        }
    }
}
