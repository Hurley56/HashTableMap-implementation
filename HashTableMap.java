// --== CS400 File Header Information ==--
// Name: Sharath Palthepu
// Email: palthepu@wisc.edu
// Team: Project: LA
// TA: Divyanshu
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class implements a hashtable with two generic type values
 * 
 * @author sharath
 *
 * @param <KeyType> the key for the pair
 * @param <ValueType> the value that is associated with the key in the pair
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private Pairs<KeyType, ValueType>[] hashtable; // instance variable for the array of Pairs
  private int capacity; // instance variable for the capacity of the hashtable
  private int size; // instance variable for the size of the hashtable

  /**
   * This constructor creates a new HashTableMap object with a capacity parameter
   * 
   * @param capacity - the capacity of the hashtable
   */
  @SuppressWarnings("unchecked")
  public HashTableMap(int capacity) {
    this.capacity = capacity;
    this.hashtable = new Pairs[capacity];
  }

  /**
   * This constructor creates a new HashTableMap object but uses the default capacity
   */
  @SuppressWarnings("unchecked")
  public HashTableMap() { // with default capacity = 10
    this.capacity = 10;
    this.hashtable = new Pairs[10];
  }

  /**
   * This method adds a key-value pair to the array of pairs
   * 
   * @param key   - the key of the pair
   * @param value - the value associated with the key
   * @return true if a pair is added to the array and false if nothing is added
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    Pairs<KeyType, ValueType> currentPair = new Pairs<KeyType, ValueType>(key, value);

    // check to see if the pair is already in the array, if it is then return false
    if (containsKey(key)) {
      return false;
    }

    // calculate the index at which to add the pair
    int index = Math.abs(key.hashCode() % capacity);

    // if there is no pair at the index, then add the pair and increment the size, then return true
    if (hashtable[index] == null) {
      hashtable[index] = currentPair;
      size++;
      return true;
    } else {
      Pairs<KeyType, ValueType> newpair = hashtable[index]; // create a variable of the pair at the
                                                            // index
      while (newpair.getNext() != null) {
        newpair = newpair.getNext(); // set the pair equal to the next pair if it is not null
      }
      newpair.setNext(currentPair);
      size++; // increment the size
    }

    // if the load factor is greater than or equal to 0.8, then call the private helper method
    // doubling()
    if ((double) size / (double) capacity >= 0.8) {
      doubling();
    }
    return true;
  }

  /**
   * This method gets the value of the key-value pair using the key
   * 
   * @param key   - the key of the pair
   * @param value - the value associated with the key
   * @return the value of the key-value pair
   * @throws NoSuchElementException - when you use a key that does not exist in the array of
   *                                key-value pairs
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    for (int i = 0; i < hashtable.length; i++) { // loop through the hashtable
      if (hashtable[i] != null) {
        Pairs<KeyType, ValueType> currentPair = hashtable[i]; // set pair at that index to the
                                                              // currentPair if it is not null
        while (currentPair != null) {
          if (currentPair.getKey().equals(key)) { // if the key of currentPair matches the parameter
                                                  // then return the value with the key
            return currentPair.getValue();
          }
          currentPair = currentPair.getNext(); // set the currentPair to the next pair in the array
        }
      }
    }
    // throw the exception if there are pairs with the key
    throw new NoSuchElementException("There does not exist key-value pair for that key.");
  }

  /**
   * This method returns the size of the hashtable
   * 
   * @returns the size of the hashtable
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * This method checks if the array has a pair with the given key parameter
   * 
   * @param key - the key of the pair
   * @return true if a pair with the key exists in the array and false if it doesn't
   */
  @Override
  public boolean containsKey(KeyType key) {
    for (int i = 0; i < hashtable.length; i++) { // loop through the the hashtable
      if (hashtable[i] != null) {
        Pairs<KeyType, ValueType> currentPair = hashtable[i]; // set pair at that index to the
                                                              // currentPair if it is not null
        while (currentPair != null) {
          if (currentPair.getKey().equals(key)) { // if the key of the currentPair matches the
                                                  // parameter key, then return true
            return true;
          }
          currentPair = currentPair.getNext(); // set the currentPair to the next pair in the array
        }
      }
    }
    return false;
  }

  /**
   * This method removes a key-value pair from the array
   * 
   * @param key - the key of the pair
   * @return the value of the key-value pair that is removed and null if nothing is removed
   */
  @Override
  public ValueType remove(KeyType key) {
    for (int i = 0; i < hashtable.length; i++) { // loop through the hashtable
      Pairs<KeyType, ValueType> prevPair = null; // create a Pair variable and set to null to use to
                                                 // search for the key
      if (hashtable[i] != null) {
        Pairs<KeyType, ValueType> currentPair = hashtable[i]; // set pair at that index to the
                                                              // currentPair if it is not null
        while (currentPair != null) {
          if (currentPair.getKey().equals(key)) { // if the key of the currentPair matches the
                                                  // parameter key, then decrement size and return
                                                  // the currentPair value
            size--;
            if (prevPair != null) {
              prevPair.setNext(currentPair.getNext()); // if prevPair is not null then set the next
                                                       // pair to currentPairs next pair
            } else {
              hashtable[i] = currentPair.getNext(); // if prevPair is null, then remove the
                                                    // currentPair but setting the index to
                                                    // currentPairs next pair
            }
            return currentPair.getValue();
          }
          prevPair = currentPair; // update prevPair if currentPair's key is not the parameters key
          currentPair = currentPair.getNext(); // set the currentPair to the next pair to continue
                                               // the loop
        }
      }
    }
    return null;
  }

  /**
   * This method clears the array by removing all the pairs that exist in the array
   */
  @Override
  public void clear() {
    for (int i = 0; i < hashtable.length; i++) {
      while (hashtable[i] != null) {
        hashtable[i] = null;
        size--; // decrement size everytime a pair is removed
      }
    }
  }

  /**
   * This private helper method updates the hashtable array by doubling its capacity
   */
  private void doubling() {
    this.capacity = capacity * 2; // double the capacity
    hashtable = Arrays.copyOf(duplicate(), capacity); // use copyOf in order to copy the contents
                                                      // from the array from duplicate()
  }

  /**
   * This private helper method creates a new array that is a copy of the hashtable array
   * 
   * @return
   */
  private Pairs<KeyType, ValueType>[] duplicate() {
    Pairs<KeyType, ValueType> copy[] = hashtable.clone(); // use .clone() to copy the hashtable
                                                          // array
    return copy;
  }
}
