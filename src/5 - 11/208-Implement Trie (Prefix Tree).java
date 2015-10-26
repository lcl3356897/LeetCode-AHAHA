class TrieNode {
    // Initialize your data structure here.
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }
            else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if(i == word.length() - 1){
                t.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!children.containsKey(c)){
                return false;
            }
            TrieNode t = children.get(c);
            if(i == word.length() - 1){
                return t.isLeaf;
            }
            children = t.children;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!children.containsKey(c)){
                return false;
            }
            children = children.get(c).children;
        }
        return true;
    }
}



//=====================================================


class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
}
 
//Trie
public class Trie{
    public TrieNode root = new TrieNode();
 
    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']= new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }
 
    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        if(node.item.equals(word)){
            return true;
        }else{
            return false;
        }
    }
 
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}