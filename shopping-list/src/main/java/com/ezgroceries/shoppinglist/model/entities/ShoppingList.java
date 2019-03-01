package com.ezgroceries.shoppinglist.model.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

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

    public ShoppingList(String name) {
        this.name = name;
        shoppingListId = UUID.randomUUID();
        ingredients = new HashSet<>();
    }

    public void addIngredient(String ingredient) {
        if (StringUtils.isEmpty(ingredient)) {
            ingredients.add(ingredient);
        }
    }
}
