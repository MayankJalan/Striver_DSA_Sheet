package Trie;

public class ImplementTrie {
    public class Node {
        Node links[] = new Node[26];
        int cntPrefix = 0;
        int cntEndWith = 0;
        boolean isEnd;

        public Node() {

        }

        public void put(Node node, char ch) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        int getCntPrefix() {
            return cntPrefix;
        }

        int getCntEndWith() {
            return cntEndWith;
        }

        public void increasePrefix() {
            cntPrefix++;
        }

        public void decreasePrefix() {
            cntPrefix--;
        }

        public void increaseEnd() {
            cntEndWith++;
        }

        public void decreaseEnd() {
            cntEndWith--;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }

    public class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (node.get(ch) == null) {
                    node.put(new Node(), ch);
                }
                node = node.get(ch);
                node.increasePrefix();
            }
            node.increaseEnd();
            // Write your code here.
        }

        public int countWordsEqualTo(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (node.get(ch) == null) {
                    return 0;
                }
                node = node.get(ch);
            }
            return node.getCntEndWith();


            // Write your code here.
        }

        public int countWordsStartingWith(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (node.get(ch) == null) {
                    return 0;
                }
                node = node.get(ch);
            }
            return node.getCntPrefix();
            // Write your code here.
        }

        public void erase(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                node = node.get(ch);
                node.decreasePrefix();
            }
            node.decreaseEnd();
            // Write your code here.
        }

        // Write your code here.


    }


}
