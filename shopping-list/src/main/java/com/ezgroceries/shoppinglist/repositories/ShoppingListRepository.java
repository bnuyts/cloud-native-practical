package com.ezgroceries.shoppinglist.repositories;

import com.ezgroceries.shoppinglist.model.entities.ShoppingListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShoppingListRepository extends CrudRepository<ShoppingListEntity, UUID> {
}
