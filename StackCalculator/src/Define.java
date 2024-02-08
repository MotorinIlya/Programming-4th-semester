public class Define implements ComandWithParams{
    @Override
    public void execute(StorageValue storage, String[] signature) {
        storage.put(signature[1], Double.parseDouble(signature[2]));
    }
}
