import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class rightsideview {
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(N)
    public List<Integer> rightSideView(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size >0){
                TreeNode rn = queue.poll();
                if(size==1){
                    list.add(rn.data);
                }
                if(rn.left!=null){
                    queue.add(rn.left);

                }
                if(rn.right!=null){
                    queue.add(rn.right);
                }
                size--;
            }
        }

        return list;
    }
}
