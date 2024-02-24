import java.util.Random;

public class Randomizer {
    public static String getSecretName()
    {
        Random rng = new Random();
        String characters = "0123456789qwertyuiopasdfghjklzxcvbnm";
        int length = 5;
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
