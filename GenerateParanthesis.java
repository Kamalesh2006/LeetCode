import java.util.*;

class Solution {
    /***
     * 
     * @param paranthesis of String type which has valid paranthesis combinations
     * @param open int type, which says the number of open brackets used
     * @param close int type, which says the number of close brackets used
     * @param n int type
     * @param result of List<String> type which has the valid paranthesis
     */
    public void combinations(String paranthesis,int open, int close, int n,  List<String> result){

        //first open brackets count should reach the "n" count. Because close bracket without open brace doesn't make sense
        if(open==n){
            if(close<n){
                paranthesis = paranthesis +")";
                combinations(paranthesis, open, close+1, n, result);
            }
            else if(close==n){
                result.add(new String(paranthesis));
            }
        }

        else if(close<open){
            combinations(paranthesis+"(",open+1,close,n,result);
            combinations(paranthesis+")",open,close+1,n,result);
            
        }

        //if the open and the close count are matched then we should add open count to the paranthesis string
        else if(open==close){
            combinations(paranthesis+"(",open+1,close,n,result);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        combinations("(",1,0,n,result);
        return result;
    }
    
}
