public interface ComandWithoutParams extends Comand {
    public void execute(StorageValue storage) throws StackEmptyException, NegativeNumberException;
}
