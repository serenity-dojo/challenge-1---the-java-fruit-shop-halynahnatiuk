package com.serenitydojo.fruitmarket;

public class ShoppingCartItem {
    private Fruit fruit;
    private double quantity;
    private double totalAmountOfOneFruit;

    public ShoppingCartItem(Fruit fruit, double quantity, double totalAmountOfOneFruit) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalAmountOfOneFruit = totalAmountOfOneFruit;
    }
    public Fruit getFruit(){
        return fruit;
    }
    public Double getQuantity(){
        return quantity;
    }
    public Double getTotalAmountOfOneFruit(){
        return totalAmountOfOneFruit;
    }
}
