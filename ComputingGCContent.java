/* The GC-content of a DNA string is given by the percentage of symbols in the string that are 'C' or 'G'. 
 * For example, the GC-content of "AGCTATAG" is 37.5%. Note that the reverse complement of any DNA string has the same GC-content.
 * 
 * DNA strings must be labeled when they are consolidated into a database. A commonly used method of string labeling is called FASTA format. 
 * In this format, the string is introduced by a line that begins with '>', followed by some labeling information. 
 * Subsequent lines contain the string itself; the first line to begin with '>' indicates the label of the next string.
 * 
 * In Rosalind's implementation, a string in FASTA format will be labeled by the ID "Rosalind_xxxx", 
 * where "xxxx" denotes a four-digit code between 0000 and 9999.
 * 
 * Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).
 * Return: The ID of the string having the highest GC-content, followed by the GC-content of that string. 
 * 
 * https://rosalind.info/problems/gc/
 */

package bioinformaticsStronghold;

import java.util.*;
import java.io.*;

public class ComputingGCContent {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("rosalind_gc.txt"));
		String input = "";
		
		while (file.hasNext()) {
			String line = file.next();
			line = line.replace("\n", "");
			line = line.replace(">", " ");
			input += line;
		}
		
		String highestID = "";
		double highestContent = 0;
		Scanner data = new Scanner(input);
		
		while (data.hasNext()) {
			String line = data.next();
			String ID = line.substring(0, 13);
			String seq = line.substring(13, line.length());
			
			if (getPercent(seq) > highestContent) {
				highestID = ID;
				highestContent = getPercent(seq);
			}
		}
		System.out.println(highestID);
		System.out.printf("%.6f", highestContent);
		System.out.println("%");
	}
	
	public static double getPercent(String seq) {
		int count = 0;
		int total = seq.length();

		for (int i = 0; i < total - 1; i++) {
			if (seq.charAt(i) == 'G' || seq.charAt(i) == 'C') {
				count++;
			}
		}
		
		return (double) count / total * 100;
	}
}