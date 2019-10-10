/**
 * Interface for the two methods that will be tested and the size() method
 * @Richard Phan
 * @April 22, 2019
 */
public interface IndexedSet<E extends Comparable<E>> {
    //Adds an item to the data structure
    boolean add(E item);
    //Returns the size of the data structure at a particular location
    int size();
    //Finds the kth smallest element stored in the data structure and returns it
    E getKth(int k);
}
