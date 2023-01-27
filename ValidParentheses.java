import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for(int i =0;i<s.length();i++){

            if(ch[i]=='{' || ch[i]=='('|| ch[i]=='['){
                stack.push(ch[i]);
            }
            
            else if(ch[i]=='}'|| ch[i]==']'||ch[i]==')'){
                if(stack.isEmpty()){
                    return false;
                }

                else if((ch[i]=='}' && stack.peek()=='{')||
                    (ch[i]==')' && stack.peek()=='(')||
                    (ch[i]==']' && stack.peek()=='[')){
                        stack.pop();
                }
                else{
                    stack.push(ch[i]);
                }
            }
        }
       
        return stack.isEmpty();
    }
}
