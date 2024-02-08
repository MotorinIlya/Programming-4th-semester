public class PushFactory implements ComandFactory {
    public Comand createComand() {
        return new Push();
    }
}
