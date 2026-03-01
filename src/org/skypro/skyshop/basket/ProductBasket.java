package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
   private final Map<String, List <Product>>  products = new HashMap<>();

   public void addProduct(Product product){
       products.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
   }

    public int getTotalCost(){
        return products.values().stream()
                .flatMap(Collection::stream)          // плоский поток всех продуктов
                .mapToInt(Product::getPrice)          // извлекаем цену
                .sum();                               // сумма всех цен
    }

    private long getSpecialCount(){
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)            // только специальные товары
                .count();                             // количество
    }

    public void printContents(){
        if(products.isEmpty()){
            System.out.println("В корзине пусто!");
            return;
        }

        // Печатаем товары, отсортированные по имени (как TreeSet)
        products.keySet().stream()
                .sorted(Comparator.naturalOrder())
                .forEach(name -> {
                    products.get(name).stream()
                            .forEach(product -> System.out.println(product));
                });

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }


    public boolean isProductInBasket(String name){
       return products.containsKey(name);
    }

    public void clearBasket(){
       products.clear();
    }

    public List<Product> removeProductsByName(String name){
       List<Product> removed = products.remove(name);
       return removed != null ? removed : Collections.emptyList();
    }
}
