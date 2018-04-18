/*
 * Authors: Tyler Gentry, Gavin Austin
 * Date: 24 April 2018
 * Overview: This program extends the change-making problem to find the denomination 
 * of each coin in the minimum number of coins that add up to the given amount of money.
 * There is no main method. Execution is triggered by the JUnit test cases.
 */

package dynamiccoins;

	
import java.util.Arrays;


public class DynamicCoins {

    public static int[] makeChange(int[] coins, int change){
    	
    	if (coins.length == 0) { //if we receive an empty coin array
            throw new IllegalArgumentException("Array of size 0 not allowed");
        }
    
    	if(change <= 0) { //if we have no change or less than 0
    		System.out.println("No coins needed for change of " + change +"\n");
    		int[] result = {};
    		return result;
    	}
    	
        int[] coinsNeeded = new int[change + 1]; //min coins required to make change value
        int[]  prevCoin = new int[change + 1]; //previous coin we got current coins needed from
        
        coinsNeeded[0] = 0; //0 coins needed for change of 0
        
        for(int k=1; k<=change; k++){ //set initial coins needed to infinite and prev coin to -1
            coinsNeeded[k] = Integer.MAX_VALUE;
            prevCoin[k] = -1;
        }
        
        for(int i=0; i< coins.length; i++){ //for each coin denom
            for(int j=1; j<=change; j++){ //for each value up to our total change
                if(j >= coins[i]){ //if our current index is less than our current coin denom
                    if(coinsNeeded[j - coins[i]] + 1 < coinsNeeded[j]){
                        coinsNeeded[j] = 1 + coinsNeeded[j - coins[i]]; //min coins required to form current change amount
                        prevCoin[j] = i; //index of previous coin we got current min coins from
                    }
                }
            }
        }
        
        int amount = change; //target amount
        int result[] = new int[coinsNeeded[change]]; //the coins needed to make change
        
        while (amount > 0) { //build our array of coins needed
            result[coinsNeeded[amount] - 1] = coins[prevCoin[amount]]; //the coin needed is found in our coins array at our previous coin location at our current amount
            amount = amount - coins[prevCoin[amount]]; //subtract the coin we used from our amount
        }
        
        System.out.println("Change = " + change); //print out change, denoms, and coins used
        System.out.println("Coin denoms are: " + Arrays.toString(coins));
        System.out.println("Coins needed are:");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        
        return result; //return array of coins used
    }
}
