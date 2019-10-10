

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestRedBlackTree.
 *
 * @Richard Phan
 * @April 22, 2019
 */
public class TestRedBlackTree
{
    /**
     * Default constructor for test class TestRedBlackTree
     */
    public TestRedBlackTree()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    /**
     * Tests the normal boundary condition for the size of the node
     */
    @Test
    public void TestSizeNC1() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(8);
        RBT.insert(9);
        RBT.insert(7);
        RBT.insert(10);
        RBT.insert(11);
        
        int theAns = RBT.getSize(RBT.getLeftOfRoot());
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the normal boundary condition for the size of the node
     */
    @Test
    public void TestSizeNC2() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(8);
        RBT.insert(9);
        RBT.insert(7);
        RBT.insert(10);
        RBT.insert(11);
        
        int theAns = RBT.getSize(RBT.getRightOfRoot());
        int trueAns = 3;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the size of the node
     */
    @Test
    public void TestSizeBC1() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(8);
        
        int theAns = RBT.getSize(RBT.getRoot());
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the size of the node
     */
    @Test
    public void TestSizeBC2() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        
        int theAns = RBT.getSize(RBT.getRoot());
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the invalid boundary condition for the size of the node
     */
    public void TestSizeIBC() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        
        //int theAns = RBT.getSize(header);
        int trueAns = 0;
        
        //assertEquals(theAns, trueAns);
    }
    /**
     * Tests the normal boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthNC1() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(8);
        RBT.insert(9);
        RBT.insert(7);
        RBT.insert(10);
        RBT.insert(11);
        
        int theAns = RBT.findKth(3);
        int trueAns = 9;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the normal boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthNC2() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(13);
        RBT.insert(8);
        RBT.insert(1);
        RBT.insert(17);
        RBT.insert(11);
        RBT.insert(15);
        
        int theAns = RBT.findKth(5);
        int trueAns = 15;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthBC1() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(13);
        RBT.insert(8);
        RBT.insert(1);
        RBT.insert(17);
        RBT.insert(11);
        RBT.insert(15);
        RBT.insert(25);
        
        int theAns = RBT.findKth(7);
        int trueAns = 25;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthBC2() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(13);
        RBT.insert(8);
        RBT.insert(1);
        RBT.insert(17);
        RBT.insert(11);
        RBT.insert(15);
        
        int theAns = RBT.findKth(1);
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the getKth() method
     */
    public void TestFindKthIBC() {
        RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
        RBT.insert(13);
        RBT.insert(8);
        RBT.insert(1);
        RBT.insert(17);
        RBT.insert(11);
        RBT.insert(15);
        
        //-1 is out of bounds
        int theAns = RBT.findKth(-1);
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
