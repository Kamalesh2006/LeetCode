public class SortCharacterByFrequency {
    public void sort(int[] hash, char[] str){
        int start;
        for(int i =0;i<str.length;i++){
            start =0;
            boolean flag = false;
            while(start<str.length-i-1){
                if(hash[indexOf(str[start])]<hash[indexOf(str[start+1])] ){
                    flag = true;
                    char temp = str[start];
                    str[start]=str[start+1];
                    str[start+1]=temp;
                }
                start++;
            }

            if(flag==false)
                break;
        }
    }
    public int indexOf(int c){
        if(c>='a' && c<='z'){
            return c-'a';
        }
        else if(c>='A' && c<='Z'){
            return c-'A'+26;
        }
        else{
            return c-'0'+52;
        }
    }
    public char charAt(int index){
        if(index>=0 && index<=25){
            return (char)('a'+index);
        }
        else if(index>=26 && index<=51){
            return (char)('A'+index-26);
        }
        else{
            return (char)('0'+index-52);
        }
    }
    public String frequencySort(String s) {
        int[] hash = new int[62];
        char[] str = s.toCharArray();
        for(int i = 0;i<str.length;i++){
            if(str[i]>='a' && str[i]<='z'){
                hash[str[i]-'a']++;
            }
            else if(str[i]>='A' && str[i]<='Z'){
                hash[str[i]-'A'+26]++;
            }
            else if(str[i]>='0' && str[i]<='9'){
                hash[str[i]-'0'+52]++;
            }
            
        }
        s="";
        for(int i =0;i<hash.length;i++){
            if(hash[i]>0){
                s=s+charAt(i);
            }
        }

        char[] duplicatesRemovedStr= s.toCharArray();
        sort(hash,duplicatesRemovedStr);
        String result="";
        for(int i =0;i<duplicatesRemovedStr.length;i++){
            String temp = ""+duplicatesRemovedStr[i];
            result += temp.repeat(hash[indexOf(duplicatesRemovedStr[i])]);
        }
        return result;
        
    }
    public static void main(String[] args) {
        SortCharacterByFrequency sort = new SortCharacterByFrequency();
        System.out.println(sort.frequencySort("tree"));
    }
}
