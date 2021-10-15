import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class reverselevelorder {
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(N)
    // We are doing it with the help of one stack and one queue
    public static void reverselevelorderTraversal(Node root){
        if(node==null){
            return ;
        }
        Stack<Node> st = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.peek();
            queue.remove();
            st.push(node);

            if(node.right!=null){
                queue.add(node.right);

            }
            if(node.left!=null){
                queue.add(node.left);
            }

        }

        while(!st.isEmpty()){
            System.out.println(st.pop()+" ");

        }

    }
}
