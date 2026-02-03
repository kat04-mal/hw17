package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract int getPrice();

    // Метод определения, является ли товар "специальным"
    public boolean isSpecial(){
        return false; // По умолчанию - нет
    }

    @Override
    public String toString(){
        return getName() + ": " + getPrice();
    }
}
