public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        int maxProfit=0;
        int currentCost =prices[0];
        int tempMax =0;

        for(int i =1;i<prices.length;i++){

            if(prices[i]<currentCost){
                currentCost = prices[i];
            }
            tempMax = -currentCost+prices[i];
            if(tempMax>maxProfit)
                maxProfit = tempMax;
                
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        int maxProfit = b.maxProfit(new int []{7,1,5,3,6,4});
        System.out.println(maxProfit);
    }
}
