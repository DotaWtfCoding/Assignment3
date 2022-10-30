/*
 * StringIntegerArray.java
 *
 * Version:
 *     17.0.3
 *
 * Revisions:
 *     2
 */

import java.util.Arrays;

/**
 * Class that represents the String Comparsions.
 *
 * @author      Vishal Panchidi
 * @author      Neeraj Bandi
 */
public class StringIntegerArrays {
    /**
     * method identical returns boolean value by checking the strings references.
     * return boolean
     */

    public static boolean identical(String str1,String str2) {
        return str1==str2;
    }

    /**
     *
     * method equals returns boolean value by checking the strings characters.
     * return boolean
     */
    public static boolean Equals(String s1, String s2){
        return s1.equals(s2);
    }

    /**
     *
     * calls the function above and compare the strings.
     */
    public static void main(String[] args) {
         String aString = "",bString= "",cString= "",dString= "", eString= "", fString= "",gString= "", hString= "", iString= "";

        if (args.length == 1) {
            aString = "123425" + "25";
            bString = "12342525";
            cString = "5";
            dString = "25" + "2" + cString;
            eString = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
            fString = "A, B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
            gString = aString + (bString + cString) + dString;
            hString = "2525" + "+" + "2525";
            iString = "2525+2525";
        } else {
            aString = "12342" + new String("" + 5) + "25";
            bString = "12342525";
            cString = "5";
            dString = "" + "25" + "" + "2" + cString;
            eString = "b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
            fString = "B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
            gString = ((aString + bString) + "" + 5) + dString;
            hString = "2525" + "+" + "2525";
            iString = "25" + (2 + 5) + "+2525";
        }

        System.out.println("I. Determine if aString and bString are identical: " +identical(aString,bString));
        System.out.println("II. Determine if aString and dString are identical: " +identical(aString,dString));
        System.out.println("III. Determine if aString and bString are equal: " +Equals(aString,bString));
        System.out.println("IV. Determine if hString and iString are identical: " +identical(hString,iString));
        System.out.println("V. Determine if hString and iString are equal: " +Equals(hString,iString));
        System.out.println("VI. Determine if aString and dString are equal: " +Equals(aString,dString));
        System.out.println("VI. Determine if aString and dString are equal: " +Equals(aString,dString));
        System.out.println("VII. Extract from dString the string starting at " +
                "the number defined by the first digit in aString to defined by " +
                "the digit at the second in aString. You have to extract these " +
                "numbers,2 and 5 : " + dString.substring(0));
        System.out.println("VIII. Extract the character of eString, which is at the position of ’*’ on fString : "+ eString.charAt(fString.indexOf('*')));
        char[] j= bString.toCharArray();
        Arrays.sort(j);
        String newStr= new String(j);
        System.out.println("IX. Sort the digits in bString " + newStr);


    }

}
