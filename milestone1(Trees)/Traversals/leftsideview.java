import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class leftsideview {
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(N)
    public List<Integer> leftSideView(Node root){
        ArrayList<Integer> list= new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=1;i<=size;i++){
                Node rn = queue.poll();
                if(i==1){
                    list.add(rn.data);
                }
                if(rn.left!=null){
                    queue.add(rn.left);
                }
                if(rn.right!=null){
                    queue.add(rn.right);
                }
            }


        }
        return list;
    }
}
