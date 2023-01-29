public class PermutationInString {
    /**
     * 
     * @param s1 contains the string to be checked in s2
     * @param s2 this is the target string which contains the permutated string of s1
     * @return boolean value if it contains s2 contains the permutated string or not
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i =0;i<s1.length();i++){
            c1[s1.charAt(i)-97]++;
        }

        int count =0;
        boolean permutable = true;

        for(int i =0;i<s2.length();i++){

            c2[s2.charAt(i)-97]++;
            count++;
            
            if(count==s1.length()){
                permutable = true;
                for(int j =0;j<s1.length();j++){
                    int index = s1.charAt(j)-97;
                    if(c1[index]!=c2[index]){
                        permutable = false;
                        break;
                    }
                }
                if(permutable)
                    return true;

            c2[s2.charAt(i-count+1)-97]--;//it removes the starting character from the sliding window
            count--;
            
            }
            
        }
        return false;
    }
}
