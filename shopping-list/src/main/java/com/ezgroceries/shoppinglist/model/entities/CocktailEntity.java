package com.ezgroceries.shoppinglist.model.entities;

import com.ezgroceries.shoppinglist.converters.StringSetConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cocktail")
public class CocktailEntity {

    @Id
    private UUID id;

    @Column(name = "id_drink")
    private String idDrink;

    @Column(name = "name")
    private String name;

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;
}
