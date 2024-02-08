public class Pop implements ComandWithoutParams {
    public void execute(StorageValue storage) throws StackEmptyException {
        if (!storage.isEmpty()) {
            storage.pop();
        }
        else { throw new StackEmptyException(); }
    }
}
