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
		Item underTest = new Item("test", 9.99, 3);

		String name = underTest.getName();
		double unitPrice = underTest.getUnitPrice();
		int quantity = underTest.getQuantity();

		assertEquals("test", name);
		assertEquals(9.99, unitPrice, 0.001);
		assertEquals(3, quantity);
	}

	@Test
	public void shouldModifyQuantity() {
		Item underTest = new Item("test", 9.99, 3);

		underTest.setQuantity(4);
		int quantity = underTest.getQuantity();

		assertEquals(4, quantity);
	}

}
