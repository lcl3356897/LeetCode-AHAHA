public class Solution {
	List<String> rst = new ArrayList<String>();
	Trie trie = new Trie();
	
    public List<String> findWords(char[][] board, String[] words) {
    	if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
    		return rst;
    	}
    	
    	for(String word : words){
    		trie.insert(word);
    	}
    	
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			helper(board, "", i, j, visited);
    		}
    	}
    	return rst;
    }
    public void helper(char[][] board, String str, int x, int y, boolean[][] visited){
    	if(x<0 || x>board.length-1 || y<0 || y>board[0].length-1 || visited[x][y]){
    		return;
    	}
    	str += board[x][y];
    	if(!trie.startsWith(str)){
    		return;
    	}
    	if(trie.search(str)){
    		if(rst.indexOf(str) == -1){
    		    rst.add(str);
    		}
    	}
    	visited[x][y] = true;
    	helper(board, str, x+1, y, visited);
    	helper(board, str, x-1, y, visited);
    	helper(board, str, x, y+1, visited);
    	helper(board, str, x, y-1, visited);
    	visited[x][y] = false;
    }
}

class TrieNode {
    // Initialize your data structure here.
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    
    public TrieNode() {}
        
    public TrieNode(char c){
    	this.c = c;
    }
    
}

class Trie {
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
    	TrieNode t = searchNode(word);
    	if(t != null && t.isLeaf){
    		return true;
    	}
    	else{
    		return false;
    	}
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null){
        	return false;
        }
        else{
        	return true;
        }
    }
    
    public TrieNode searchNode(String str){
    	HashMap<Character, TrieNode> children = root.children;
    	TrieNode t = null;
        for(int i=0;i<str.length();i++){
        	char c = str.charAt(i);
        	
        	if(children.containsKey(c)){
        		t = children.get(c);
            	children = t.children;
        	}
        	else{
        		return null;
        	}
        }
        return t;
    }
}