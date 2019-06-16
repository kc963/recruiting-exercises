import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class InventoryAllocatorTest {

	final static String testCaseFileName = "TestCaseFile.txt";
	static InventoryAllocator allocator;
	static Map<String, InventoryAllocatorTestCase> testCases;
	
	@BeforeAll
	public void beforeAll() {
		allocator = new InventoryAllocator();
		testCases = new HashMap<String, InventoryAllocatorTestCase>();
		loadTestCases();
	}
	
	@Test
	void testGetCheapestShipment_NullOrder() throws IOException {
		String testCaseIdentificationKey = "NullOrder";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_NullWarehouseList() throws IOException {
		String testCaseIdentificationKey = "NullWarehouseList";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_NoOrderedItem() throws IOException {
		String testCaseIdentificationKey = "NoOrderedItem";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_NoWarehouses() throws IOException {
		String testCaseIdentificationKey = "NoWarehouses";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_NoOrderedItemAvailable() throws IOException {
		String testCaseIdentificationKey = "NoOrderedItemAvailable";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_SomeOrderedItemsAvailable() throws IOException {
		String testCaseIdentificationKey = "SomeOrderedItemsAvailable";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_LessQuantityAvailableInWarehouses() throws IOException {
		String testCaseIdentificationKey = "LessQuantityAvailableInWarehouses";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_AllOrderedItemsAvailableInOneWarehouse() {
		String testCaseIdentificationKey = "AllOrderedItemsAvailableInOneWarehouse";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	@Test
	void testGetCheapestShipment_AllOrderedItemsAvailableAndSpreadOut() {
		String testCaseIdentificationKey = "AllOrderedItemsAvailableAndSpreadOut";
		InventoryAllocatorInput input = testCases.get(testCaseIdentificationKey).getInput();
		assertEquals(testCases.get(testCaseIdentificationKey).getOutput(), allocator.getCheapestShipment(input.getOrder(), input.getWarehouses()));
	}
	
	void loadTestCases() {
		File file = new File(getClass().getClassLoader().getResource(testCaseFileName).getFile());
		@SuppressWarnings("resource")
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Could not load test cases from file=" + testCaseFileName);
			System.exit(0);
		}
		
		while(fileReader.hasNextLine()) {
			
			String line = fileReader.nextLine();
			if(line.charAt(0)=='/') {
				continue;
			}
			
			String name = line.substring(1);
			Order order = null;
			List<Warehouse> warehouses = null;
			List<Map<String, Map<String, Integer>>> output = new LinkedList<Map<String, Map<String, Integer>>>();
			
			System.out.println("Loading Test : " + name);
			
			while(line.charAt(0) != '$') {
				
				line = fileReader.nextLine();
				char firstChar = line.charAt(0);
				switch(firstChar) {
				
				case 'O': String[] items = line.split(":");
						Map<String,Integer> orderedItems = new HashMap<String, Integer>();
						for(int i=1; i<items.length; i++) {
							String[] entry = items[i].split("=");
							String itemName = entry[0];
							int itemValue = Integer.parseInt(entry[1]);
							orderedItems.put(itemName, itemValue);
						}
						order = new Order(orderedItems);
						break;
						
				case 'W': if(warehouses == null) {
							warehouses = new LinkedList<Warehouse>();
						}
						String[] warehouseDetails = line.split(":");
						if(warehouseDetails.length > 1) {
							Map<String,Integer> inventory = new HashMap<String, Integer>();
							String warehouseName = warehouseDetails[1];
							for(int i=2; i<warehouseDetails.length; i++) {
								String[] entry = warehouseDetails[i].split("=");
								String itemName = entry[0];
								int itemValue = Integer.parseInt(entry[1]);
								inventory.put(itemName, itemValue);
							}
							Warehouse warehouse = new Warehouse(warehouseName, inventory);
							warehouses.add(warehouse);
						}
						break;
				
				case 'R': String[] resultDetails = line.split(":");
						if(resultDetails.length == 1) {
							break;
						}
						String warehouseName1 = resultDetails[1];
						Map<String, Map<String, Integer>> shipment = new HashMap<String, Map<String, Integer>>();
						Map<String, Integer> itemsSupplied = new HashMap<String, Integer>();
						for(int i=2; i<resultDetails.length; i++) {
							String[] entry = resultDetails[i].split("=");
							String itemName = entry[0];
							int itemValue = Integer.parseInt(entry[1]);
							itemsSupplied.put(itemName, itemValue);
						}
						shipment.put(warehouseName1, itemsSupplied);
						output.add(shipment);
				
				}
				
			}
			
			InventoryAllocatorTestCase testCase = new InventoryAllocatorTestCase(name, order, warehouses, output);
			testCases.put(name, testCase);
			
		}
		
	}

}
