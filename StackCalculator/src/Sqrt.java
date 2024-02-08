public class Sqrt implements ComandWithoutParams{
    @Override
    public void execute(StorageValue storage) throws StackEmptyException {
        double a = 0;
        if (!storage.isEmpty()) {
            a = storage.pop();
        }
        else { throw new StackEmptyException(); }

        storage.push(Math.sqrt(a));
    }
}
