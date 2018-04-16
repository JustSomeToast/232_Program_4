/*
 * Authors: Tyler Gentry, Gavin Austin
 * Date: 24 April 2018
 * Overview: This program extends the change-making problem to find the denomination 
 * of each coin in the minimum number of coins that add up to the given amount of money.
 * There is no main method. Execution is triggered by the JUnit test cases.
 */

package dynamiccoins;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dynamiccoins.DynamicCoins;

class DynamicCoinsTest {

	@Test
	void emptyCoinArray() {
		int[] coins = {};
		Exception e = assertThrows(IllegalArgumentException.class, () -> {  DynamicCoins.makeChange(coins, 0); } );
		assertEquals("Array of size 0 not allowed", e.getMessage());	
	}
	
	@Test
	void negativeChange() {
		int[] coins = {1, 5, 10, 25};
		int change = -1;
		assertEquals(0, DynamicCoins.makeChange(coins, change));
	}
	
	@Test
	void zeroChange() {
		int[] coins = {1, 5, 10, 25};
		int change = 0;
		assertEquals(1, DynamicCoins.makeChange(coins, change));
	}
}
