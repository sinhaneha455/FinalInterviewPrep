import java.util.Queue;

import org.w3c.dom.Node;

public class diagonaltraversal {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (q.size() > 0) {
            Node temp = q.peek();
            q.remove();
            if (temp == null) {
                if (q.size() == 0){
                    return list;
                }
                q.add(null);
            }

            else {
                while (temp != null) {
                    list.add(temp.data);
                    if (temp.left != null){
                        q.add(temp.left);
                    }

                    temp = temp.right;
                }
            }
        }
        return list;
    }
}
