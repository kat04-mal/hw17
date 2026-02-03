package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        searchables = new Searchable[capacity];
        size = 0;
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Невозможно добавить элемент. Поисковый движок переполнен");
        }
    }

    public Searchable[] search(String query) {
        // Используем список для динамического хранения результатов
        List<Searchable> resultList = new ArrayList<>();

        for (int i = 0; i < size && resultList.size() < 5; i++) {
            Searchable item = searchables[i];
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                resultList.add(item);
            }
        }

        // Преобразуем список в массив
        return resultList.toArray(new Searchable[0]);
    }
}
