package com.ezgroceries.shoppinglist.clients;

import com.ezgroceries.shoppinglist.model.entities.CocktailDBResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "cocktailDBClient", url = "https://www.thecocktaildb.com/api/json/v1/1", fallback = CocktailDBClientFallback.class)
public interface CocktailDBClient {

    @GetMapping(value = "search.php")
    CocktailDBResponse searchCocktails(@RequestParam("s") String search);

}