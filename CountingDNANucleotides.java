/* A string is simply an ordered collection of symbols selected from some alphabet 
 * and formed into a word; the length of a string is the number of symbols that it contains.
 * 
 * An example of a length 21 DNA string (whose alphabet contains the symbols 'A', 'C', 'G', and 'T') is "ATGCTTCAGAAAGGTCTTACG."
 * 
 * Given: A DNA string s of length at most 1000 nt.
 * Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s.
 * 
 * https://rosalind.info/problems/dna/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class CountingDNANucleotides {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_dna.txt"));
		String dna = file.next();
		
		int[] array = new int[4];
		
		/* loop through each char in the DNA string and 
		 * increment the corresponding element of the array
		 */
		for (int i = 0; i < dna.length(); i++) {
			if (dna.charAt(i) == 'A') {
				array[0]++;
			} else if (dna.charAt(i) == 'C') {
				array[1]++;
			} else if (dna.charAt(i) == 'G') {
				array[2]++;
			} else {
				array[3]++;
			}
		}
			
		for (int n : array) {
			System.out.print(n + " ");
		}
	}
}