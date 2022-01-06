/* Given two strings s and t of equal length, the Hamming distance between s and t, 
 * denoted dH(s,t), is the number of corresponding symbols that differ in s and t.
 * 
 * Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
 * Return: The Hamming distance dH(s,t).
 * 
 * https://rosalind.info/problems/hamm/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class CountingPointMutations {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_hamm.txt"));
		int hammingDistance = 0;
		String dnaString1 = file.next();
		String dnaString2 = file.next();
		
		char[] array1 = new char[dnaString1.length()];
		char[] array2 = new char[dnaString2.length()];
		
		// copy each nucleobase from the DNA string into an array
		for (int i = 0; i < dnaString1.length(); i++) {
			array1[i] = dnaString1.charAt(i);
			array2[i] = dnaString2.charAt(i);
		}
		
		/* interate through each element of the arrays and compare the nucleobases,
		 * if the nucleobases match, then increment the hammingDistance variable
		 */
		for (int n = 0; n < array1.length; n++) {
			if (array1[n] != array2[n]) {
				hammingDistance++;
			}
		}		
		System.out.println(hammingDistance);
	}
}