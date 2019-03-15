package com.ezgroceries.shoppinglist.model.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "cocktail_shopping_list",
            joinColumns = {@JoinColumn(name = "shopping_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "cocktail_id")})
    private List<CocktailEntity> cocktails;
}
