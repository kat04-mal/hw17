package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 95);
        SimpleProduct milk = new SimpleProduct("Молоко", 115);
        SimpleProduct flour = new SimpleProduct("Мука", 60);
        SimpleProduct sugar = new SimpleProduct("Сахар", 80);

        // Специальные товары
        DiscountedProduct tea = new DiscountedProduct("Чай", 150, 20);
        FixPriceProduct salt = new FixPriceProduct("Соль");

        ProductBasket basket = new ProductBasket();

        //Добавление продуктов в корзину
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(flour);
        basket.addProduct(sugar);
        basket.addProduct(tea);
        basket.addProduct(salt);

        //Добавляем повторно яблоко
        basket.addProduct(apple);

        //Печать содержимого корзины
        basket.printContents();

        //Получение стоимости корзины
        System.out.println("Итоговая стоимость корзины: " + basket.getTotalCost());

        //Поиск товара
        System.out.println("Яблоко есть ли в корзине? " + basket.isProductInBasket("Яблоко"));
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