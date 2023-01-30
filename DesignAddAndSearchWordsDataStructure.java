class Node{
    boolean flag = false;
    Node[] list = new Node[26];
    Node(){

    }
    void setEnd(){
        flag = true;
    }
    boolean getEnd(){
        return flag;
    }
    boolean containsKey(int ch){
        return list[ch-97]!=null;
    }
    Node get(int ch){
        return list[ch-97];
    }
    void put(int ch){
        list[ch-97]=new Node();
    }
}
class WordDictionary {
    /*Implementing worddDictionary using trie*/
    private Node head;
    public WordDictionary() {
        head = new Node();
    }
    public void addWord(String word){
        Node temp = head;
        for(int i =0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i));
            }
            temp = temp.get(word.charAt(i));
        }
        
        temp.setEnd();
        
    }
    public boolean search(String word) {
        return searchNode(word,0,head);
    }
    public boolean searchNode(String word, int index, Node iterate){
        
        Node temp = iterate;
        boolean found = false;

        if(index == word.length())
            return temp.getEnd();

        if(word.charAt(index)=='.'){
            for(int j=0;j<26;j++){
                temp = iterate.list[j];
                if(temp!=null){
                    found = searchNode(word,index+1,temp);
                    if(found)
                        return true;
                }
            }
            return false;
        }
        
        if(iterate.get(word.charAt(index))==null)
            return found;
        temp = iterate.get(word.charAt(index));
        return searchNode(word,index+1,temp);

    }   
}
public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
