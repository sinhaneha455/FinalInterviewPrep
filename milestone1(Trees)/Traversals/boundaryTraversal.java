import java.util.ArrayList;

public class boundaryTraversal {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {

    }

   
    public static ArrayList<Integer> printBoundary(Node root) {
       
        if (root == null) {
            return list;
        }

        list.add(root.data);
        leftBoundary(root.left);
        printleaf(root.left);
        printleaf(root.right);
        rightBoundary(root.right);

        return list;
    }

    public static void leftBoundary(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            list.add(node.data);
            leftBoundary(node.left);
        } else if (node.right != null) {
            list.add(node.data);
            leftBoundary(node.right);
        }

    }

    public static void rightBoundary(Node node) {

        if (node == null) {
            return;
        }

        if (node.right != null) {
            rightBoundary(node.right);
            list.add(node.data);
        } else if (node.left != null) {
            rightBoundary(node.left);
            list.add(node.data);
        }

    }

    public static void printleaf(Node node) {

        if (node == null) {
            return;
        }
        printleaf(node.left);
        if (node.left == null && node.right == null) {
            list.add(node.data);
        }
        printleaf(node.right);

    }
}
