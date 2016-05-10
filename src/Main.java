import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static LinkedList myDeck;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deck deck = DBReader.readDatabase("input.txt");
		Deck deck2 = DBReader.readDatabase("input.txt");
		Deck d2 = new Deck();
		System.out.println("\nMergeSort\n");
		Deck.mergeSort(deck);
		System.out.println("\nBefore QuickSort:\n");
		System.out.println(deck2);
		System.out.println("\nQuickSort:\n");
		//Deck.quickSortInPlaceByNodes(deck2,deck2.getHead(), deck2.getTail());
		myDeck = Deck.inplaceQuicksort(deck2,0,deck2.getSize()-1);
		//Deck.quickHelper(deck2,0,deck2.getSize());
		System.out.println(myDeck);
//		System.out.println(deck2.getIndex(deck2, 4));
//		Deck.swap(deck2.getIndex(deck2, 4),deck2.getIndex(deck2, 5));
//		System.out.println(deck2);

		
/*
		String s = "";
		String command = "";
		String filename = "";
		BufferedReader br = null;
		int exit = 1;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			while (exit == 1) {
				System.out.print("\nEnter your command:" +
									"\n-| createDeck"+
									"\n-| mergeSort" + 
									"\n-| quickSort" + 
									"\n-| printDeck\n>");
				s=br.readLine();
				String[] arr = s.split("[\\*]+");
				command = arr[0];
				command = command.toLowerCase();
				if(arr[0].equalsIgnoreCase("createDeck"))
					filename = arr[1];
				switch (command) {
				case "mergesort":
					Deck.mergeSort(myDeck);
					break;

				case "quicksort":
					Deck.quickSort(myDeck);

					break;

				case "printdeck":
					Deck.printDeck(myDeck);
					break;

				case "createdeck":
					myDeck = DBReader.readDatabase("input.txt");
					break;

				default:
					exit = 0;
					break;
				}
			
			
		} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
	}


