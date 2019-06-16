// Class : InventoryManager
// Purpose : To show the utilization of InventoryAllocator class

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InventoryManager {

	public static void main(String[] args) {

		// Prepare Order
		Map<String, Integer> orderItems = new HashMap<String, Integer>();
		orderItems.put("apple", 5);
		orderItems.put("kiwi", 8);
		orderItems.put("orange", 12);
		orderItems.put("watermelon", 2);
		Order order = new Order(orderItems);

		// Prepare Warehouses
		Map<String, Integer> w1Inventory = new HashMap<String, Integer>();
		w1Inventory.put("banana", 15);
		Warehouse w1 = new Warehouse("W1", w1Inventory);

		Map<String, Integer> w2Inventory = new HashMap<String, Integer>();
		w2Inventory.put("kiwi", 5);
		w2Inventory.put("orange", 20);
		Warehouse w2 = new Warehouse("W2", w2Inventory);

		Map<String, Integer> w3Inventory = new HashMap<String, Integer>();
		w3Inventory.put("apple", 7);
		w3Inventory.put("kiwi", 20);
		w3Inventory.put("orange", 15);
		w3Inventory.put("watermelon", 8);
		Warehouse w3 = new Warehouse("W3", w3Inventory);

		// Prepare List of warehouses
		List<Warehouse> warehouses = new LinkedList<Warehouse>();
		warehouses.addAll(Arrays.asList(w1, w2, w3));

		// Prepare Inventory Allocator
		InventoryAllocator allocator = new InventoryAllocator();

		List<Map<String, Map<String, Integer>>> cheapestShipment = allocator.getCheapestShipment(order, warehouses);

		System.out.println(cheapestShipment);

	}

}
