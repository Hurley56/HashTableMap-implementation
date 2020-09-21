import java.util.NoSuchElementException;

// --== CS400 File Header Information ==--
// Name: Sharath Palthepu
// Email: palthepu@wisc.edu
// Team: Project: LA
// TA: Divyanshu
// Lecturer: Gary Dahl
// Notes to Grader: N/A

/**
 * Test class for the HashTableMap.java class
 * 
 * @author sharath
 */
public class TestHashTable {
  
  /**
   * Test class for the put and get methods.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean test1() {
    // create new HashTableMap object with integer type for the key and value
    HashTableMap<Integer, Integer> table1 = new HashTableMap<Integer, Integer>(5);
    
    // add key-value pairs to the hashtable
    table1.put(3, 12);
    table1.put(4,  12);
    table1.put(10, 6);
    
    // check to see if the put method worked by calling get with each key
    if(table1.get(3) != 12){
      return false;
    }
    if(table1.get(4) != 12) {
      return false;
    }
    if(table1.get(10) != 6) {
      return false;
    }
    
    // check to see that if the key doesn't exist the exception is thrown
    try {
      if(table1.get(6) != null) {
        return false;
      }
    } catch(NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    return true;
  }
  
  /**
   * Test class for the clear method.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean test2() {
    // create new HashTableMap object with integer type for the key and value
    HashTableMap<Integer, Integer> table1 = new HashTableMap<Integer, Integer>(5);
    
    // add key-value pairs to the hashtable
    table1.put(5, 7);
    table1.put(1, 25);
    table1.put(8, 19);
    table1.clear(); // clear the hashtable of all key-value pairs
    
    // check to see that there are no pairs in the hashtable
    if(table1.size() != 0) {
      return false;
    }
    return true;
  }
  
  /**
   * Test class for the containsKey method.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean test3() {
    // create new HashTableMap object with integer type for the key and value
    HashTableMap<Integer, Integer> table1 = new HashTableMap<Integer, Integer>(5);
    
    // add key-value pairs to the hashtable
    table1.put(3, 5);
    table1.put(10, 9);
    table1.put(2, 15);
    
    // check to see if the hashtable contains a pair using the key
    if(!table1.containsKey(3)) {
      return false;
    }
    return true; 
  }
  
  /**
   * Test class for the remove method.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean test4() {
    // create new HashTableMap object with integer type for the key and value
    HashTableMap<Integer, Integer> table1 = new HashTableMap<Integer, Integer>(5);
    
    // add key-value pairs to the hashtable
    table1.put(10, 5);
    table1.put(25, 4);
    table1.put(6, 16);
    
    // remove the pair with the key 10
    table1.remove(10);
    if(table1.containsKey(10)) {
      return false;
    }
    return true; 
  }
  
  /**
   * Test class for the size method.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean test5() {
    // create new HashTableMap object with integer type for the key and value
    HashTableMap<Integer, Integer> table1 = new HashTableMap<Integer, Integer>(5);
    
    // add key-value pairs to the hashtable
    table1.put(2, 3);
    table1.put(30, 5);
    table1.put(4, 10);
    table1.put(9, 55);
    
    // check to see if the size of the hashtable is 4
    if(table1.size() != 4) {
      return false;
    }
    return true;
  }
  
  /**
   * Main method that prints out the result of each test method.
   * 
   * @param args an array of command-line arguments for the application
   */
  public static void main(String args[]) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
  }
}
