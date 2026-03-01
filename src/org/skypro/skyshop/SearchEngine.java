package org.skypro.skyshop;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public SearchEngine(int capacity) {
        // capacity теперь игнорируется
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // Компаратор
    private static final Comparator<Searchable> searchableComparator =
            Comparator.comparingInt((Searchable s) -> s.getName().length())
                    .reversed()
                    .thenComparing(Searchable::getName);

    // Поиск всех совпадений
    public TreeSet<Searchable> search(String query){
        String lowerQuery = query.toLowerCase();

        // Весь поиск теперь реализован через Stream
        return searchables.stream()
                .filter(item -> item != null &&
                        item.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>(searchableComparator)));
    }

    // Стандартный поиск лучшего совпадения (без изменений)
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = -1;
        String lowerSearch = search.toLowerCase();

        for (Searchable item : searchables) {
            if (item != null) {
                int occurrences = countOccurrences(item.getSearchTerm().toLowerCase(), lowerSearch);
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
        int idx = 0;
        while ((idx = text.indexOf(substring, idx)) != -1) {
            count++;
            idx += substring.length();
        }
        return count;
    }
}

