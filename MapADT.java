// --== CS400 File Header Information ==--
// Name: Sharath Palthepu
// Email: palthepu@wisc.edu
// Team: Project: LA
// TA: Divyanshu
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {
  public boolean put(KeyType key, ValueType value);
  public ValueType get(KeyType key) throws NoSuchElementException;
  public int size();
  public boolean containsKey(KeyType key);
  public ValueType remove(KeyType key);
  public void clear();
}