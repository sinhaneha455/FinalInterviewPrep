import java.util.*;



public class inorder {
    public static void main(String[] args) {
        inorderSolve(root);

    }

    //TC:O(N)
    //SC:O(1)without recursive stack space
    //SC:O(N) with recursive stack space
    public static void inorderSolve(Node node){
        if(node==null){
            return;
        }
        inorderSolve(node.left);
        System.out.println(node.data+" ");
        inorderSolve(node.right);
    }
    

    //TC:O(N)
    //SC:O(N)

    public static void IterativeInorder(Node node){
        if(node==null){
            return;
        }
        Stack<Node> st = new Stack<Node>();
        Node curr = root;
        while(curr!=null || st.size()>0){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();
            System.out.println(curr.data+" ");
            curr=curr.right;
        }
         

    }



    //TC;O(N)
    //SC:O(1)
    //why the TC Of morris traversal is linear ?
    //ANS :- https://stackoverflow.com/questions/6478063/how-is-the-time-complexity-of-morris-traversal-on
    public static void MorrtisTrvaersal(Node node){
        if(node==null){
            return;
        }
        while(node!=null){
            if(node.left==null){
                System.out.println(node.data+" ");
                node=node.right;
            }

            else{
               Node nodeP1 = node.left;
               while(nodeP1.right!=null && nodeP1.right!=node){
                      nodeP1=nodeP1.right;
               }
               if(nodeP1.right==null){
                   nodeP1.right = node;
                   node=node.left;
               }
               else{ //nodeP1.right==node
                  System.out.println(node.data+" ");
                  nodeP1.right=null;
                  node=node.right;
               }
            }
        }
    }



}





