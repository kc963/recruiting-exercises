import java.util.Map;

public class Order {

	private Map<String, Integer> orderedItems;
	
	public Order(Map<String, Integer> orderedItems) {
		this.orderedItems = orderedItems;
	}
	
	public Order(Order order) {
		orderedItems = order.orderedItems;
	}
	
	public Map<String, Integer> getOrderedItems() {
		return orderedItems;
	}
	
	public void setOrderedItems(Map<String, Integer> items) {
		orderedItems = items;
	}
	
	public String toString() {
		return orderedItems.toString();
	}
	
}
