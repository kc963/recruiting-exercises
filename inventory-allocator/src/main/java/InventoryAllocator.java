import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class InventoryAllocator {

	public List<Map<String, Map<String, Integer>>> getCheapestShipment(Order order, List<Warehouse> warehouses) {

		// final shipment
		List<Map<String, Map<String, Integer>>> orderShipment = new LinkedList<Map<String, Map<String, Integer>>>();

		// NullOrder case
		if (order == null) {
			System.out.println("ERROR: No order provided");
			return orderShipment;
		}

		// NullWarehouses case
		if (warehouses == null) {
			System.out.println("ERROR: No warehouses provided");
			return orderShipment;
		}

		Map<String, Integer> orderedItems = new HashMap<String, Integer>();
		orderedItems.putAll(order.getOrderedItems());

		if (orderedItems.isEmpty()) {
			System.out.println("ERROR: No items ordered");
		} else if (warehouses.isEmpty()) {
			System.out.println("ERROR: No warehouses selected");
		} else {
			findCheapestShipment(orderShipment, orderedItems, warehouses);
		}

		return orderShipment;
	}

	public void findCheapestShipment(List<Map<String, Map<String, Integer>>> orderShipment,
			Map<String, Integer> orderedItems, List<Warehouse> warehouses) {

		for (Warehouse warehouse : warehouses) {

			Map<String, Integer> itemsSupplied = new HashMap<String, Integer>();
			Map<String, Map<String, Integer>> shipment = new HashMap<String, Map<String, Integer>>();

			// Supply the ordered items that are available in the warehouse
			fulFillOrder(orderedItems, warehouse, itemsSupplied);

			// Update orderedItems - Delete the items that can be supplied by a warehouse in
			// the list
			updateOrderedItems(orderedItems, itemsSupplied);

			// Ship the items
			if (!itemsSupplied.isEmpty()) {
				shipment.put(warehouse.getName(), itemsSupplied);
				orderShipment.add(shipment);
			}

		}

		if (!orderedItems.isEmpty()) {
			System.out.println("ERROR: Out of Stock");
			orderShipment.clear();
		}

	}

	private void fulFillOrder(Map<String, Integer> orderedItems, Warehouse warehouse,
			Map<String, Integer> itemsSupplied) {

		Map<String, Integer> warehouseInventory = warehouse.getInventory();
		for (Map.Entry<String, Integer> item : orderedItems.entrySet()) {
			String orderedItemName = item.getKey();
			int orderedItemValue = item.getValue();

			if (warehouseInventory.containsKey(orderedItemName)) {
				if (warehouseInventory.get(orderedItemName) < orderedItemValue) {
					itemsSupplied.put(orderedItemName, warehouseInventory.get(orderedItemName));
				} else {
					itemsSupplied.put(orderedItemName, orderedItemValue);
				}
			}
		}

	}

	private void updateOrderedItems(Map<String, Integer> orderedItems, Map<String, Integer> itemsSupplied) {

		for (Map.Entry<String, Integer> item : itemsSupplied.entrySet()) {
			if (orderedItems.get(item.getKey()) > item.getValue()) {
				orderedItems.replace(item.getKey(), orderedItems.get(item.getKey()) - item.getValue());
			} else {
				orderedItems.remove(item.getKey());
			}
		}

	}

}
