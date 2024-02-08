public class Sub implements ComandWithoutParams {
    @Override
    public void execute(StorageValue storage) throws StackEmptyException {
        double a = 0, b = 0;
        if (!storage.isEmpty()) {
            a = storage.pop();
        }
        else { throw new StackEmptyException(); }
        if (!storage.isEmpty()) {
            b = storage.pop();
        }
        else { throw new StackEmptyException(); }
        storage.push(b - a);
    }
}
