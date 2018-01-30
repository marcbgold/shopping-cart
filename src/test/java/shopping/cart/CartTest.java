package shopping.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CartTest {

	@Test
	public void shouldInstantiateACartObject() {
		Cart underTest = new Cart();

		assertNotNull(underTest);
	}

	@Test
	public void shouldAddOneItem() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 0, 0));

		int check = underTest.getTotalItems();

		assertEquals(1, check);
	}

	@Test
	public void shouldAddTwoItems() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 0, 0));
		underTest.addItem(new Item("", 0, 0));

		int check = underTest.getTotalItems();

		assertEquals(2, check);
	}

	@Test
	public void shouldRemoveOneItem() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("test", 0, 0));
		underTest.addItem(new Item("test2", 0, 0));
		underTest.removeItem(0);

		int check = underTest.getTotalItems();

		assertEquals(1, check);
	}

	@Test
	public void shouldModifyQuantityOfOneItem() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("test", 10, 1));
		underTest.modifyItemQuantity(0, 2);

		int quantity = underTest.getItemQuantity(0);

		assertEquals(2, quantity);
	}

	@Test
	public void shouldDisplayTotalCartPrice() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("test", 10, 1));
		underTest.addItem(new Item("test2", 8, 2));

		double totalPrice = underTest.getTotalCartPrice();

		assertEquals(26, totalPrice, 0.001);
	}

	@Test
	public void shouldCheckIfItemIsAlreadyInCart() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("Test", 10, 1));

		boolean check = underTest.checkCartForItem("test");

		assertEquals(true, check);
	}
}
