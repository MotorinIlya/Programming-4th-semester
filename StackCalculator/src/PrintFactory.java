public class PrintFactory implements ComandFactory {
    @Override
    public Comand createComand() {
        return new Print();
    }

}