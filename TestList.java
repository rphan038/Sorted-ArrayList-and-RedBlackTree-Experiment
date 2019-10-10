

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class TestList.
 *
 * @Richard Phan
 * @April 22, 2019
 */
public class TestList
{
    /**
     * Default constructor for test class TestList
     */
    public TestList()
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
     * Test the normal boundary condition for insert method
     */
    @Test
    public void TestInsertNC1() {
        List<Integer> c = new List<Integer>();
        c.insert(2);
        
        boolean theAns = c.insert(2);
        
        assertFalse(theAns);
    }
    /**
     * Test the normal boundary condition for insert method
     */
    @Test
    public void TestInsertNC2() {
        List<Integer> c = new List<Integer>();
        c.insert(3);
        c.insert(4);
        
        boolean theAns = c.insert(5);
        
        assertTrue(theAns);
    }
    /**
     * Test the boundary condition for insert method
     */
    @Test
    public void TestInsertBC1() {
        List<Integer> c = new List<Integer>();
        
        boolean theAns = c.insert(19);
        
        assertTrue(theAns);
    }
    /**
     * Test the boundary condition for insert method
     */
    @Test
    public void TestInsertBC2() {
        List<Integer> c = new List<Integer>();
        c.insert(3);
        c.insert(17);
        c.insert(18);
        
        boolean theAns = c.insert(3);
        
        assertFalse(theAns);
    }
    /**
     * Test the invalid boundary condition for insert method
     */
    public void TestInsertIBC() {
        List<Integer> c = new List<Integer>();
        c.insert(3);
        c.insert(17);
        c.insert(18);
        
        //boolean theAns = c.insert("C");
        
        //assertFalse(theAns);
    }
    /**
     * Test the normal boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeNC1() {
        List<Integer> c = new List<Integer>();
        c.insert(1);
        c.insert(2);
        c.insert(3);
        c.insert(4);
        
        int theAns = c.size();
        int trueAns = 4;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the normal boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeNC2() {
        List<Integer> c = new List<Integer>();
        c.insert(100);
        c.insert(90);
        
        int theAns = c.size();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeBC1() {
        List<Integer> c = new List<Integer>();
        c.insert(25);
        
        int theAns = c.size();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the ArrayList
     */
    @Test
    public void TestSizeBC2() {
        List<Integer> c = new List<Integer>();
        
        int theAns = c.size();
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the invalid boundary condition for size of the ArrayList
     */
    public void TestSizeIBC() {
        List<Integer> c = new List<Integer>();
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
        List<Integer> c = new List<Integer>();
        c.insert(1);
        c.insert(2);
        c.insert(3);
        c.insert(4);
        
        int theAns = c.findKth(3);
        int trueAns = 3;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the normal boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthNC2() {
        List<Integer> c = new List<Integer>();
        c.insert(100);
        c.insert(90);
        c.insert(80);
        c.insert(70);
        
        int theAns = c.findKth(2);
        int trueAns = 80;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthBC1() {
        List<Integer> c = new List<Integer>();
        c.insert(100);
        c.insert(90);
        c.insert(80);
        c.insert(70);
        
        int theAns = c.findKth(1);
        int trueAns = 70;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the boundary condition for size of the getKth()
     */
    @Test
    public void TestFindKthBC2() {
        List<Integer> c = new List<Integer>();
        c.insert(100);
        c.insert(90);
        c.insert(80);
        c.insert(70);
        
        int theAns = c.findKth(4);
        int trueAns = 100;
        
        assertEquals(theAns, trueAns);
    }
    /**
     * Test the invalid boundary condition for size of the getKth()
     */
    public void TestFindKthIBC() {
        List<Integer> c = new List<Integer>();
        c.insert(100);
        c.insert(90);
        c.insert(80);
        c.insert(70);
        
        //This is out of bounds
        int theAns = c.findKth(-1);
        int trueAns = 100;
        
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
