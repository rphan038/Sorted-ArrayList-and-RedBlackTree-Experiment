/**
 * This class implements the IndexedSet interface and creates the Red Black
 * Tree
 * @Richard Phan
 * @April 22, 2019
 */
public class TreeIndexedSet<E extends Comparable<E>> implements IndexedSet<E>{
    //An instance of the Red Black Tree class
    private RedBlackTree<E> RBT;
    /**
     * Constructor for objects of type TreeIndexedSet
     */
    public TreeIndexedSet(){
        //Initializes the Red Black Tree
        RBT = new RedBlackTree<E>();
    }
    /**
     * Adds a Long element to the Red Black Tree
     * @param item The element that is trying to be inserted
     * @Return Whether the operation has succeeded or not
     */
    public boolean add(E item) {
        //c will keep track of whether the operation has succeeded or not
        boolean c = false;
        //Inserts the element into the Red Black Tree and if this has
        //succeeded, c is now true
        if(RBT.insert(item)) {
            c = true;
        }
        //Otherwise the operation has failed and returns false
        return c;
    }
    /**
     * Returns the size of the list
     * @return the size of the list
     */
    public int size() {
        //RedBlackTree class has a method to help find the size of a node
        return RBT.getSize(RBT.getRoot());
    }
    /**
     * Finds the kth smallest element
     * @param k Is the integer that determines which smallest element to look
     * for
     * @return the kth smallest element
     */
    public E getKth(int k) {
        //Red Black Tree class has a method to find the kth smallest element
        return RBT.findKth(k);
    }
}