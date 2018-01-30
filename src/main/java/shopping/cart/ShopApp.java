package shopping.cart;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ShopApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

		String choice = "";
		String nameInput = "";
		double unitPriceInput;
		int quantityInput;
		Item itemInput;

		Cart cart = new Cart();

		do {
			System.out.println();
			System.out.println("Shopping Cart Menu");
			System.out.println();
			if (cart.listSize() == 0) {
				System.out.println("Your shopping cart is currently empty.");
			} else {
				System.out.println("Your current shopping cart contents:");
				System.out.println();
				for (int i = 0; i < cart.listSize(); i++) {
					System.out.println(cart.getItem(i));
				}
				System.out.println("-----");
				System.out.println("Total Cart Price: " + currencyFormatter.format(cart.getTotalCartPrice()));
			}
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("1. Add new item to cart");
			System.out.println("2. Modify existing item quantity");
			System.out.println("3. Remove item from cart");
			System.out.println("4. Quit");
			choice = input.next().trim();
			System.out.println();

			switch (choice) {
			case "1":
				System.out.println("Please enter the name of the item:");
				nameInput = input.nextLine().trim();
				if (cart.listSize() > 0) {

				}
				System.out.println();
				System.out.println("Please enter the unit price of the item:");
				unitPriceInput = input.nextDouble();
				System.out.println();
				System.out.println("Please enter the quantity of the item:");
				quantityInput = input.nextInt();
				itemInput = new Item(nameInput, unitPriceInput, quantityInput);
				cart.addItem(itemInput);
			}

		} while (!choice.equals("4"));

	}
}
