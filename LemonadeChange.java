public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five =0,ten = 0;
        for(int i =0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                ten++;
                if(five==0)
                    return false;
                five--;
            }
            else if(bills[i]==20){
                if(ten==0 && five==0)
                    return false;
                if(ten==0 && five<3){
                    return false;
                }
                if(ten>0){
                    ten--;
                    if(five>0)
                        five--;
                    else {
                        return false;
                    }
                }
                else if(five>=3){
                    five = five-3;
                }
               

            }
        }
        return true;   
    }
    public static void main(String[] args) {
        LemonadeChange lc = new LemonadeChange();
        int[] bills = {5,5,10,10,20};
        System.out.println(lc.lemonadeChange(bills));
    }
}