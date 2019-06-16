
// class : Warehouse
// purpose : To represent the data associated with a warehouse.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Warehouse {

	private String name;
	private Map<String, Integer> inventory;

	public Warehouse() {
		name = "";
		inventory = new HashMap<String, Integer>();
	}

	public Warehouse(String warehouseName, Map<String, Integer> inventory) {
		name = warehouseName;
		this.inventory = inventory;
	}

	public Warehouse(Warehouse warehouse) {
		name = warehouse.name;
		inventory = warehouse.inventory;
		checkForNegativeQuantity();
	}

	public String getName() {
		return name;
	}

	public void setName(String warehouseName) {
		name = warehouseName;
	}

	public Map<String, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<String, Integer> inventory) {
		this.inventory = inventory;
		checkForNegativeQuantity();
	}

	public String toString() {
		return "{ name : " + name + ", inventory : " + inventory + " }";
	}

	// remove the product if its quantity is negative
	private void checkForNegativeQuantity() {
		Iterator<Entry<String, Integer>> iterator = inventory.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue() < 0) {
				System.out.println("UPDATE: Removing item \"" + entry.getKey() + "\" because of negative quantity.");
				iterator.remove();
			}
		}
	}

}