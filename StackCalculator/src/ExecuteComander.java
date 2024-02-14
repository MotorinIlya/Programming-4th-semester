import java.util.List;

public class ExecuteComander {
    public static void executeFileComands(List<String> comands) {
        StorageValue storage = new StorageValue();
        
        for (String comand : comands) {
            ExecuteComander.executeComand(storage, comand);
        }
    }

    public static void executeInputComands() {
        StorageValue storage = new StorageValue();
        String comand = System.console().readLine();
        
        while (!comand.equalsIgnoreCase("exit")) {
            ExecuteComander.executeComand(storage, comand);
            comand = System.console().readLine();
        }
    }

    private static void executeComand(StorageValue storage, String comand) {
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
            catch (NegativeNumberException e) {
                System.out.println("Нou can't take the root of a negative number");
            }
        }
    }
}
