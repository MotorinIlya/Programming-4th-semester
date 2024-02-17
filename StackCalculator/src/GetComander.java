import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetComander {
    public static List<String> getComands(String path, String fileName) {
        List<String> comands = new ArrayList<>();
        try {
            comands = Files.readAllLines(Paths.get(path + fileName));
        }
        catch (IOException e) {
            System.out.println("there is no such file");
        }
        return comands;
    }
}
