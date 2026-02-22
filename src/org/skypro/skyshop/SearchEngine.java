package org.skypro.skyshop;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables = new LinkedList<>();

    public SearchEngine(int capacity) {
        // capacity теперь игнорируется, так как список динамический
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query){
        Map<String, Searchable> result = new TreeMap<>();
        String lowerQuery = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item != null &&
                    item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                result.put(item.getName(), item);
            }
        }
        return result;
    }

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
