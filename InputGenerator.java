import java.util.*;
import java.lang.Math;
import java.io.PrintWriter;
/**
 * This class generates a .txt file of a combination of a million add() or
 * getKth() methods given a ratio for each
 *
 * @Richard Phan
 * @April 22, 2019
 */
public class InputGenerator {
    //Stores the number of "add" and "getKth" in an ArrayList
    private ArrayList<String> arr;
    /**
     * Constructor for objects of class InputGenerator
     */
    public InputGenerator() {
        //Initializes the ArrayList
        arr = new ArrayList<String>();
    }
    /**
     * Main method that will create and instance of this class to generate an input file
     * @param args Command Line Argument input
     */
    public static void main(String[] args) {
        InputGenerator IG = new InputGenerator();
        IG.run(args);
        //First index is seed 1
        //Second index is seed 2
        //Third index is percentage of add() in decimal form
        //Fourth index is percentage of getKth() in decimal form
        //Fifth index is input size
    }
    
    /**
     * This method runs the actual input generator
     * @param c An array of Strings
     */
    public void run(String[] c) {
        //Calls the generate method
        generate(Integer.parseInt(c[0]), Integer.parseInt(c[1]), 
        Float.parseFloat(c[2]), Float.parseFloat(c[3]), Integer.parseInt(c[4]));
    }
    /**
     * Generates all of the random methods and numbers and prints to a file
     * @param seed A seed for an instance of the Random class
     * @param seed2 A seed for an instance of the Random class
     * @param pAdd A percentage of add() methods in decimal form
     * @param pGet A percentage of getKth() methods in deciaml form
     */
    public void generate(int seed, int seed2, float pAdd, float pGet, Integer input) {
        //Declares and initializes the two random variables
        Random rn = new Random(seed);
        Random rn2 = new Random(seed2);
        int s = 0;
        int b = 0;
        //Adds pAdd*1000000 number of add() methods
        for(int j = 0; j < pAdd*1000000; j++) {
            arr.add("add");
        }
        //Adds pGet*1000000 number of getKth() methods
        for(int k = 0; k < pGet*1000000; k++) {
            arr.add("getKth");
        }
        //Try block for the PrintWriter
        try{
            //Declares and initializes the PrintWriter variable and determines
            //the file name
            PrintWriter f = new PrintWriter("90A10G1K.txt");
            //First line will have "1000000" to tell that there's a million
            //elements
            f.println(input.toString());
            //This variable will help with making sure the getKth() method
            //stays in bounds
            int x = 1;
            //Goes through the entire ArrayList for a total of a million times
            for(int i = 0; i < input; i++) {
                //This variable stores a random index of the ArrayList
                int op = Math.abs(rn.nextInt(arr.size()));
                //The first method cannot be getKth() because it will result
                //in an error. This whil loop makes sure that the first 
                //operation is an add() method
                while(i == 0 && arr.get(op).equals("getKth")) {
                    op = Math.abs(rn.nextInt(arr.size()));
                }
                //If the element at op is "add", then
                if(arr.get(op).equals("add")) {
                    //Generate a random positive long element
                    Long num = Math.abs(rn2.nextLong());
                    //Print "add" and num in the next line of the file
                    f.println(arr.get(op) + " " + num.toString());
                    //Another element has been added
                    x++;
                    s++;
                    //If the element at op is "getKth", then
                } else if(arr.get(op).equals("getKth")) {
                    //Generate a random integer that is capped by how many
                    //add elements there have been previously
                    Integer num = Math.abs(rn2.nextInt(x));
                    //Can't be 0 so increase by one if so
                    if(num == 0) {
                        num++;
                    }
                    //Prints "getKth" and num in the next line of the file
                    f.println(arr.get(op) + " " + num.toString());
                    b++;
                }
                //Removes the element at op so that this index isn't used
                //again
                arr.remove(op);
            }
            //Close the PrintWriter to finish the creation of the file
            f.close();
        } catch(Exception e) {
        }
        System.out.println("Add " + s);
        System.out.println("Get " + b);
    }
}
