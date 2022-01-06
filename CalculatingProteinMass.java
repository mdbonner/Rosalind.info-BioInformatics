/* In a weighted alphabet, every symbol is assigned a positive real number called a weight. 
 * A string formed from a weighted alphabet is called a weighted string, and its weight is equal to the sum of the weights of its symbols.
 * 
 * The standard weight assigned to each member of the 20-symbol amino acid alphabet is the monoisotopic mass of the corresponding amino acid.
 * 
 * Given: A protein string P of length at most 1000 aa.
 * Return: The total weight of P.
 * 
 * https://rosalind.info/problems/prtm/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class CalculatingProteinMass {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_prtm.txt"));
		char[] proteinString = file.next().toCharArray();
		
		// constructing the data structure for the Monoisotopic Mass Table
		HashMap<Character, Double> massTable = buildMassTable();
		
		double weight = 0.0;
		
		/* iterate through each amino acid in the protein string and get the
		 * monoisotopic mass for that amino acid from the data structure
		 */
		for (int i = 0; i < proteinString.length; i++) {
			weight += massTable.get(proteinString[i]);
		}
		
		System.out.printf("%.3f", weight);
	}

	/* method to create a data structure for each amino acid
	 * and it's corresponding monoisotopic mass
	 */
	public static HashMap<Character, Double> buildMassTable() throws FileNotFoundException {
		Scanner file = new Scanner(new File("monoisotopic_mass_table.txt"));
		HashMap<Character, Double> massTable = new HashMap<>();
		
		while (file.hasNext()) {
			Character aminoAcid = file.next().charAt(0);
			Double mass = file.nextDouble();
			massTable.put(aminoAcid, mass);
		}
		return massTable;
	}	
}