create table COCKTAIL_SHOPPING_LIST (
  COCKTAIL_ID UUID REFERENCES COCKTAIL(ID),
  SHOPPING_LIST_ID UUID REFERENCES SHOPPING_LIST(ID)
)