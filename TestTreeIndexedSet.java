

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestTreeIndexedSet.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestTreeIndexedSet
{
    /**
     * Default constructor for test class TestTreeIndexedSet
     */
    public TestTreeIndexedSet()
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
    @Test
    public void TestInsertNC1() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(2);
        
        boolean theAns = RBT.add(2);
        
        assertFalse(theAns);
    }
    /**
     * Test the normal boundary condition for insert method
     */
    @Test
    public void TestInsertNC2() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(3);
        RBT.add(4);
        
        boolean theAns = RBT.add(5);
        
        assertTrue(theAns);
    }
    /**
     * Test the boundary condition for insert method
     */
    @Test
    public void TestInsertBC1() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        
        boolean theAns = RBT.add(19);
        
        assertTrue(theAns);
    }
    /**
     * Test the boundary condition for insert method
     */
    @Test
    public void TestInsertBC2() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(3);
        RBT.add(17);
        RBT.add(18);
        
        boolean theAns = RBT.add(3);
        
        assertFalse(theAns);
    }
    /**
     * Test the invalid boundary condition for insert method
     */
    public void TestInsertIBC() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(3);
        RBT.add(17);
        RBT.add(18);
        
        //boolean theAns = c.insert("C");
        
        //assertFalse(theAns);
    }
    /**
     * Tests the normal boundary condition for the size of the node
     */
    @Test
    public void TestSizeNC1() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(8);
        RBT.add(9);
        RBT.add(7);
        RBT.add(10);
        RBT.add(11);
        
        int theAns = RBT.size();
        int trueAns = 5;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the normal boundary condition for the size of the node
     */
    @Test
    public void TestSizeNC2() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(8);
        RBT.add(9);
        RBT.add(7);
        RBT.add(10);
        RBT.add(11);
        
        int theAns = RBT.size();
        int trueAns = 5;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the size of the node
     */
    @Test
    public void TestSizeBC1() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(8);
        
        int theAns = RBT.size();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the size of the node
     */
    @Test
    public void TestSizeBC2() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        
        int theAns = RBT.size();
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the invalid boundary condition for the size of the node
     */
    public void TestSizeIBC() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        
        //int theAns = RBT.getSize(header);
        int trueAns = 0;
        
        //assertEquals(theAns, trueAns);
    }
    /**
     * Tests the normal boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthNC1() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(8);
        RBT.add(9);
        RBT.add(7);
        RBT.add(10);
        RBT.add(11);
        
        int theAns = RBT.getKth(3);
        int trueAns = 9;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the normal boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthNC2() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(13);
        RBT.add(8);
        RBT.add(1);
        RBT.add(17);
        RBT.add(11);
        RBT.add(15);
        
        int theAns = RBT.getKth(5);
        int trueAns = 15;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthBC1() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(13);
        RBT.add(8);
        RBT.add(1);
        RBT.add(17);
        RBT.add(11);
        RBT.add(15);
        RBT.add(25);
        
        int theAns = RBT.getKth(7);
        int trueAns = 25;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Tests the boundary condition for the getKth() method
     */
    @Test
    public void TestFindKthBC2() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(13);
        RBT.add(8);
        RBT.add(1);
        RBT.add(17);
        RBT.add(11);
        RBT.add(15);
        
        int theAns = RBT.getKth(1);
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the getKth() method
     */
    public void TestFindKthIBC() {
        TreeIndexedSet<Integer> RBT = new TreeIndexedSet<Integer>();
        RBT.add(13);
        RBT.add(8);
        RBT.add(1);
        RBT.add(17);
        RBT.add(11);
        RBT.add(15);
        
        //-1 is out of bounds
        int theAns = RBT.getKth(-1);
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
