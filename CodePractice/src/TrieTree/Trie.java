package TrieTree;

/**
 * 字典树的实现
 * @author qyl
 *
 */
public class Trie
{
	Node root ;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	
    	Node node = root;
        for(char ch:word.toCharArray()) {
        	Node[] child = node.child;
        	if(child[ch-'a']==null) {
        		child[ch-'a'] = new Node();
        	}
            
        	node = child[ch-'a'];
        }
		node.isEnd=true;         		
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Node node = findWord(word);
    	return node!=null&&node.isEnd;    
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
          return findWord(prefix)!=null;   
    }
    
    private Node findWord(String word) {
    	Node node = root;
    	for(char ch:word.toCharArray()){
        	Node[] child = node.child;
        	if(child[ch-'a']==null) {
        		return null;
        	}    	
            node = child[ch-'a'];
    	}
		return node; 
    }
    class Node{
    	boolean isEnd = false ;
    	Node[] child = new Node[26];
    	public Node() {
    		
    	}
    }

    public static void main(String args[]) {
    	Trie trie = new Trie();
    	trie.insert("apple");
    	System.out.println(""+trie.search("apple"));
    	System.out.println(""+trie.search("app"));
    	System.out.println(""+trie.startsWith("app"));
    	trie.insert("app");   
    	System.out.println(""+trie.search("app"));
    	
    	System.out.println(""+trie.startsWith("a"));
    }
}
