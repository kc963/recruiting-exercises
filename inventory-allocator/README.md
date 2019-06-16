

### Problem

The problem is compute the best way an order can be shipped (called shipments) given inventory across a set of warehouses (called inventory distribution). 

Your task is to implement InventoryAllocator class to produce the cheapest shipment.

The first input will be an order: a map of items that are being ordered and how many of them are ordered. For example an order of apples, bananas and oranges of 5 units each will be 

`{ apple: 5, banana: 5, orange: 5 }`

The second input will be a list of object with warehouse name and inventory amounts (inventory distribution) for these items. For example the inventory across two warehouses called owd and dm for apples, bananas and oranges could look like

`[ 
    {
    	name: owd,
    	inventory: { apple: 5, orange: 10 }
    }, 
    {
    	name: dm:,
    	inventory: { banana: 5, orange: 10 } 
    }
]`

You can assume that the list of warehouses is pre-sorted based on cost. The first warehouse will be less expensive to ship from than the second warehouse. 

You can use any language of your choice to write the solution (internally we use Typescript/Javascript, Python, and some Java). Please write unit tests with your code, a few are mentioned below, but these are not comprehensive. Fork the repository and put your solution inside of the src directory and include a way to run your tests!

### Examples

*Happy Case, exact inventory match!**

Input: `{ apple: 1 }, [{ name: owd, inventory: { apple: 1 } }]`  
Output: `[{ owd: { apple: 1 } }]`

*Not enough inventory -> no allocations!*

Input: `{ apple: 1 }, [{ name: owd, inventory: { apple: 0 } }]`  
Output: `[]`

*Should split an item across warehouses if that is the only way to completely ship an item:*

Input: `{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]`  
Output: `[{ dm: { apple: 5 }}, { owd: { apple: 5 } }]`

### What are we looking for

We'll evaluate your code via the following guidelines in no particular order:

1. **Readability**: naming, spacing, consistency
2. **Correctness**: is the solution correct and does it solve the problem
1. **Test Code Quality**: Is the test code comperehensive and covering all cases.
1. **Tool/Language mastery**: is the code using up to date syntax and techniques. 

### Solution Instructions

The solution contains 4 classes:
1. **Order**: represents the input order entity.
2. **Warehouse**: represents the warehouse entity which has a name and an inventory.
3. **InventoryAllocator**: contains the getCheapestShipment method along with other helper methods.
4. **InventoryManager**: a dummy class to show the usage of InventoryAllocator class.
These classes are present in the src/main/java directory.

The solution also performs unit testing on the InventoryAllocator class. The code for testing is present in the src/test/java directory. This directory contains 3 files.
1. **InventoryAllocatorInput**: represents a datatype that houses the input (order and list of warehouses) which is provided to the getCheapestShipment method of the InventoryAllocator class.
2. **InventoryAllocatorTestCase**: represents a testcase which has a name along with the input and corresponding output for that input. This testcase is used to test the getCheapestShipment method of the InventoryAllocator class.
3. **InventoryAllocatorTest**: the main testing class which contains the different testcases to test the getCheapestShipment method of the InventoryAllocator class.

The testing class also uses a text file which contains all the testcases in a sequence. This file is present in the sec/test/resources directory with name 'TestCaseFile.txt'. The InventoryAllocatorTest class contains a loadTestCases method which access this file and generates all the testcases.


#### Development Environment Configuration
1. Java version: 9.0.4
2. Apache Maven version: 3.5.4

#### Dependencies (Handled by Maven)
1. JUnit5-jupiter

### Execution Instructions

Once you have maven installed in your system, open command window on the inventory-allocator directory (which contains the pom.xml file) and proceed with the commands written below.

**Build the project and install dependencies**: `mvn clean install`

**Run the tests**: `mvn test`
This command runs all the tests present in the InventoryAllocatorTest class.

**Run the main class**: `mvn exec:java -Dexec.mainClass="InventoryManager"`
This command runs the main class which is 'InventoryManager'. The main class contains a dummy order and list of warehouses and it provides them as the input to the getCheapestShipment method of the InventoryAllocator class and displays the results on console.



