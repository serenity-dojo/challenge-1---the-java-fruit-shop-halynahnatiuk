package com.serenitydojo.fruitmarket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItem> itemList;


    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.itemList = new ArrayList<>();
    }

    public ShoppingCartAdder add(Double amount){
        return new ShoppingCartAdder(this, amount);

    }

    public List<ShoppingCartItem> getItemList(){
        return new ArrayList<>(itemList);
    }
    public Double getTotalPrice() {
        return itemList.stream().mapToDouble(ShoppingCartItem::getTotalAmountOfOneFruit).sum();
    }
    public class ShoppingCartAdder {
        private final ShoppingCart shoppingCart;
        private final Double amount;


        public ShoppingCartAdder(ShoppingCart shoppingCart, Double amount) {
            this.shoppingCart = shoppingCart;
            this.amount = amount;
        }

        public ShoppingCart kilosOf(Fruit fruit) {
            double basePrice = shoppingCart.catalog.getPriceOf(fruit);
            double discountedPrice = (amount >= 5) ? basePrice * 0.9 : basePrice;
            ShoppingCartItem item = new ShoppingCartItem(fruit, amount, discountedPrice * amount);
            shoppingCart.itemList.add(item);
            return shoppingCart;
        }
    }

}

