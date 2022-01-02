/* An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
 * 
 * Given a DNA string t corresponding to a coding strand, its transcribed RNA string u is formed by replacing all occurrences of 'T' in t with 'U' in u.
 * 
 * Given: A DNA string t having length at most 1000 nt.
 * Return: The transcribed RNA string of t.
 * 
 * https://rosalind.info/problems/rna/
 */

package bioinformaticsStronghold;

import java.io.*;
import java.util.*;

public class TranscribingDNAIntoRNA {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_rna.txt"));
		String dna = file.next();
		String rna = dna.replace('T', 'U');
		
		System.out.println(rna);
	}
}