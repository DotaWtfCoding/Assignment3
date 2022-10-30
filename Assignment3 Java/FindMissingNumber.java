/*
 * FindingMissingNumber.java
 *
 * Version:
 *     17.0.3
 *
 * Revisions:
 *     2
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class that represents the methods to find the missing number from a given set of numbers having same bit size game.
 *
 * @author      Vishal Panchidi
 * @author      Neeraj Bandi
 */


public class FindMissingNumber {
    /**
     *  Find the missing number in a given array string.
     * @param : Array of all the numbers from the file mentioned in stdin
     */

    public static long getMissingNumber(String[] allNumbers) {
        long storingXorOperation = 0;

        for (String element : allNumbers) {
            //using Bitwise XOR operation storing all numbers in the given file.
            //parse to convert it into the long datatype.
            storingXorOperation = storingXorOperation ^ Long.parseLong(element);
        }

        for (long index = 1; index <= allNumbers.length + 1; index++) {
            //Using Bitwise XOR operation storing all the numbers till the given array length
            //XOR operations cancels all the values that are present in the array and contains the missing number.
            storingXorOperation = storingXorOperation ^ index;
        }
        //returns the missing number
        return storingXorOperation;
    }

    /**
     * using a scanner function to read the file and adding each element and then storing in a string array.
     * Using main method calling missing number.
     *
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException {
        String tempNumber= "";
        Scanner sc;
        //Reading filename to get all the numbers from the file
        sc = new Scanner(new BufferedReader(new FileReader(args[3])));

        for(long i=0;sc.hasNextLine();i++){
            tempNumber += sc.nextLine() + " ";
        }
        //Removing the extra added space at the end of the string.
        tempNumber = tempNumber.substring(0, tempNumber.length()-1);
        String[] allNumbers= tempNumber.split(" ");
        System.out.println("The missing number is " + getMissingNumber(allNumbers));
    }

}




