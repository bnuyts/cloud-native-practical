package com.ezgroceries.shoppinglist.repositories;

import com.ezgroceries.shoppinglist.model.entities.CocktailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends CrudRepository<CocktailEntity, UUID> {
    List<CocktailEntity> findByIdDrinkIn(List<String> ids);
}