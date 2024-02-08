import java.util.List;

public class Main {
    static String path = ".\\";
    public static void main(String[] args) {
        List<String> comands = GetComander.getComands(path, args[0]);
        ExecuteComander.executeComands(comands);
    }   
}