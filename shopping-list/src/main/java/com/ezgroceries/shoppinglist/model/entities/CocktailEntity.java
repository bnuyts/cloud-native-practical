package com.ezgroceries.shoppinglist.model.entities;

import com.ezgroceries.shoppinglist.converters.StringSetConverter;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "glass")
    private String glass;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "image")
    private String image;

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;
}
