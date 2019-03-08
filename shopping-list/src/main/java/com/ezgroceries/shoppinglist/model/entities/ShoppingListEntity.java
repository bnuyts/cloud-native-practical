package com.ezgroceries.shoppinglist.model.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
}
