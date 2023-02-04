import java.util.*;
public class Combinations {

        public void combination(List<Integer> l, int num,int upto, int k , List<List<Integer>> result){
            if(l.size()==k){
                result.add(new ArrayList<>(l));
                return;
            }
            for(int i = num; i<=upto ;i++){
                l.add(i);
                combination(l,i+1,upto,k,result);
                l.remove(l.size()-1);
            }
            
        
            
        }
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            combination(new ArrayList<>(),1,n,k,result);
            return result;
        }

        public static void main(String[] args) {
            Combinations c = new Combinations();
            int n =4;
            int k = 2;
            System.out.println(c.combine(n,k));
        }
    }
