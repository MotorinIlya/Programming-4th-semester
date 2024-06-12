public class Tree {

    public Tree left, right;
    public int value;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public Tree(Tree left, Tree right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public static void print(Tree node) {
        if (node != null) {
            System.out.print(node.value);
            System.out.print(' ');
            print(node.left);
            print(node.right);
        }
    }

    public static int calc(Tree node) throws ArithmeticException {
        if (node.isLeaf()) {
            return node.value;
        }
        int leftRes = calc(node.left);
        int rightRes = calc(node.right);
        if (node.value == '+') {
            return leftRes + rightRes;
        } else if (node.value == '-') {
            return leftRes - rightRes;
        }
        else if (node.value == '*') {
            return leftRes * rightRes;
        }
        else {
            if (rightRes == 0) {
                throw new ArithmeticException();
            }
            return leftRes / rightRes;
        } 
    }
}
