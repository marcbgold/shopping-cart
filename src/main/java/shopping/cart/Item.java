package shopping.cart;

import java.text.NumberFormat;
import java.util.Locale;

public class Item {

	private String name;
	private double unitPrice;
	private int quantity;
	private double totalPrice;

	Locale locale = new Locale("en", "US");
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

	public Item() {
		name = "";
	}

	public Item(String name, double unitPrice, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		totalPrice = unitPrice * quantity;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void updateQuantityAndTotalPrice(int quantity) {
		this.quantity = quantity;
		totalPrice = unitPrice * this.quantity;
	}

	@Override
	public String toString() {
		return (name + "     Quantity: " + quantity + "     Total Price: " + currencyFormatter.format(totalPrice));
	}

}
