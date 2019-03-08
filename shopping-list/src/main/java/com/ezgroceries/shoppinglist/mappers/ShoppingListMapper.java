package com.ezgroceries.shoppinglist.mappers;

import com.ezgroceries.shoppinglist.model.entities.ShoppingList;
import com.ezgroceries.shoppinglist.model.entities.ShoppingListEntity;

public class ShoppingListMapper {

    public static ShoppingList toShoppingList(ShoppingListEntity entity) {
        ShoppingList shoppingList = new ShoppingList(entity.getName());
        shoppingList.setShoppingListId(entity.getId());

        return shoppingList;
    }
}
