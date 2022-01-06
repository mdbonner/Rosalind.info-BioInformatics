/* After identifying the exons and introns of an RNA string, 
 * we only need to delete the introns and concatenate the exons to form a new string ready for translation.
 * 
 * Given: A DNA string s (of length at most 1 kbp) and a collection of subintrons of s acting as introns. All introns are given in FASTA format.
 * Return: A protein string resulting from transcribing and translating the exons of s. (Note: Only one solution will exist for the dataset provided.)
 * 
 * https://rosalind.info/problems/splc/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class RNASplicing {

	public static void main(String[] args) throws FileNotFoundException {
		
		// constructing the data structure for the RNA Codon Table
		HashMap<String, String> rnaCodonTable = buildRNACodonStructure();
		
		Scanner file = new Scanner(new File("rosalind_splc.txt"));
		
		/* 1. create data structure for introns
		 * 2. splice introns out of the DNA
		 * 3. transcribe the DNA into RNA
		 */
		ArrayList<String> introns = getIntrons(file);
		String dna = splice(introns.get(0), introns);
		String rna = transcribe(dna);
		String[] arr = new String[rna.length() / 3];
		
		// copy all codons in the RNA string into an array
		for (int i = 0, start = 0, end = 3; i < arr.length; i++, start += 3, end += 3) {
			arr[i] = rna.substring(start, end);
		}
		
		String proteinString = "";
		
		// use the RNA Codon Table data structure to encode each codon into it's corresponding amino acid
		for (int i = 0; i < arr.length; i++) {
			proteinString += rnaCodonTable.get(arr[i]);
		}
		System.out.print(proteinString);
	}
	
	// method create a data structure of all introns in the file
	public static ArrayList<String> getIntrons(Scanner file) {
		ArrayList<String> introns = new ArrayList<String>();
		String input = "";
		
		while (file.hasNext()) {
			String line = file.next();
			line = line.replace("\n", "");
			line = line.replace(">", " ");
			input += line;
		}
		
		Scanner data = new Scanner(input);
		while (data.hasNext()) {
			String line = data.next();
			if (line.contains("Rosalind_")) {
				line = line.substring(13, line.length());
				introns.add(line);
			}
		}
		return introns;
	}

	// method to delete the introns of the given DNA String
	public static String splice(String dna, ArrayList<String> introns) {
		for (int i = 1; i < introns.size(); i++) {
			dna = dna.replace(introns.get(i), "");
		}
		return dna;
	}
	
	// method to transcribe DNA into RNA
	public static String transcribe(String dna) {
		return dna.replace('T', 'U');
	}
	
	/* this method uses an input file containing the amino acid alphabet
	 * and it's corresponding codons to build a data structure for encoding
	 */
	public static HashMap<String, String> buildRNACodonStructure() throws FileNotFoundException {
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