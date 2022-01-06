/* In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.
 * The reverse complement of a DNA string s is the string sc formed by reversing the symbols of s, 
 * then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").
 * 
 * Given: A DNA string s of length at most 1000 bp.
 * Return: The reverse complement s^c of s.
 *
 * https://rosalind.info/problems/revc/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class ComplementingAStrandOfDNA {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_revc.txt"));
		String dnaString = file.next();
		
		// building a data structure for the complement of each DNA symbol
		HashMap<Character, Character> complement = new HashMap<Character, Character>();
		complement.put('A', 'T');
		complement.put('T', 'A');
		complement.put('C', 'G');
		complement.put('G', 'C');

		String reverseComplement = "";
		
		/* begin the for-loop from the end of the given DNA string 
		 * and complement each symbol into the reverse complement DNA string.		 * 
		 */
		for (int i = dnaString.length() - 1; i >= 0; i--) {
			reverseComplement += complement.get(dnaString.charAt(i));
		}
		System.out.println(reverseComplement);
	}
}