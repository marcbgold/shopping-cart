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
		int cartNumber;
		String nameInput = "";
		double unitPriceInput;
		int quantityInput;

		Cart cart = new Cart();

		do {
			System.out.println();
			System.out.println("Shopping Cart Menu");
			System.out.println();
			if (cart.getTotalItems() == 0) {
				System.out.println("Your shopping cart is currently empty.");
			} else {
				System.out.println("Your current shopping cart contents:");
				System.out.println();
				for (int i = 0; i < cart.getTotalItems(); i++) {
					System.out.println(i + 1 + ": " + cart.getItem(i));
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
			choice = input.nextLine().trim();
			System.out.println();

			switch (choice) {
			case "1":
				System.out.println("Please enter the name of the item:");
				nameInput = input.nextLine().trim();
				System.out.println();

				if (nameInput.equals("")) {
					System.out.println("That is not a valid name.  Please try again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				} else if (cart.getTotalItems() > 0 && cart.checkCartForItem(nameInput.toLowerCase())) {
					System.out.println("You already have that item in your cart.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				}

				System.out.println();
				System.out.println("Please enter the unit price of the item in dollars:");
				unitPriceInput = input.nextDouble();
				choice = input.nextLine();
				System.out.println();

				if (unitPriceInput <= 0) {
					System.out.println("That is not a valid price.  Please try again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				}

				System.out.println();
				System.out.println("Please enter the quantity of the item:");
				quantityInput = input.nextInt();
				choice = input.nextLine();
				System.out.println();

				if (quantityInput <= 0) {
					System.out.println("That is not a valid quantity.  Please try again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				}

				cart.addItem(new Item(nameInput, unitPriceInput, quantityInput));
				break;
			case "2":
				if (cart.getTotalItems() == 0) {
					System.out.println("There are no items in your cart to modify.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				}

				System.out.println("Please enter the cart number of the item you would like to modify:");
				cartNumber = input.nextInt();
				choice = input.nextLine();
				System.out.println();

				if (cartNumber < 1 || cartNumber > cart.getTotalItems()) {
					System.out.println("That is not a valid cart number.  Please try again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				} else {
					System.out.println("Please enter the new quantity you would like of that item:");
					quantityInput = input.nextInt();
					choice = input.nextLine();
					if (quantityInput <= 0) {
						System.out.println("That is not a valid quantity.  Please try again.");
						System.out.println("Press any key and then hit enter to continue.");
						choice = input.nextLine();
						continue;
					}
					cart.modifyItemQuantity(cartNumber - 1, quantityInput);
					break;
				}
			case "3":
				if (cart.getTotalItems() == 0) {
					System.out.println("There are no items in your cart to remove.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				}

				System.out.println("Please enter the cart number of the item you would like to remove:");
				cartNumber = input.nextInt();
				choice = input.nextLine();
				System.out.println();

				if (cartNumber < 1 || cartNumber > cart.getTotalItems()) {
					System.out.println("That is not a valid cart number.  Please try again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.nextLine();
					continue;
				} else {
					cart.removeItem(cartNumber - 1);
					break;
				}
			case "4":
				break;
			default:
				continue;
			}

		} while (!choice.equals("4"));

		System.out.println("Thank you for shopping.  Goodbye.");

		input.close();
	}
}
