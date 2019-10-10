import java.util.*;
/**
 * This class creates and modifies the sorted ArrayList
 * @Richard Phan
 * @April 22, 2019
 */
public class List<E extends Comparable<? super E>> {
    //The ArrayList that will be sorted and used
    private ArrayList<E> arr;
    //Keeps track of the size of the ArrayList
    private int size;
    /**
     * Constructor for objects of type List
     */
    public List() {
        //Initializes the instance variables
        arr = new ArrayList<E>();
        size = 0;
    }
    /**
     * Inserts a given element into the ArrayList and returns whether
     * successful
     * @param e The element that will be inserted
     * @return Whether the insertion has succeeded or failed
     */
    public boolean insert(E e) {
        //Uses the binary search in the collections framework
        //c stores the index of the found element or the index of where the
        //element would've been if the element was in the ArrayList
        int c = Collections.binarySearch(arr, e);
        //If there's nothing in the ArrayList...
        if(arr.size() == 0) {
            //Just add the element into the ArrayList
            arr.add(e);
            //Increase size
            size++;
            //Insertion was successful
            return true;
            //If c is negative, that means the element is not in the ArrayList
        } else if(c < 0) {
            //Add the element e at the calculated location
            arr.add(-1*(c + 1), e);
            //Increase size
            size++;
            //Insertion successful
            return true;
        }
        //If neither of the above two cases occurred, that means insertion
        //failed
        return false;
    }
    /**
     * Returns the size of the ArrayList
     * @Return Returns the size of the ArrayList
     */
    public int size() {
        return size;
    }
    /**
     * Finds the kth smallest element
     * @param k Determines the element that is desired
     * @Return Returns the kth smallest element
     */
    public E findKth(int k) {
        //If k is larger than the ArrayList or is less than 0, there will not
        //be any element in those locations
        if(k > arr.size() || k <= 0) {
            //Return null
            return null;
        }
        //Since the ArrayList is sorted, the kth smallest element is at the 
        //k-1 index
        return arr.get(k - 1);
    }
}
