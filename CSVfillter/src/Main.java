
public class Main {

    static String path = ".\\";
    public static void main (String[] args) {

        FileReader reader = new FileReader();
        String[] words = reader.getWordsInFile(args[0], path);

        CounterWords counter = new CounterWords();
        var pairs = counter.countWords(words);
        
        FileWriter writer = new FileWriter();
        writer.WriteStatisticInFile(pairs, words.length, path);
        
    }
}