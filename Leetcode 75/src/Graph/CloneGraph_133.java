package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node ==null){
            return null;
        }
        HashMap<Node , Node> map=new HashMap<>();
        return dfs(node,map);
    }

    private Node dfs(Node node,HashMap<Node,Node> map) {
        Node newNode=new Node(node.val);
        List<Node> neigh=new ArrayList<>();
        map.put(node,newNode);
        for(Node neighbours : node.neighbors){
            if(map.get(neighbours) !=null){
                neigh.add(map.get(neighbours));
            }
            else {
                Node n=dfs(neighbours,map);
                neigh.add(n);
            }
        }
        newNode.neighbors=neigh;
        return newNode;
    }
}
