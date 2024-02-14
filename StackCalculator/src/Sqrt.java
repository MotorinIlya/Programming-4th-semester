public class Sqrt implements ComandWithoutParams{
    @Override
    public void execute(StorageValue storage) throws StackEmptyException, NegativeNumberException {
        double a = 0;
        if (!storage.isEmpty()) {
            a = storage.pop();
        }
        else { throw new StackEmptyException(); }
        if (a >= 0) {
            storage.push(Math.sqrt(a));
        }
        else { throw new NegativeNumberException(); }
    }
}
