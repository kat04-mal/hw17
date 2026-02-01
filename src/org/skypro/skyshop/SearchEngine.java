package org.skypro.skyshop;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity){
        searchables = new Searchable[capacity];
        size = 0;
    }

    public void add(Searchable searchable){
        if(size < searchables.length){
            searchables[size] = searchable;
            size++;
        }
        else {
            System.out.println("Невозможно добавить элемент. Поисковый движок переполнен");
        }
    }

    public Searchable[] search(String query){
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < size && resultCount < 5; i++){
            Searchable item = searchables[i];
            if(item.getSearchTerm().toLowerCase().contains(query.toLowerCase())){
                results[resultCount] = item;
                resultCount++;
            }
        }
        return results;
    }
}
