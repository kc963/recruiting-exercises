import java.util.List;
import java.util.Map;

public class InventoryAllocatorTestCase {
	
	private String name;
	private InventoryAllocatorInput input;
	private List<Map<String, Map<String, Integer>>> output;
	
	public InventoryAllocatorTestCase(String name, Order o, List<Warehouse> listOfWarehouses, List<Map<String, Map<String, Integer>>> cheapestShipment) {
		input = new InventoryAllocatorInput(o, listOfWarehouses);
		output = cheapestShipment;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public InventoryAllocatorInput getInput() {
		return input;
	}
	
	public void setInput(InventoryAllocatorInput input) {
		this.input = input;
	}
	
	public List<Map<String, Map<String, Integer>>> getOutput(){
		return output;
	}
	
	public void setOutput(List<Map<String, Map<String, Integer>>> output) {
		this.output = output;
	}
	
	public String toString() {
		return "{ Name:" + name + ", Input:" + input + ", Output:" + output + " }";
	}
	
}
