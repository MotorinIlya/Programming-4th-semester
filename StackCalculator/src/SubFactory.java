public class SubFactory implements ComandFactory {
    public Comand createComand() {
        return new Sub();
    }
}
