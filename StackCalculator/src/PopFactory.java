public class PopFactory implements ComandFactory {
    public Comand createComand() {
        return new Pop();
    }
}
