import java.util.Stack;
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> parenthesisIndexStack = new Stack<Integer>();
        Stack<Integer> asterickIndex = new Stack<Integer>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                parenthesisIndexStack.push(i);
            }
            else if(s.charAt(i)==')'){
                if(parenthesisIndexStack.isEmpty() && asterickIndex.isEmpty())
                    return false;
                else if(!parenthesisIndexStack.isEmpty())
                    parenthesisIndexStack.pop();
                else if(!asterickIndex.isEmpty()){
                    asterickIndex.pop();
                    
                }
                
            }
            else if(s.charAt(i)=='*')
                asterickIndex.push(i);
        }
        if(parenthesisIndexStack.size()>asterickIndex.size())
            return false;
        while(!parenthesisIndexStack.isEmpty()){
            if(parenthesisIndexStack.pop()<asterickIndex.pop())
                continue;
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidParenthesisString vs = new ValidParenthesisString();
        System.out.println(vs.checkValidString("(*))"));
    }
}
