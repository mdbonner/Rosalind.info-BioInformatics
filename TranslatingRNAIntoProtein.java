/* The 20 commonly occurring amino acids are abbreviated by using 20 letters from the English alphabet (all letters except for B, J, O, U, X, and Z). 
 * Protein strings are constructed from these 20 symbols. Henceforth, the term genetic string will incorporate protein strings along with DNA strings and RNA strings.
 * 
 * The RNA codon table dictates the details regarding the encoding of specific codons into the amino acid alphabet.
 * 
 * Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).
 * Return: The protein string encoded by s.
 * 
 * https://rosalind.info/problems/prot/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class TranslatingRNAIntoProtein {

	public static void main(String[] args) throws FileNotFoundException {		
		Scanner file = new Scanner(new File("rosalind_prot.txt"));
		String rnaString = file.next();
		String[] arr = new String[rnaString.length() / 3];
		
		for (int i = 0, start = 0, end = 3; i < arr.length; i++, start += 3, end += 3) {
			arr[i] = rnaString.substring(start, end);
		}
		
		String proteinString = "";
		
		for (int i = 0; i < arr.length; i++) {
			proteinString += getCodon(arr[i]);
		}
		System.out.print(proteinString);
	}

	public static String getCodon(String s) {

		if (s.equals("AUG")) {
			return "M";
		} else if (s.equals("UUU") || s.equals("UUC")) {
			return "F";
		} else if (s.equals("UUA") || s.equals("UUG")) {
			return "L";
		} else if (s.equals("UCU") || s.equals("UCC") || s.equals("UCA") || s.equals("UCG")) {
			return "S";
		} else if (s.equals("UAU") || s.equals("UAC")) {
			return "Y";
		} else if (s.equals("UAA") || s.equals("UAG") || s.equals("UGA")) {
			return "Stop";
		} else if (s.equals("UGU") || s.equals("UGC")) {
			return "C";
		} else if (s.equals("UGG")) {
			return "W";
		} else if (s.equals("CUU") || s.equals("CUC") || s.equals("CUA") || s.equals("CUG")) {
			return "L";
		} else if (s.equals("CCU") || s.equals("CCC") || s.equals("CCA") || s.equals("CCG")) {
			return "P";
		} else if (s.equals("CAU") || s.equals("CAC")) {
			return "H";
		} else if (s.equals("CAA") || s.equals("CAG")) {
			return "Q";
		} else if (s.equals("CGU") || s.equals("CGC") || s.equals("CGA") || s.equals("CGG")) {
			return "R";
		} else if (s.equals("AUU") || s.equals("AUC") || s.equals("AUA")) {
			return "I";
		} else if (s.equals("AUG")) {
			return "M";
		} else if (s.equals("ACU") || s.equals("ACC") || s.equals("ACA") || s.equals("ACG")) {
			return "T";
		} else if (s.equals("AAU") || s.equals("AAC")) {
			return "N";
		} else if (s.equals("AAA") || s.equals("AAG")) {
			return "K";
		} else if (s.equals("AGU") || s.equals("AGC")) {
			return "S";
		} else if (s.equals("AGG") || s.equals("AGA")) {
			return "R";
		} else if (s.equals("GUU") || s.equals("GUC") || s.equals("GUA") || s.equals("GUG")) {
			return "V";
		} else if (s.equals("GCU") || s.equals("GCC") || s.equals("GCA") || s.equals("GCG")) {
			return "A";
		} else if (s.equals("GAU") || s.equals("GAC")) {
			return "D";
		} else if (s.equals("GAA") || s.equals("GAG")) {
			return "E";
		} else if (s.equals("GGU") || s.equals("GGC") || s.equals("GGA") || s.equals("GGG")) {
			return "G";
		}
		return null;
	}	
}