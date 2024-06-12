public class Parser {
    private int strPos = 0;
    public void Skip(String str) {
        while(strPos < str.length() && str.charAt(strPos) == ' ') {
            strPos++;
        }
    }
    public Tree parse(String str) throws FormatException {
        return plusOrMinus(str);
    }
    public Tree plusOrMinus(String str) throws FormatException {
        Tree leftTree = multOrDiv(str);

        while (true) {
            Skip(str);
            if (strPos >= str.length())
                break;

            char operation = str.charAt(strPos);
            if (operation == '+' || operation == '-') {
                strPos++;
                Tree right = multOrDiv(str);
                leftTree = new Tree(leftTree, right, operation);
            }
            else {
                break;
            }
        }

        return leftTree;
    }
    public Tree multOrDiv(String str) throws FormatException {
        Tree leftTree = numberOrBracket(str);

        while (true) {
            Skip(str);
            if (strPos >= str.length())
                break;

            char op = str.charAt(strPos);
            if (op == '*' || op == '/') {
                strPos++;
                Tree right = numberOrBracket(str);
                leftTree = new Tree(leftTree, right, op);
            } else {
                break;
            }
        }

        return leftTree;
    }
    Tree numberOrBracket(String str) throws FormatException {
        Skip(str);
        if(str.charAt(strPos) == '(') {
            strPos++;
            Tree tree = plusOrMinus(str);
            if (str.charAt(strPos) == ')') {
                strPos++;
                return tree;
            }
            else {
                System.out.println("missed ')' symbol");
                throw new FormatException();
            }
        }
        String elem = "";
        while (strPos < str.length() && Character.isDigit(str.charAt(strPos))) {
            elem = elem + str.charAt(strPos);
            strPos++;
        }
        int elemInt;
        try {
            elemInt = Integer.parseInt(elem);
        }
        catch (NumberFormatException e) {
            System.out.println("Unacceptable value");
            return null;
        }
        return new Tree(null, null, elemInt);
    }
}
