package shopping.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<Item> items = new ArrayList<>();
	int totalCartPrice;

	public double getTotalCartPrice() {
		double sum = 0;
		for (Item i : items) {
			sum += i.getTotalPrice();
		}
		return sum;
	}

	public int getItemQuantity(int index) {
		return items.get(index).getQuantity();
	}

	public void addItem(Item itemToAdd) {
		items.add(itemToAdd);
	}

	public void modifyItemQuantity(int index, int newQuantity) {
		items.get(index).updateQuantityAndTotalPrice(newQuantity);
	}

	public void removeItem(int index) {
		items.remove(index);
	}

	public int getTotalItems() {
		return items.size();
	}

	public Item getItem(int index) {
		return items.get(index);
	}

	public boolean checkCartForItem(String nameCheck) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().toLowerCase().equals(nameCheck)) {
				return true;
			}
		}
		return false;
	}
}
