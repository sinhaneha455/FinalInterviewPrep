/**
 * preorder
 */
public class preorder {
    
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(1)without recurisve stack space
    //SC:O(N) with recursive stack space
    public static void RecusrivePreorder(Node node){
        if(node==null){
            return ;
        }
        System.out.println(node.data+" ");
        RecusrivePreorder(node.left);
        RecusrivePreorder(node.right);
    }


    //TC:O(N)
    //SC:O(N) --> becuase of stack
    public static void IterativePreorder(Node node){
        if(node==null){
            return;
        }
        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while(st.isEmpty()==false){
            Node removeelement = st.peek();
            System.out.println(removeelement.data+" ");
            st.pop();
            if(removeelement.right!=null){
                st.push(removeelement.right);
            }
            if(removeelement.left!=null){
                st.push(removeelement.left);
            }

        }
    }



    //TC:O(N)
    //SC:O(1) --> pure O(1) space used everything is same  as inorde only sysout(node.data) written in if loop not in else loop
    public static void MorrisTraversalPreorder(Node node){
        if(node==null){
            return;
        }

        while(node!=null){
            if(node.left==null){
             System.out.println(node.data+" ");
             node = node.right;
            }
            else{
                Node nodeP1 = node.left;
                while(nodeP1.right!=null && nodeP1.right!=node){
                    nodeP1= nodeP1.right;
                }
                if(nodeP1.right==null){
                    System.out.println(node.data+" ");
                    nodeP1.right = node;
                    node= node.left;

                }
                else{
                    nodeP1.right = null;
                    node =node.right;
                }
            }
        }
    }


    
}