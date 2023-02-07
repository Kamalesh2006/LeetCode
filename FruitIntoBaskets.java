import java.util.ArrayDeque;
public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        
        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        int[] fruitCount = new int[2];
        int maxBucketSize=0;
        int continuous =1;

        for(int fruit:fruits){
            if(bucket.size()<2 && !bucket.contains(fruit)){
                bucket.offer(fruit);
                fruitCount[bucket.size()-1]++;
            }
            else if(bucket.size()<2 && bucket.contains(fruit)){
                fruitCount[0]++;
            }
            else if(bucket.peekLast()==fruit && bucket.size()==2){
                fruitCount[1]++;
                continuous++;
            }
            else if(bucket.peekFirst()==fruit && bucket.size()==2){
                fruitCount[0]=fruitCount[1]+fruitCount[0]-(fruitCount[1]=fruitCount[0]);
                fruitCount[1]++;
                continuous=1;
                bucket.offerLast(bucket.pollFirst());
            }
            if(maxBucketSize<(fruitCount[0]+fruitCount[1])){
                    maxBucketSize = fruitCount[0]+fruitCount[1];
            }
            if(!bucket.contains(fruit) && bucket.size()==2){
                fruitCount[0]=continuous;
                continuous =1;
                bucket.pollFirst();
                bucket.offerLast(fruit);
                fruitCount[1]=1;
            }
            // System.out.println(bucket+" "+fruitCount[0]+" "+fruitCount[1]+" "+continuous2);
        }

        return maxBucketSize;
    }
    public static void main(String[] args) {
        FruitIntoBaskets f = new FruitIntoBaskets();
        int[] fruits = {1,2,3,2,2};
        System.out.println(f.totalFruit(fruits));

    }
}
