import java.util.HashMap;
import java.util.Map;

public class CounterCharacters {
    public static Map<Character, Integer> countWords(String name) {
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < name.length(); i++) {
            Integer temp = 0;
            if ((temp = counter.get(name.charAt(i))) != null) {
                counter.put(name.charAt(i), temp + 1);
            }
            else {
                counter.put(name.charAt(i), 1);
            }
        }
        return counter;
    }

}
