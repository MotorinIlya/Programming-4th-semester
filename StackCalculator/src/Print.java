public class Print implements ComandWithoutParams {
    public void execute(StorageValue storage) throws StackEmptyException {
        if (!storage.isEmpty()) {
            System.out.println(storage.peek());
        }
        else {
            throw new StackEmptyException();
        }
    }
}
