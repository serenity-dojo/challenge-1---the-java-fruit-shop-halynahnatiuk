package com.serenitydojo.fruitmarket;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {
    Catalog catalog;

    @Before
    public void creatingTheCatalog(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);
        catalog.setPriceOf(Orange).to(5.50);
        catalog.setPriceOf(Banana).to(6.00);
        catalog.setPriceOf(Pear).to(4.50);
    }

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
// TODO: Uncomment this code and make it work
            catalog = new Catalog();
            catalog.setPriceOf(Apple).to(4.00);
            assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }

    @Test
    public void shouldListCurrentlyAvailableFruitsInAlphabeticalOrder(){
        catalog = new Catalog();
        creatingTheCatalog();
        List <String> availableFruits = catalog.getAvailableFruit();
        assertThat(availableFruits).containsExactly("Apple","Banana","Orange","Pear");
    }

    @Test
    public void shouldReportThePriceOfFruit(){
        catalog = new Catalog();
        creatingTheCatalog();
        assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
        System.out.println("The prise of " + Orange + " equals " + catalog.getPriceOf(Orange));
    }

    @Test
    public void shouldReturnAnErrorWhenFruitIsNotAvailable(){
        catalog = new Catalog();
        creatingTheCatalog();
        catalog.getPriceOf(Watermelon);
    }



}
