import java.util.*;

public class Guesser {
    public static void guess(String secretName, String userName) {
        
        while(!secretName.equalsIgnoreCase(userName)) {
            Map<Character, Integer> appearenceCharacter = CounterCharacters.countWords(secretName);
            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < userName.length(); i++) {
                if (userName.charAt(i) == secretName.charAt(i)) {
                    bulls++;
                    Guesser.correctMap(appearenceCharacter, userName.charAt(i));
                }
                else if(appearenceCharacter.containsKey(userName.charAt(i))) {
                    cows++;
                    Guesser.correctMap(appearenceCharacter, userName.charAt(i));
                }
            }
            System.out.println("We have " + bulls + " bulls and " + cows + " cows");
            userName = System.console().readLine();
        }
        System.out.println("congratulations, this is " + userName);
    }

    private static void correctMap (Map<Character, Integer> dict, Character name) {
        dict.put(name, dict.get(name) - 1);
        if (dict.get(name) == 0) {
            dict.remove(name);
        }
    }
}
