import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBReader {
	private static String text;

	public static Deck readDatabase(String filename) {
		BufferedReader bufferedReader = null;
		Deck d = new Deck();
		try {

			String sCurrentLine;
			bufferedReader = new BufferedReader(new FileReader(filename));

			while ((sCurrentLine = bufferedReader.readLine()) != null) {
			    String [] tokens = sCurrentLine.split("\\s+");
			    String suit = tokens[0];
			    String rank = tokens[1];
			    Card c = new Card(suit,Integer.parseInt(rank));
			    d.addLast(c);
			}
			
			System.out.println("\nThe input text is read successfully. \n");
			//System.out.println(sortedText);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		text = d.toString();
		System.out.println(text);
		return d;
		
	}
	


}
