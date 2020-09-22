// --== CS400 File Header Information ==--
// Name: Sharath Palthepu
// Email: palthepu@wisc.edu
// Team: Project: LA
// TA: Divyanshu
// Lecturer: Gary Dahl
// Notes to Grader: N/A

/**
 * This class acts similar to a LinkedList class and uses two generic type parameters
 * 
 * @author sharath
 *
 * @param <KeyType> the key for the pair
 * @param <ValueType> the value that is associated with a key in the pair
 */
public class Pairs<KeyType, ValueType> {
  private KeyType key; // instance variable for the key
  private ValueType val; // instance variable for the value
  private Pairs<KeyType, ValueType> next; // instance variable for the next pair
  private Pairs<KeyType, ValueType> prev; // instance variable for the previous pair

  /**
   * A constructor for the Pairs object that takes in two parameters
   * 
   * @param key - the key for the pair
   * @param val - the value associated with the key
   */
  public Pairs(KeyType key, ValueType val) {
    this.key = key;
    this.val = val;
    this.prev = null;
    this.next = null;
  }

  /**
   * Accessor method for the previous pair
   * 
   * @return the previous pair instance variable
   */
  public Pairs<KeyType, ValueType> getPrev() {
    return this.prev;
  }

  /**
   * Accessor method for the next pair
   * 
   * @return the next pair instance variable
   */
  public Pairs<KeyType, ValueType> getNext() {
    return this.next;
  }

  /**
   * Accessor method for the key of a pair
   * 
   * @return the instance variable for the key of a pair
   */
  public KeyType getKey() {
    return this.key;
  }

  /**
   * Accessor method for the value of a pair
   * 
   * @return the instance variable for the value of a pair
   */
  public ValueType getValue() {
    return this.val;
  }

  /**
   * Mutator method for the previous pair that updates the variable
   * 
   * @param prev - the previous pair variable
   */
  public void setPrev(Pairs<KeyType, ValueType> prev) {
    this.prev = prev;
  }

  /**
   * Mutator method for the next pair that updates the variable
   * 
   * @param next - the next pair variable
   */
  public void setNext(Pairs<KeyType, ValueType> next) {
    this.next = next;
  }

  /**
   * Mutator method for the key of a pair that updates the variable
   * 
   * @param key - the key variable of a pair
   */
  public void setKey(KeyType key) {
    this.key = key;
  }

  /**
   * Mutator method for the value of a pair that updates the variable
   * 
   * @param val - the value variable of a pair
   */
  public void setValue(ValueType val) {
    this.val = val;
  }
}
