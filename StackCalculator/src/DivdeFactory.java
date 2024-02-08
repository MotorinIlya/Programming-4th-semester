public class DivdeFactory implements ComandFactory {
    public Comand createComand() {
        return new Divide();
    }
}
