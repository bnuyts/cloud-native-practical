package com.ezgroceries.shoppinglist.config;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.repositories.CocktailRepository;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import com.ezgroceries.shoppinglist.services.CocktailService;
import com.ezgroceries.shoppinglist.services.CocktailServiceImpl;
import com.ezgroceries.shoppinglist.services.ShoppingListServiceImpl;
import com.ezgroceries.shoppinglist.services.ShoppingListsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class MainConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public CocktailService cocktailManager(CocktailRepository cocktailRepository, CocktailDBClient cocktailDBClient) {
        return new CocktailServiceImpl(cocktailRepository, cocktailDBClient);
    }

    @Bean
    public ShoppingListsService shoppingListsManager(CocktailRepository cocktailRepository, ShoppingListRepository shoppingListRepository) {
        return new ShoppingListServiceImpl(cocktailRepository, shoppingListRepository);
    }
}
