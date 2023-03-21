package com.serenitydojo.fruitmarket;

import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheShoppingCard {
    Catalog catalog;
    ShoppingCart cart;

    @Before
    public void createANewShoppingList(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Peach).to(8.00)
                .setPriceOf(Pear).to(4.50);

            cart = new ShoppingCart(catalog);
    }
    @Test
    public void checkThatCartIsEmpty(){
        assertThat(cart.getItemList()).isEmpty();
    }

    @Test
    public void checkThePriceOfBananas(){
        assertThat(catalog.getPriceOf(Banana)).isEqualTo(4.50);
    }

    @Test
    public void addToCartSomeBananas(){
        cart.add(3.00).kilosOf(Banana);
        ShoppingCartItem bananas = cart.getItemList().get(0);
        assertThat(bananas.getFruit()).isEqualTo(Banana);
    }

    @Test
    public void shouldUseTheCatalogToCalculateThePriceOfItemsAddedToTheCart() {
        cart.add(2.0).kilosOf(Pear)
                .add(2.0).kilosOf(Orange)
                .add(1.0).kilosOf(Pear);

        assertThat(cart.getTotalPrice()).isEqualTo(24.50);
    }

    @Test
    public void shouldHave10PercentDiscountWhenAdding5kilos(){
        cart.add(5.00).kilosOf(Apple);
        assertThat(cart.getTotalPrice()).isEqualTo(18.00);
    }


    @Test
    public void shouldCountDiscountOnlyForTheFruitWithMoreThan5Kilos(){
        cart.add(3.50).kilosOf(Peach)
                .add(6.00).kilosOf(Orange);
        assertThat(cart.getTotalPrice()).isEqualTo(57.70);
    }
    @Test
    public void shouldReturnTotalKilosOfFruits(){
        cart.add(3.00).kilosOf(Apple)
                .add(2.90).kilosOf(Pear)
                .add(7.10).kilosOf(Orange);
        ShoppingCartItem apples = cart.getItemList().get(0);
        ShoppingCartItem pears = cart.getItemList().get(1);
        ShoppingCartItem orange = cart.getItemList().get(2);
        double TotalKilos = apples.getQuantity() + pears.getQuantity() + orange.getQuantity();
        assertThat(TotalKilos).isEqualTo(13);
    }

    @Test
    public void shouldReturnTotalAmountForExactFruit(){
        cart.add(3.00).kilosOf(Apple)
                .add(2.50).kilosOf(Pear)
                .add(3.50).kilosOf(Orange);
        ShoppingCartItem apples = cart.getItemList().get(0);
        ShoppingCartItem pears = cart.getItemList().get(1);
        ShoppingCartItem orange = cart.getItemList().get(2);
        assertThat(apples.getTotalAmountOfOneFruit()).isEqualTo(12);
        assertThat(pears.getTotalAmountOfOneFruit()).isEqualTo(11.25);
        assertThat(orange.getTotalAmountOfOneFruit()).isEqualTo(19.25);
    }

}
