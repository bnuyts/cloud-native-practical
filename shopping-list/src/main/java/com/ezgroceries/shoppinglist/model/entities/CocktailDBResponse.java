package com.ezgroceries.shoppinglist.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CocktailDBResponse {

    private List<DrinkResource> drinks;

}
