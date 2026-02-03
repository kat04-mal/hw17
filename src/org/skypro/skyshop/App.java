package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Демонстрация корректных данных");
        try {
            SimpleProduct apple = new SimpleProduct("Яблоко", 95);
            SimpleProduct milk = new SimpleProduct("Молоко", 115);
            DiscountedProduct tea = new DiscountedProduct("Чай", 150, 20);
            FixPriceProduct salt = new FixPriceProduct("Соль");
            Article appleArticle = new Article("Польза яблок", "Яблоки содержат витамины и полезны для здоровья");
            Article milkArticle = new Article("О молоке", "Молоко - источник кальция и белка");

            SearchEngine searchEngine = new SearchEngine(10);

            searchEngine.add(apple);
            searchEngine.add(milk);
            searchEngine.add(tea);
            searchEngine.add(salt);
            searchEngine.add(appleArticle);
            searchEngine.add(milkArticle);

            ProductBasket basket = new ProductBasket();
            basket.addProduct(apple);
            basket.addProduct(milk);
            basket.addProduct(tea);
            basket.addProduct(salt);

            basket.printContents();

            System.out.println("Поиск наиболее подходящего результата");

            Searchable bestApple = searchEngine.findBestMatch("яблоко");
            System.out.println("Наиболее подходящий результат для 'яблоко': " + bestApple.getStringRepresentation());

            Searchable bestMilk = searchEngine.findBestMatch("молоко");
            System.out.println("Наиболее подходящий результат для 'молоко': " + bestMilk.getStringRepresentation());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Демонстрация обработки невалидных данных");

        // Тестирование невалидного названия продукта
        try {
            SimpleProduct invalidProduct = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            SimpleProduct nullProduct = new SimpleProduct(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // Тестирование невалидной цены
        try {
            SimpleProduct zeroPrice = new SimpleProduct("Товар", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            SimpleProduct negativePrice = new SimpleProduct("Товар", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // Тестирование невалидной скидки
        try {
            DiscountedProduct invalidDiscount = new DiscountedProduct("Чай", 100, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            DiscountedProduct highDiscount = new DiscountedProduct("Чай", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // Тестирование невалидной базовой цены со скидкой
        try {
            DiscountedProduct invalidBasePrice = new DiscountedProduct("Чай", 0, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("Демонстрация исключения при поиске");
        try {
            SearchEngine emptyEngine = new SearchEngine(5);
            Searchable result = emptyEngine.findBestMatch("несуществующий запрос");
        } catch (BestResultNotFound e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        // Демонстрация с частично заполненным движком
        try {
            SearchEngine partialEngine = new SearchEngine(5);
            SimpleProduct product1 = new SimpleProduct("Тестовый товар", 100);
            partialEngine.add(product1);

            // Запрос, который не найдет совпадений
            Searchable result = partialEngine.findBestMatch("абсолютно другой текст");
        } catch (BestResultNotFound e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("Тестирование алгоритма подсчета вхождений");
        // Создаем специальные статьи для тестирования алгоритма
        try {
            SearchEngine testEngine = new SearchEngine(10);

            Article article1 = new Article("Тест", "helloabcdehellonnnnnnhello");
            Article article2 = new Article("Тест2", "hellohellohello");
            Article article3 = new Article("Тест3", "один раз hello");

            testEngine.add(article1);
            testEngine.add(article2);
            testEngine.add(article3);

            Searchable bestHello = testEngine.findBestMatch("hello");
            System.out.println("Наиболее подходящий результат для 'hello': " + bestHello.getStringRepresentation());
            System.out.println("Текст: " + bestHello.getSearchTerm());

        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        }
}