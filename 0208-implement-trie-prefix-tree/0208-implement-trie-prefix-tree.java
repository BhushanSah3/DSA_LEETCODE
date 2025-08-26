class Trie {
    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        boolean contains(char ch) {
            int index = ch - 'a';
            if (links[index] != null) {
                return true;
            }
            else {
                return false;
            }
        }

        void put(char ch, Node node) {
            links[ch - 'a']=node ;
        }

        void setflagtrue() {
            flag = true;
        }

        boolean  checkflagtrue() {
            return flag;
        }
        
        Node follow(char ch){
            return links[ch-'a'];
        }

    }
    private Node root;

    public Trie() {
         root = new Node();

    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.put(word.charAt(i), new Node() );
                
            }
            node=node.follow(word.charAt(i));
        }
        node.setflagtrue();

    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                return false;
            }
            node= node.follow(word.charAt(i));

        }
        return node.checkflagtrue();

    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.contains(prefix.charAt(i))) {
                return false;
            }
            node =node.follow(prefix.charAt(i));

        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */