import java.util.*;

public class CounterWords {
    public List<Map.Entry<String, Integer>> countWords(String[] words) {
        Map<String, Integer> frequencyWords = new HashMap<>(); 
        for (String word : words) {
            Integer temp = 0;
            if (word != "") {
                if ((temp = frequencyWords.get(word)) != null) {
                    frequencyWords.put(word, temp + 1);
                }
                else {
                    frequencyWords.put(word, 1);
                }
            }
            
        }
        List<Map.Entry<String, Integer>> pairs = new ArrayList<>(frequencyWords.entrySet());
        Collections.sort(pairs, new AppearenceComparator());
        return pairs;
    }
}
