class Node{
    boolean flag = false;
    Node[] list = new Node[26];

    Node get(int ch){
        return list[ch-97];
    }
    void put(int ch){
        list[ch-97]=new Node();
    }
    boolean containsKey(int ch){
        return list[ch-97]!=null;
    }
    boolean isEnd(){
        return flag;
    }
    void setEnd(){
        flag = true;
    }

}
class Trie {
    static Node head;
    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node ptr = head;
        for(int i =0;i<word.length();i++){
            if(ptr.get(word.charAt(i))==null){
                ptr.put(word.charAt(i));
            }
            ptr=ptr.get(word.charAt(i));
        }
        ptr.setEnd();
    }
    
    public boolean search(String word) {
        Node ptr = head;
        for(int i =0;i<word.length();i++){
            if(ptr.get(word.charAt(i))==null)
                return false;
            ptr=ptr.get(word.charAt(i));
        }
        return ptr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node ptr = head;
        for(int i =0;i<prefix.length();i++){
            if(ptr.get(prefix.charAt(i))==null)
                return false;
            ptr = ptr.get(prefix.charAt(i));
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

public class ImplementationTrie{
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     //return true
    }
}
