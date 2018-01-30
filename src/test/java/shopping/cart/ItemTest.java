package shopping.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ItemTest {

	@Test
	public void shouldInstantiateAnItemObject() {
		Item underTest = new Item();

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiateAnItemObjectWithAllValues() {
		Item underTest = new Item("test", 10, 3);

		String name = underTest.getName();
		double unitPrice = underTest.getUnitPrice();
		int quantity = underTest.getQuantity();
		double totalPrice = underTest.getTotalPrice();

		assertEquals("test", name);
		assertEquals(10, unitPrice, 0.001);
		assertEquals(3, quantity);
		assertEquals(30, totalPrice, 0.001);

	}

	@Test
	public void shouldUpdateQuantityAndTotalPrice() {
		Item underTest = new Item("test", 10, 3);

		underTest.updateQuantityAndTotalPrice(4);
		int quantity = underTest.getQuantity();
		double totalPrice = underTest.getTotalPrice();

		assertEquals(4, quantity);
		assertEquals(40, totalPrice, .001);
	}

}
