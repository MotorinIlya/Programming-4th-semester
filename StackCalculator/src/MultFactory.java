public class MultFactory implements ComandFactory {
    public Comand createComand() {
        return new Mult();
    }
}
