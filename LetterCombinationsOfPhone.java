import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfPhone {
    public void combinations(String eachComb, List<String> digitLetters, List<String> result){
        if(digitLetters.size()==0){
            result.add(eachComb);
            return;
        }
        String word = digitLetters.remove(0);

        for(int i=0;i<word.length();i++){
            String each= eachComb+word.charAt(i);   
            combinations(each,new ArrayList<>(digitLetters),result);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        String[] letters = {"abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> digitLetters = new ArrayList<>();
        for(int i =0;i<digits.length();i++){
            int index = Integer.parseInt(""+digits.charAt(i))-2;
            digitLetters.add(letters[index]);
        }
        combinations("",digitLetters, result);
        return result;
        
    }
}