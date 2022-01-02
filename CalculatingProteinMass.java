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
		String string = file.next();
		
		double weight = 0.0;
		
		for (int i = 0; i < string.length(); i++) {
			weight += massTable(string.charAt(i));
		}
		
		System.out.printf("%.3f", weight);
	}
	
	public static double massTable(char symbol) {
		Hashtable<Character, Double> massTable = new Hashtable<>();
		massTable.put('A', 71.03711);
		massTable.put('C', 103.00919);
		massTable.put('D', 115.02694);
		massTable.put('E', 129.04259);
		massTable.put('F', 147.06841);
		massTable.put('G', 57.02146);
		massTable.put('H', 137.05891);
		massTable.put('I', 113.08406);
		massTable.put('K', 128.09496);
		massTable.put('L', 113.08406);
		massTable.put('M', 131.04049);
		massTable.put('N', 114.04293);
		massTable.put('P', 97.05276);
		massTable.put('Q', 128.05858);
		massTable.put('R', 156.10111);
		massTable.put('S', 87.03203);
		massTable.put('T', 101.04768);
		massTable.put('V', 99.06841);
		massTable.put('W', 186.07931);
		massTable.put('Y', 163.06333 );
		
		return massTable.get(symbol);
	}	
}