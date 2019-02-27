package com.ezgroceries.shoppinglist.model.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddCocktailRequest {

    public UUID cocktailId;
}
