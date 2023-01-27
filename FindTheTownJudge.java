public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n];
        for(int i =0;i<trust.length;i++){
            people[trust[i][1]-1]=people[trust[i][1]-1]+1;
            people[trust[i][0]-1]=people[trust[i][0]-1]-1;
            
        }
        for(int i =0;i<people.length;i++){
            if(people[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}
