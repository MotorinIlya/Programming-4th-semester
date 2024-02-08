import java.util.List;

public class ExecuteComander {
    public static void executeComands(List<String> comands) {
        StorageValue storage = new StorageValue();
        
        for (String comand : comands) {
            String[] signature = comand.split(" ");
            if (signature[0].charAt(0) != '#') {
                try {
                    ComandFactory nameFactory = Determinator.determineComand(signature[0]);
                    Comand name = nameFactory.createComand();
                    if (name instanceof ComandWithParams) {
                        ((ComandWithParams)name).execute(storage, signature);
                    }
                    else if (name instanceof ComandWithoutParams) {
                        ((ComandWithoutParams)name).execute(storage);
                    }
                    
                }
                catch (IllegalArgumentException e) {
                    System.out.println("bad input");
                }
                catch (StackEmptyException e) {
                    System.out.println("Invisible for count");
                }
            }
        }
    }
}
