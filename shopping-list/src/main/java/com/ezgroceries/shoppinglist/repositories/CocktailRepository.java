package com.ezgroceries.shoppinglist.repositories;

import com.ezgroceries.shoppinglist.model.entities.CocktailEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CocktailRepository extends CrudRepository<CocktailEntity, UUID> {

    List<CocktailEntity> findByIdDrinkIn(List<String> ids);

    List<CocktailEntity> findByNameContainingIgnoreCase(String name);
}
