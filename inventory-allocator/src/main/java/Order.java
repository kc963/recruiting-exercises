
// Class : Order
// Purpose : To represent the data in the order provided by the user

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Order {

	private Map<String, Integer> orderedItems;

	public Order(Map<String, Integer> orderedItems) {
		this.orderedItems = orderedItems;
		checkForNegativeQuantity();
	}

	public Order(Order order) {
		orderedItems = order.orderedItems;
		checkForNegativeQuantity();
	}

	public Map<String, Integer> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Map<String, Integer> items) {
		orderedItems = items;
		checkForNegativeQuantity();
	}

	public String toString() {
		return orderedItems.toString();
	}

	// remove the product if its quantity is negative
	private void checkForNegativeQuantity() {
		Iterator<Entry<String, Integer>> iterator = orderedItems.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue() < 0) {
				System.out.println("UPDATE: Removing item \"" + entry.getKey() + "\" because of negative quantity.");
				iterator.remove();
			}
		}
	}

}
