public class Determinator {
    public static ComandFactory determineComand(String name) throws IllegalArgumentException {
        if (name.equalsIgnoreCase("Define")) {
            return new DefineFactory();
        }
        else if (name.equalsIgnoreCase("/")) {
            return new DivdeFactory();
        }
        else if (name.equalsIgnoreCase("*")) {
            return new MultFactory();
        }
        else if (name.equalsIgnoreCase("+")) {
            return new PlusFactory();
        }
        else if (name.equalsIgnoreCase("Pop")) {
            return new PopFactory();
        }
        else if (name.equalsIgnoreCase("Push")) {
            return new PushFactory();
        }
        else if (name.equalsIgnoreCase("Sqrt")) {
            return new SqrtFactory();
        }
        else if (name.equalsIgnoreCase("-")) {
            return new SubFactory();
        }
        else if (name.equalsIgnoreCase("Print")) {
            return new PrintFactory();
        }
        else { throw new IllegalArgumentException(); }

    }
}
