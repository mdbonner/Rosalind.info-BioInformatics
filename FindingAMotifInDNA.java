/* Given two strings s and t, t is a substring of s if t is contained as a contiguous collection of symbols in s (as a result, t must be no longer than s).
 * 
 * The position of a symbol in a string is the total number of symbols found to its left, including itself 
 * (e.g., the positions of all occurrences of 'U' in "AUGCUUCAGAAAGGUCUUACG" are 2, 5, 6, 15, 17, and 18). 
 * The symbol at position i of s is denoted by s[i].
 * 
 * A substring of s can be represented as s[j:k], where j and k represent the starting and ending positions of the substring in s; 
 * for example, if s = "AUGCUUCAGAAAGGUCUUACG", then s[2:5] = "UGCU".
 * 
 * The location of a substring s[j:k] is its beginning position j; 
 * note that t will have multiple locations in s if it occurs more than once as a substring of s.
 * 
 * Given: Two DNA strings s and t (each of length at most 1 kbp).
 * Return: All locations of t as a substring of s.
 * 
 * https://rosalind.info/problems/subs/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class FindingAMotifInDNA {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_subs.txt"));
		String dnaString = file.next();
		String subString = file.next();

		// indexOf returns -1 if string does not contain substring
		int index = dnaString.indexOf(subString);
		
		if (dnaString.contains(subString)) {
			// loop through the DNA string to find each occurrence of the given substring.
			while (index >= 0) {  
				System.out.print(index + 1 + " ");
				index = dnaString.indexOf(subString, index + 1);
			}
		} else {
			System.out.println("DNA String does not contain the substring.");
		}
	}
}