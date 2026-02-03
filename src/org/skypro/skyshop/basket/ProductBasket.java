package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
   private List <Product> products = new LinkedList<>();

   public void addProduct(Product product){
       products.add(product);
   }

   public int getTotalCost(){
       int total = 0;
       for(Product product : products){
           total += product.getPrice();
       }
       return total;
   }

   public void printContents(){
       if(products.isEmpty()){
           System.out.println("В корзине пусто!");
           return;
       }

       int specialCount = 0;

       for(Product product : products){
           System.out.println(product.toString());
           if(product.isSpecial()){
               specialCount++;
           }
       }

       System.out.println("Итого: " + getTotalCost());
       System.out.println("Специальных товаров: " + specialCount);
   }

    public boolean isProductInBasket(String name){
       for(Product product : products){
           if(product.getName().equals(name)){
               return true;
           }
       }
       return false;
    }

    public void clearBasket(){
       products.clear();
    }

    public List<Product> removeProductsByName(String name){
       List<Product> removeProducts = new LinkedList<>();

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if(product.getName().equals(name)){
                removeProducts.add(product);
                iterator.remove();
            }
        }
        return removeProducts;
    }
}
