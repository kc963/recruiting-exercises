import java.util.List;

public class InventoryAllocatorInput {

	private Order order;
	private List<Warehouse> warehouses;
	
	public InventoryAllocatorInput(Order o, List<Warehouse> listOfWarehouses) {
		order = o;
		warehouses = listOfWarehouses;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order o) {
		order = o;
	}
	
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}
	
	public void setWarehouses(List<Warehouse> listOfWarehouses) {
		warehouses = listOfWarehouses;
	}
	
	public String toString() {
		return "{ Order:" + order + ", Warehouses:" + warehouses + " }";
	}
}
