public class PlusFactory implements ComandFactory {
    public Comand createComand() {
        return new Plus();
    }
}
