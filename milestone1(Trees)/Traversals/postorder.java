import java.util.Stack;

import org.w3c.dom.Node;

public class postorder {
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(1) without recursive stack space
    //SC:O(N) with revursive stack space

    public static void recursivePostorder(Node node){
        if(node==null){
            return;
        }

        recursivePostorder(node.left);
        recursivePostorder(node.right);
        System.out.println(node.data+" ");
    }

    public static void IterativePostorder(Node root){
        Node curr = root;

        Stack<Node> st = new Stack<Node>();
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                Node temp= st.peek().right;
                if(temp==null){
                    temp = st.pop();
                    System.out.println(temp.data+" ");

                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.println(temp.data+" ");
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
    }
}
