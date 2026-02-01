package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 95);
        Product milk = new Product("Молоко", 115);
        Product flour = new Product("Мука", 60);
        Product sugar = new Product("Сахар", 80);
        Product tea = new Product("Чай", 150);

        ProductBasket basket = new ProductBasket();

        //Добавление продуктов в корзину
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(flour);
        basket.addProduct(sugar);
        basket.addProduct(tea);

        //Добавление продукта в заполненную корзину
        basket.addProduct(apple);

        //Печать содержимого корзины с несколькими продуктами
        basket.printContents();

        //Получение стоимости корзины с несколькими товарами
        System.out.println("Итоговая стоимость корзины: " + basket.getTotalCost());

        //Поиск товара, который есть в корзине
        System.out.println("Яблоко есть ли в корзине? " + basket.isProductInBasket("Яблоко"));

        //Поиск товара, которого нет в корзине
        System.out.println("Соль есть в корзине? " + basket.isProductInBasket("Соль"));

        //Очистка корзины
        basket.clearBasket();

        //Печать содержимого пустой корзины
        basket.printContents();

        //Получение стоимости пустой корзины
        System.out.println("Итоговая стоимость после очистки корзины: " + basket.getTotalCost());

        //Поиск товара в пустой корзине
        System.out.println("Яблоко есть в пустой корзине? " + basket.isProductInBasket("Яблоко"));
    }
}