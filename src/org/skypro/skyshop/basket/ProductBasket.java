package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
   private final Map<String, List <Product>>  products = new HashMap<>();

   public void addProduct(Product product){
       products.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
   }

   public int getTotalCost(){
       int total = 0;
       for(List<Product> list : products.values()){
           for(Product p : list){
               total += p.getPrice();
           }
       }
       return total;
   }

   public void printContents(){
       if(products.isEmpty()){
           System.out.println("В корзине пусто!");
           return;
       }

       int specialCount = 0;

       for(String name : new TreeSet<>(products.keySet())){
           for (Product product : products.get(name)){
               System.out.println(product);
               if(product.isSpecial()){
                   specialCount++;
               }
           }
       }

       System.out.println("Итого: " + getTotalCost());
       System.out.println("Специальных товаров: " + specialCount);
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
