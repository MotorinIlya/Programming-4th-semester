
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            Tree tree = parser.parse("6 ^ 2 - 1");
            Tree.print(tree);
            int result = Tree.calc(tree);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.err.println("division by zero");
        } catch (FormatException e) {
            System.err.println("bad expression");
        }
    }
}