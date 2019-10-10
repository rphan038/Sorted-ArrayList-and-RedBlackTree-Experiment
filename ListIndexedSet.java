import java.util.ArrayList;
/**
 * This class implements the IndexdSet<E> interface and uses the List class
 * 
 * @Richard Phan
 * @April 22, 2019
 */
public class ListIndexedSet<E extends Comparable<E>> implements IndexedSet<E>{
    //An instance of the List class
    private List<E> list;
    /**
     * Constructor for objects of type ListIndexedSet
     */
    public ListIndexedSet() {
        //Initializes the List object
        list = new List<E>();
    }
    
    /**
     * Adds a Long element into the Sorted ArrayList
     * @param item Is a variable of type Long that is added to the Sorted List
     * @return c Returns if the addition of item was successful
     */
    public boolean add(E item) {
        //c will keep track of whether the operation has succeeded or not
        boolean c = false;
        //Inserts the item to the Sorted ArrayList and if the insertion was
        //successful, c is now true
        if(list.insert(item))
            c = true;
        //The operation failed if the addition could not be done
        return c;
    }
    /**
     * Returns the size of the list
     * @return the size of the list
     */
    public int size() {
        //List class has a data field and method to help with this operation
        return list.size();
    }
    /**
     * Finds the kth smallest element
     * @param k Is the integer that determines which smallest element to look
     * for
     * @return the kth smallest element
     */
    public E getKth(int k) {
        //List class has a method to find the kth smallest element
        return list.findKth(k);
    }
}
