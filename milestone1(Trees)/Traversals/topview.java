import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.attribute.standard.QueuedJobCount;

import org.w3c.dom.Node;

public class topview {
    public static void main(String[] args) {
        
    }
    public List<Integer> topView(Node root){
        class Pair{
            Node node;
            int dist;
            Pair(Node node , int dist){
                this.node = node;
                this.dist = dist;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        if(root==null){
            return list;
        }
        queue.add(new Pair(root , 0));
        while(!queue.isEmpty()){
            Pair removePair = queue.poll();
            if(!map.containsKey(removePair.dist)){
                map.put(removePair.dist , removePair.node);
            }
            if(removePair.node.left!=null){
                queue.add(new Pair(removePair.node.left , removePair.dist-1));
            }
            if(removePair.node.right!=null){
                queue.add(new Pair(removePair.node.right , removePair.dist+1));
            }
        }

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedKeys);
        for(Integer x:sortedKeys){
            list.add(map.get(x).data);
        }

        return list;

    }
}
