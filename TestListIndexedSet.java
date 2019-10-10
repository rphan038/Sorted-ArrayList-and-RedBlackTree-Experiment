

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestIndexedSet.
 *
 * @author  Richard Phan
 * @version April 22, 2019
 */
public class TestListIndexedSet
{
    /**
     * Default constructor for test class TestIndexedSet
     */
    public TestListIndexedSet()
    {
    }
    /**
     * Test the normal boundary condition for insert method
     */
    @Test
    public void TestInsertNC1() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(2);
        
        boolean theAns = c.add(2);
        
        assertFalse(theAns);
    }
    /**
     * Test the normal boundary condition for insert method
     */
    @Test
    public void TestInsertNC2() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(3);
        c.add(4);
        
        boolean theAns = c.add(5);
        
        assertTrue(theAns);
    }
    /**
     * Test the boundary condition for insert method
     */
    @Test
    public void TestInsertBC1() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        
        boolean theAns = c.add(19);
        
        assertTrue(theAns);
    }
    /**
     * Test the boundary condition for insert method
     */
    @Test
    public void TestInsertBC2() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(3);
        c.add(17);
        c.add(18);
        
        boolean theAns = c.add(3);
        
        assertFalse(theAns);
    }
    /**
     * Test the invalid boundary condition for insert method
     */
    public void TestInsertIBC() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(3);
        c.add(17);
        c.add(18);
        
        //boolean theAns = c.insert("C");
        
        //assertFalse(theAns);
    }
    /**
     * Test the normal boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeNC1() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        
        int theAns = c.size();
        int trueAns = 4;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the normal boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeNC2() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(100);
        c.add(90);
        
        int theAns = c.size();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeBC1() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(25);
        
        int theAns = c.size();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeBC2() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        
        int theAns = c.size();
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the invalid boundary condition for size of the ArrayList
     */
    public void TestSizeIBC() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        //c.insert("H");
        
        int theAns = c.size();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the normal boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthNC1() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        
        int theAns = c.getKth(3);
        int trueAns = 3;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the normal boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthNC2() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(100);
        c.add(90);
        c.add(80);
        c.add(70);
        
        int theAns = c.getKth(2);
        int trueAns = 80;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthBC1() {
        ListIndexedSet<Integer> LIS = new ListIndexedSet();
        LIS.add(100);
        LIS.add(90);
        LIS.add(80);
        LIS.add(70);
        
        int theAns = LIS.getKth(1);
        int trueAns = 70;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthBC2() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(100);
        c.add(90);
        c.add(80);
        c.add(70);
        
        int theAns = c.getKth(4);
        int trueAns = 100;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the invalid boundary condition for size of the getKth()
     */
    public void TestFindKthIBC() {
        ListIndexedSet<Integer> c = new ListIndexedSet<Integer>();
        c.add(100);
        c.add(90);
        c.add(80);
        c.add(70);
        
        //This is out of bounds
        int theAns = c.getKth(-1);
        int trueAns = 100;
        
        assertEquals(theAns, trueAns);
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
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
