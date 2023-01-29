import java.util.*;

public class WordBreak {
    /***
     * 
     * @param s contains the string to be formed using dictionary words
     * @param index of int value pointing in string s upto how much it can form using the dict words
     * @param wordDict is a List of String containing the words
     * @param dp boolean array 
     * @return boolean, returns true if the string can be formed using the words in dictionary
     */
    public boolean breakWords(String s, int index, List<String> wordDict,boolean[] dp){
        boolean flag = false;
        
        if(index==s.length()){
            return true;
        }
        
        for(int i =0;i<wordDict.size();i++){
            
            String word = wordDict.get(i);
            int tempIndex = index + word.length();
            if(tempIndex>s.length())
                continue;

            String temp = s.substring(index,tempIndex);
           

            if(word.equals(temp)){
                
                if(dp[tempIndex-1]==false){
                    continue;
                }
                flag = breakWords(s,tempIndex,wordDict,dp);
                if(flag){
                    return true;
                }
                else{
                    dp[tempIndex-1]=false;
                }
            }
            
        }
        
        return false;
        
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp,true);
        return breakWords(s,0,wordDict,dp);
    }
}
