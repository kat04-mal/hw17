package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product){
        if(size < products.length){
            products[size] = product;
            size ++;
        }
        else {
            System.out.println("Невозможно добавить продукт. Корзина переполнена");
        }
    }

    public int getTotalCost(){
        int total = 0;
        for (int i = 0; i < size; i++){
            total += products[i].getCost();
        }
        return total;
    }
    public void printContents(){
        if (size == 0){
            System.out.println("В корзине пусто!");
        }
        for (int i = 0; i < size; i++){
            System.out.println(products[i].getName() + ": " + products[i].getCost());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean isProductInBasket (String name){
        for (int i = 0; i < size; i++){
            if(products[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void clearBasket(){
        for (int i = 0; i < products.length; i++){
            products[i] = null;
        }
        size = 0;
    }
}
