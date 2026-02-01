package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial(){
        return false;
    }

    @Override
    public String toString(){
        return getName() + ": " + getPrice();
    }

    @Override
    public String getSearchTerm(){
        return name;
    }

    @Override
    public String getContentType(){
        return "PRODUCT";
    }
}
