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

		// constructing the data structure for the RNA Codon Table
		HashMap<String, String> rnaCodonTable = buildRNACodonStructure();

		Scanner file = new Scanner(new File("rosalind_prot.txt"));
		String rnaString = file.next();
		String[] arr = new String[rnaString.length() / 3];

		// copy all codons in the RNA string into an array
		for (int i = 0, start = 0, end = 3; i < arr.length; i++, start += 3, end += 3) {
			arr[i] = rnaString.substring(start, end);
		}

		String proteinString = "";

		// use the RNA Codon Table data structure to encode each codon into it's corresponding amino acid
		for (int i = 0; i < arr.length; i++) {
			proteinString += rnaCodonTable.get(arr[i]);
		}
		System.out.print(proteinString);
	}

	public static HashMap<String, String> buildRNACodonStructure() throws FileNotFoundException {
		/* this method uses an input file containing the amino acid alphabet
		 * and it's corresponding codons to build a data structure for encoding
		 */
		Scanner table = new Scanner(new File("RNA_codon_table.txt"));

		HashMap<String, String> rnaCodonTable = new HashMap<String, String>();
		
		while (table.hasNext()) {
			String rnaString = table.next();
			String aminoAcid = table.next();
			rnaCodonTable.put(rnaString, aminoAcid);
		}
		return rnaCodonTable;
	}
}	