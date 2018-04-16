package dynamiccoins;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dynamiccoins.DynamicCoins;

class DynamicCoinsTest {

	@Test
	void emptyCoinArray() {
		int[] array = {};
		Exception e = assertThrows(IllegalArgumentException.class, () -> {  DynamicCoins.makeChange(array, 0); } );
		assertEquals("Array of size 0 not allowed", e.getMessage());	
	}

}
