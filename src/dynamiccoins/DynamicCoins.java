/*
 * Authors: Tyler Gentry, Gavin Austin
 * Date: 24 April 2018
 * Overview: This program extends the change-making problem to find the denomination 
 * of each coin in the minimum number of coins that add up to the given amount of money.
 * There is no main method. Execution is triggered by the JUnit test cases.
 */

package dynamiccoins;

import java.util.ArrayList;
import java.util.List;

public class DynamicCoins {

	public static List<Integer> makeChange(int[] coins, int change) {
		
		if (coins.length == 0) { //if we receive an empty coin array
			throw new IllegalArgumentException("Array of size 0 not allowed");
		}
		
		List<Integer> list= new ArrayList<>();
		
		//no coins if change is less than zero
		if (change <= 0) {
			list.add(0);
			return list;
		}
	
		return list;
	}
}
