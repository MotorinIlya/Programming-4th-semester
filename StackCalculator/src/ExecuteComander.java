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
                String comandName = signature[0] + "Factory";

                Class<?> nameFactoryClass = Class.forName(comandName);
                @SuppressWarnings("deprecation")
                Object nameFactory = nameFactoryClass.newInstance();
                
                if (nameFactory instanceof ComandFactory) {
                    Comand name = ((ComandFactory)nameFactory).createComand();
                    if (name instanceof ComandWithParams) {
                        ((ComandWithParams)name).execute(storage, signature);
                    }
                    else if (name instanceof ComandWithoutParams) {
                        ((ComandWithoutParams)name).execute(storage);
                    }
                }             
            }
            catch (InstantiationException e) {
                System.out.println("bad input");
            }
            catch (IllegalAccessException e) {
                System.out.println("bad input");
            }
            catch (ClassNotFoundException e) {
                System.out.println("bad input");
            }
            catch (IllegalArgumentException e) {
                System.out.println("bad input");
            }
            catch (StackEmptyException e) {
                System.out.println("Invisible for count");
            }
            catch (NegativeNumberException e) {
                System.out.println("Нow can't take the root of a negative number");
            }
        }
    }
}
