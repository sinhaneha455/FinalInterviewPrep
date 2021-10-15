import java.util.HashMap;

import org.w3c.dom.Node;

public class bottomview {
    public static void main(String[] args) {
        
    }

    //TC:O(N)
    //SC:O(N)
    public List<Integer> bottomView(Node root){
        class Pair{
            Node node;
            int dist;
            Pair(Node node , int dist){
                this.node = node;
                this.dist = dist;
            }
            
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        if(root==null){
            return list;
        }

        queue.add(new Pair(root , 0));
        while(!queue.isEmpty()){
            Pair removePair = queue.poll();
            if(map.containsKey(removePair.dist)){
                map.put(removePair.dist , removePair.node);
            }
            else{
                map.put(removePair.dist, removePair.node);
            }

            if(removePair.node.left!=null){
                queue.add(new Pair(removePair.node.left ,removePair.dist-1));

            }
            if(removePair.node.right!=null){
                queue.add(new Pair(removePair.node.right , removePair.dist+1));

            }
        }

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedKeys);
        for(Integer x: sortedKeys){
            list.add(map.get(x).data);
        }

        return list;
    }
}
