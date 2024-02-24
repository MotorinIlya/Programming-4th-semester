public class Main {
    public static void main(String[] args) {
        String secretName = Randomizer.getSecretName();
        String userName = "";
        Guesser.guess(secretName, userName);
    }
}
