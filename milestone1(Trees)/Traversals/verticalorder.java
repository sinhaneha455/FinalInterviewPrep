import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;

/**
 * verticalorder
 */
public class verticalorder {
    class PairQueue {
        Node node;
        int vd;

        PairQueue(Node node, int vd) {
            this.node = node;
            this.vd = vd;
        }

    }

    class PairMap {
        Node node;
        int hd;

        PairMap(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<Integer>();
        int count = 0;
        int minVD = 0;
        int maxVD = 0;
        HashMap<Integer, ArrayList<PairMap>> map = new HashMap<>();
        Queue<PairQueue> queue = new LinkedList<>();
        queue.add(new PairQueue(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                PairQueue removePair = queue.poll();
                map.putIfAbsent(removePair.vd, new ArrayList<>());
                minVD = Math.min(minVD, removePair.vd);
                maxVD = Math.max(maxVD, removePair.vd);

                map.get(removePair.vd).add(new PairMap(removePair.node, count));
                if (removePair.node.left != null) {
                    queue.add(new PairQueue(removePair.node.left, removePair.vd - 1));
                }
                if (removePair.node.right != null) {
                    queue.add(new PairQueue(removePair.node.right, removePair.vd + 1));

                }

            }

            count++;

        }
        int index = 0;
        for (int i = minVD; i <= maxVD; i++) {
            Collections.sort(map.get(i), (a, b) -> {
                if (a.hd == b.hd) {
                    return a.node.data - b.node.data;
                } else {
                    return a.hd - b.hd;
                }
            });

            res.add(new ArrayList<>());
            for (PairMap pair : map.get(i)) {
                res.get(index).add(pair.node.val);
            }
            index++;

        }

        return res;
    }

}