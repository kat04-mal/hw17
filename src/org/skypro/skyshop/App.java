package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 95);
        SimpleProduct milk = new SimpleProduct("Молоко", 115);
        SimpleProduct flour = new SimpleProduct("Мука", 60);

        //Специальные товары
        DiscountedProduct tea = new DiscountedProduct("Чай", 150, 20);
        FixPriceProduct salt = new FixPriceProduct("Соль");

        //Создание статей
        Article appleArticle = new Article("Польза яблок", "Яблоки содержат витамины и полезны для здоровья");
        Article milkArticle = new Article("О молоке", "Молоко - источник кальция и белка");
        Article cookingArticle = new Article("Кулинария", "Советы по приготовлению пищи с использованием муки и сахара");

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(flour);
        searchEngine.add(tea);
        searchEngine.add(salt);

        searchEngine.add(appleArticle);
        searchEngine.add(milkArticle);
        searchEngine.add(cookingArticle);


        ProductBasket basket = new ProductBasket();

        //Добавление продуктов в корзину
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(flour);
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

        System.out.println("\nТестирование поискового движка");

        System.out.println("\nПоиск по слову 'яблоко'");
        Searchable[] appleResult = searchEngine.search("Яблоко");
        System.out.println("Результаты " + Arrays.toString(appleResult));

        System.out.println("\nПоиск по слову 'молоко'");
        Searchable[] milkResult = searchEngine.search("Молоко");
        System.out.println("Результаты " + Arrays.toString(milkResult));

        System.out.println("\nПоиск по слову 'польза'");
        Searchable[] healthResult = searchEngine.search("Польза");
        System.out.println("Результаты " + Arrays.toString(healthResult));

        System.out.println("\nПоиск по слову 'кулинария'");
        Searchable[] cookingResult = searchEngine.search("Кулинария");
        System.out.println("Результаты " + Arrays.toString(cookingResult));

        System.out.println("\nСтроковое представление объектов");
        System.out.println("Товар: " + apple.getStringRepresentation());
        System.out.println("Статья: " + appleArticle.getStringRepresentation());

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