/*
 * Authors: Tyler Gentry, Gavin Austin
 * Date: 24 April 2018
 * Overview: This program extends the change-making problem to find the denomination 
 * of each coin in the minimum number of coins that add up to the given amount of money.
 * There is no main method. Execution is triggered by the JUnit test cases.
 */

package dynamiccoins;

import java.util.Arrays;
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
		int[] coinsUsed = {};
		assertEquals(true, Arrays.equals(coinsUsed, DynamicCoins.makeChange(coins, change)));
	}
	
	@Test
	void zeroChange() {
		int[] coins = {1, 5, 10, 25};
		int change = 0;
		int[] coinsUsed = {};
		assertEquals(true, Arrays.equals(coinsUsed, DynamicCoins.makeChange(coins, change)));
	}
	
	
	@Test	
	void oddChangeUSCoins() {
		int[] coins = {1, 5, 10, 25};
		int change = 73;
		int[] coinsUsed = {1, 1, 1, 10, 10, 25, 25};
		assertEquals(true, Arrays.equals(coinsUsed, DynamicCoins.makeChange(coins, change)));
	}
	
	@Test
	void evenChangeStrangeCoins() {
		int coins[] = {1, 7, 12, 25};
		int change = 84;
		int[] coinsUsed = {1, 1, 7, 25, 25, 25};
		assertEquals(true, Arrays.equals(coinsUsed, DynamicCoins.makeChange(coins, change)));
	}
	
	@Test
	void with12CentCoin() {
		int[] coins = {1, 5, 12, 25};
		int change = 16;
		int[] coinsUsed = {1, 5, 5, 5};
		assertEquals(true, Arrays.equals(coinsUsed, DynamicCoins.makeChange(coins, change)));
	}
	
}
