package com.ezgroceries.shoppinglist.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cocktail")
public class ShoppingListEntity {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;
}
