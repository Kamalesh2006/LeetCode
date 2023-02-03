import java.util.Arrays;

public class CoinChange {
    public int coinCombination(int i, int[] coins, int amount, int[][] dp){
        if(amount <0 || i==coins.length)
            return Integer.MAX_VALUE-1;
        if(amount==0)
            return 0;
        if(dp[amount][i]!=0)
            return dp[amount][i];
        dp[amount][i]= Math.min(1+coinCombination(i,coins,amount-coins[i],dp),coinCombination(i+1,coins,amount,dp));
        return dp[amount][i];
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length];
        Arrays.sort(coins);
        int result =coinCombination(0,coins,amount,dp);
        return result==Integer.MAX_VALUE-1?-1:result;
    }
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1,2,3,5}, 23));
    }
}
