import java.util.HashMap;
import java.util.Map;

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
	}
	
	public String toString() {
		return "{ name : " + name + ", inventory : " + inventory + " }";
	}
	
}