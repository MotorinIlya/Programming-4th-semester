public class SqrtFactory implements ComandFactory {
    public Comand createComand() {
        return new Sqrt();
    }
}
