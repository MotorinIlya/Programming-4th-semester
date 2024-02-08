public class DefineFactory implements ComandFactory{
    public Comand createComand() {
        return new Define();
    }
}
