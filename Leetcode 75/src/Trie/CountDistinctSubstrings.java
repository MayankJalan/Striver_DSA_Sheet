package Trie;

public class CountDistinctSubstrings {
    public static class Node {
        Node links[] = new Node[26];
        public Node() {

        }
        public void put(Node node, char ch) {
            links[ch - 'a'] = node;
        }
        Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    public static int countDistinctSubstrings(String s) {
        int n =s.length();
        int ans=0;
        Node root=new Node();
        
        for(int i=0;i<n;i++){
            Node node=root;
            for(int j=i;j<n;j++){
                char ch =s.charAt(j);
                if(node.get(ch) == null){
                    ans++;
                    node.put(new Node(),ch);
                }
                node= node.get(ch);
            }
        }
        
        return ans;
        
        //	  Write your code here.
    }
    
}
