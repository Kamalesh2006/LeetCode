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

/*ArrayList is used to store the String from the user

    HashSet is used to store the search word because if same word is passed twice to 
    search we can determine it by using the hashset.

    private ArrayList<String> wordArray;
    private HashSet<String> searchWordArray;

    public WordDictionary() {
        //this is used to initialize the instance variable

        wordArray = new ArrayList<String>();
        searchWordArray= new HashSet<String>();
    }
    
    public void addWord(String word) {

        wordArray.add(word);

    }
    
    public boolean search(String word) {
        first the search word is checked in hashset and if it is present, then the search word is 
        already been traversed in the String ArrayList and found to be true

        int matchCount; //matchCount keep track of character matches in the String with searchword.

        if(searchWordArray.contains(word)){
            return true;
        }

        for(int i =0;i<wordArray.size();i++){

            matchCount=0;

            if(wordArray.get(i).length()!=word.length()){
                continue;
            }

            for(int j=0;j<word.length();j++){

                if(word.charAt(j)=='.'){
                    matchCount++;
                }

                else if(wordArray.get(i).charAt(j)==word.charAt(j)){
                    matchCount++;
                }

                if(matchCount!=j+1){
                    break;
                }

            }
            if(matchCount==word.length()){
                searchWordArray.add(word);
                return true;
            }
        }
        return false;
    } 
   
}*/
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
