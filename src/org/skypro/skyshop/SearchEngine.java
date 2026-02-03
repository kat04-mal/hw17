package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new LinkedList<>();

    public SearchEngine(int capacity) {
        // capacity теперь игнорируется, так как список динамический
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        // Используем список для динамического хранения результатов
        List<Searchable> resultList = new LinkedList<>();

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                resultList.add(item);
            }
        }

        return resultList;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = -1;

        for (Searchable item : searchables) {
            if (item != null) {
                String searchTerm = item.getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();

                int occurrences = countOccurrences(searchTerm, searchLower);

                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null || maxOccurrences == 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        int substringIndex = text.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = text.indexOf(substring, index);
        }

        return count;
    }
}
