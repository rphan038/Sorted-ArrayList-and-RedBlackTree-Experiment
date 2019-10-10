// RedBlackTree class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print all items
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted and remove.

/**
 * Implements a red-black tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss edited by Richard Phan
 */
public class RedBlackTree<AnyType extends Comparable<? super AnyType>> {
    private RedBlackNode<AnyType> header; //Not the root, It's right child is root
    private RedBlackNode<AnyType> nullNode;

    //Final means that the value cannot change
    private static final int BLACK = 1;    // BLACK must be 1
    private static final int RED   = 0;

    // Used in insert routine and its helpers
    private RedBlackNode<AnyType> current;
    private RedBlackNode<AnyType> parent;
    private RedBlackNode<AnyType> grand;
    private RedBlackNode<AnyType> great;
    /**
     * Construct the tree.
     */
    public RedBlackTree( )
    {
        nullNode = new RedBlackNode<AnyType>( null ); //Sentinel node
        //All null pointers at the bottom of the red black tree point to this nullNode
        nullNode.left = nullNode.right = nullNode;
        header      = new RedBlackNode<AnyType>( null );
        header.left = header.right = nullNode;
    }
    /**
     * Returns the root of the Red Black Tree
     * @Return Returns the Root
     */
    public RedBlackNode<AnyType> getRoot() {
        return header.right;
    }
    /**
     * Finds the size of the node
     * @param r The node in question
     * @Return Returns the size of the node
     */
    public int getSize(RedBlackNode<AnyType> r) {
        return r.size;
    }
    /**
     * Returns the left child of the root
     * @Return The left child of the root
     */
    public RedBlackNode<AnyType> getLeftOfRoot() {
        return header.right.left;
    }
    /**
     * Returns the right child of the root
     * @Return The right child of the root
     */
    public RedBlackNode<AnyType> getRightOfRoot() {
        return header.right.right;
    }

    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare( AnyType item, RedBlackNode<AnyType> t )
    {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );    
    }
    
    /**
     * Insert into the tree.
     * @param item the item to insert.
     * @throws DuplicateItemException if item is already present.
     */
    public boolean insert( AnyType item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        //While loop makes sure that item != current.element
        while( compare( item, current ) != 0 )
        {
            //switches labels of the nodes in question
            great = grand; grand = parent; parent = current;
            current = compare( item, current ) < 0 ?
                         current.left : current.right;

                // Check if two red children; fix if so
            //Color flips and rotates accordingly if there are two reds in a row
            if( current.left.color == RED && current.right.color == RED )
                 handleReorient( item );
        }

        // Insertion fails if already present
        //If current is not null
        if( current != nullNode )
            return false;
        //Item is the new element of current and it has null children
        current = new RedBlackNode<AnyType>( item, nullNode, nullNode );

            // Attach to appropriate parent
        if( compare( item, parent ) < 0 ) {
            parent.left = current;
        } else {
            parent.right = current;
        }
        //Start from the root
        RedBlackNode<AnyType> t = null;
        t = header.right;
        //Traverses the tree looking for the node current
        while(t != current) {
            //Increases the size of each node it reaches
            t.size++;
            //Go left if item is less than the node in question
            if(item.compareTo(t.element) < 0 && t.left != null) {
                t = t.left;
                //Go right if item is greater than the node in question
            } else if (item.compareTo(t.element) > 0 && t.right != null) {
                t = t.right;
            }
        }
        //The node current also needs to increase its size
        current.size++;
        handleReorient( item );
        return true;
    }

    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @throws UnsupportedOperationException if called.
     */
    public void remove( AnyType x )
    {
        throw new UnsupportedOperationException( );
    }

    /**
     * Find the smallest item  the tree.
     * @return the smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            return null;

        RedBlackNode<AnyType> itr = header.right;

        while( itr.left != nullNode )
            itr = itr.left;

        return itr.element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            return null;

        RedBlackNode<AnyType> itr = header.right;

        while( itr.right != nullNode )
            itr = itr.right;

        return itr.element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public AnyType find( AnyType x )
    {
        nullNode.element = x;
        current = header.right; //header.right is the root

        for( ; ; )
        {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 ) 
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        header.right = nullNode;
    }

    /**
     * Print all items.
     */
    public void printTree( )
    {
        printTree( header.right );
    }
    
    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( RedBlackNode<AnyType> t )
    {
        if( t != nullNode )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
     
    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return header.right == nullNode;
    }

    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient( AnyType item )
    {
        // Do the color flip.   Original was black with two red children
        //Now red node with two black children
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        //If there are two reds that are adjacent...
        if( parent.color == RED )   // Have to rotate
        {
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) !=
                ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
                //Rotate passes in the node of the parent not the node in question
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }

    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNode<AnyType> rotate( AnyType item, RedBlackNode<AnyType> parent )
    {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                rotateWithLeftChild( parent.left )  :  // LL
                rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                rotateWithLeftChild( parent.right ) :  // RL
                rotateWithRightChild( parent.right );  // RR
    }

    /**
     * Rotate binary tree node with left child.
     */
    private static <AnyType> RedBlackNode<AnyType> rotateWithLeftChild( RedBlackNode<AnyType> k2 )
    {
        RedBlackNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        
        k1.size = k2.size;
        k2.size = k2.left.size + k2.right.size + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     */
    private static <AnyType> RedBlackNode<AnyType> rotateWithRightChild( RedBlackNode<AnyType> k1 )
    {
        RedBlackNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        
        k2.size = k1.size;
        k1.size = k1.left.size + k1.right.size + 1;
        return k2;
    }
    /**
     * Finds the kth smallest element in the Red Black Tree
     * @param k Determines the element that is desired
     * @Return Returns the kth smallest element
     */
    public AnyType findKth(int k) {
        //If the tree is empty throw an exception
        if(header == null)
            throw new IllegalArgumentException();
        // Return the kth Smallest element
        return findKth(k, header.right).element;
    }
    /**
     * This method is a helper of the above method
     * @param k The kth smallest element
     * @param t the Red Black node in question
     * @Return The kth smallest element
     */
    protected RedBlackNode<AnyType> findKth(int k , RedBlackNode<AnyType> t) {
        //t cannot be the nullNode
        if(t == nullNode)
            throw new IllegalArgumentException();
        //Finds the size of the left child otherwise if the left child is
        //equal to nullNode, the size is 0;
        int leftSize = (t.left != nullNode) ? (t.left.size) : 0;
        //If k is less than leftSize, go left
        if(k <= leftSize)
            return findKth(k, t.left);
        
        if(k == leftSize + 1)
            return t;
        //If it's not in the left side, go to hte right side
        return findKth(k - leftSize - 1, t.right);
    }

    private static class RedBlackNode<AnyType> {
        AnyType               element;    // The data in the node
        RedBlackNode<AnyType> left;       // Left child
        RedBlackNode<AnyType> right;      // Right child
        int                   color;      // Color
        int size;                         // How many nodes it has including itself
            // Constructors
        RedBlackNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        RedBlackNode( AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RedBlackTree.BLACK;
            
        }
    }
    
    // Test program
    public static void main( String [ ] args ) {
        RedBlackTree<Integer> t = new RedBlackTree<Integer>();
        System.out.println(t.insert(456789012));
        System.out.println(t.insert(234567890));
        System.out.println(t.findKth(2));
        System.out.println(t.insert(345678901));
        System.out.println(t.findKth(2));
    }
}