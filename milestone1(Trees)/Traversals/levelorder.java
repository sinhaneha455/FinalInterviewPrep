import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.w3c.dom.Node;

public class levelorder {
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(N)

    public static void levelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int cicl = queue.size();
            for(int i=0;i<cicl;i++){
                node = queue.poll();
                System.out.println(node.data);

                if(node.left!=null){
                   queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
    }



    //TC:O(N)
    //SC:O(N) bcoz of using two stacks
    public static ArrayList<Integer> levelOrderTraversalSpiralForm(Node root){

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        while(!st1.isEmpty()||!st2.isEmpty()){
            while(!st1.isEmpty()){
                Node removeNode = st1.pop();
                list.add(removeNode.data);
                if(removeNode.right!=null){
                    st2.push(removeNode.right);
                }
                if(removeNode.left!=null){
                    st2.push(removeNode.left);
                }
            }

            while(!st2.isEmpty()){
                Node removeNode = st1.pop();
                list.add(removeNode.data);
                if(removeNode.left!=null){
                   st1.push(removeNode.left);
                }
                if(removeNode.right!=null){
                    st1.push(removeNode.right);
                }
            }
        }

        return list;
    }
}

