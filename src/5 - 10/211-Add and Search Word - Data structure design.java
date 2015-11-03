class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    public TrieNode(){}
    public TrieNode(char c){
        this.c = c;
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);   
    }

    private boolean search(String word, int index, TrieNode root){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = root;
        for(int i=index;i<word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode tmp : children.values()){
                    if(i == word.length() - 1 && tmp.isLeaf){
                        return true;
                    }
                    if(search(word, i+1, tmp)){
                        return true;
                    }
                }
                return false;
            }
            else if(!children.containsKey(c)){
                return false;
            }
            else{
                t = children.get(c);
            }
            if(i == word.length() - 1){
                return t.isLeaf;
            }
            children = t.children;
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");