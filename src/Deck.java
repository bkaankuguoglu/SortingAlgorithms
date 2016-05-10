import java.util.Comparator;

public class Deck extends LinkedList {
	private static String mergedText = "";
	// S > H > C > D

	public Deck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int compare(Card c1, Card c2) {
		int i = 0;
		if (c1.getPriority() < c2.getPriority()) {
			i = -1;
		} else if (c1.getPriority() > c2.getPriority()) {
			i = 1;
		} else {
			if (c1.getRank() < c2.getRank()) {
				i = -1;
			} else if (c1.getRank() > c2.getRank()) {
				i = 1;
			} else {
				i = 0;
			}
		}
		return i;

	}

	public static void merge(LinkedList d1, LinkedList d2, LinkedList mergedDeck) {
		// System.out.println("Deck 2 "+d2);
		while ((!d1.isEmpty()) && (!d2.isEmpty())) {
			if (d1.getHead().getPriority() < (d2.getHead().getPriority())) {
				mergedDeck.addLast(d1.removeFirst());
			} else if (d1.getHead().getPriority() > (d2.getHead().getPriority())) {
				mergedDeck.addLast(d2.removeFirst());
			} else {
				if (d1.getHead().getRank() < d2.getHead().getRank()) {
					mergedDeck.addLast(d1.removeFirst());
				} else {
					mergedDeck.addLast(d2.removeFirst());
				}
			}
		}

		while (!d1.isEmpty())
			mergedDeck.addLast(d1.removeFirst());

		while (!d2.isEmpty())
			mergedDeck.addLast(d2.removeFirst());

		mergedText = "" + mergedDeck;
	}

	public static void mergeSort(LinkedList d) {
		int n = d.getSize();
		LinkedList d1 = new LinkedList();
		LinkedList d2 = new LinkedList();
		if (n >= 2) {
			while (d1.getSize() < n / 2)
				d1.addLast(d.removeFirst());
			while (!d.isEmpty())
				d2.addLast(d.removeFirst());

			mergeSort(d1);
			mergeSort(d2);
			System.out.println("Left part: " + d1);
			System.out.println("Right part: " + d2);
			merge(d1, d2, d);

			System.out.println("Merged " + mergedText + "\n");

		}

	}

	public static LinkedList quickSort(LinkedList d) {
		int n = d.getSize();
		LinkedList less = new LinkedList();
		LinkedList equal = new LinkedList();
		LinkedList greater = new LinkedList();
		String l = "";
		String e = "";
		String g = "";

		if (n >= 2) {
			Card pivot = d.getTail();
			System.out.println("\nPivot: " + pivot);

			while (!d.isEmpty()) {
				Card c = d.removeFirst();
				if (c.getPriority() < pivot.getPriority()) {
					less.addLast(c);
				} else if (c.getPriority() > pivot.getPriority()) {
					greater.addLast(c);
				} else {
					if (c.getRank() < pivot.getRank()) {
						less.addLast(c);
					} else if (c.getRank() > pivot.getRank()) {
						greater.addLast(c);
					} else {
						equal.addLast(c);
					}
				}

			}

			l = less + "";
			e = equal + "";
			g = greater + "";

			System.out.println("Less: " + l);
			System.out.println("Equal: " + e);
			System.out.println("Greater: " + g);

			quickSort(less);
			quickSort(greater);

			while (!less.isEmpty())
				d.addLast(less.removeFirst());
			while (!equal.isEmpty())
				d.addLast(equal.removeFirst());
			while (!greater.isEmpty())
				d.addLast(greater.removeFirst());

		}
		return d;
	}

//	public static void quickSortInPlaceByNodes(Deck d, Card a, Card b) {
//		if (a.getRank() < b.getRank()) {
//			Card left = a;
//			Card right = b.getPrev();
//			Card pivot = b;
//
//			System.out.println("Pivot - " + b);
//			System.out.println("Right - " + right);
//			System.out.println("Left - " + left);
//
//			while (compare(left, right) < 0) {
//
//				while (compare(left, pivot) < 0) {
//					left = left.getNext();
//					// System.out.println("->");
//				}
//				if (compare(left, pivot) == 0)
//					left = pivot.getPrev();
//				while ((compare(right, pivot) > 0)) {
//					right = right.getPrev();
//					// System.out.println("<-");
//				}
//
//				// System.out.println("Left - "+ left);
//				// System.out.println("Right - "+ right);
//
//			}
//
//			if (left.getPrev() == right) {
//				swap(left, right);
//			}
//			swap(left, right);
//
//			// System.out.println("r and l after swap");
//			// System.out.println("Left - "+ left);
//			// System.out.println("Right - "+ right);
//
//			while (pivot.getPrev() != left) {
//				// System.out.println("\npivot - "+ pivot);
//				// System.out.println("prev - "+ pivot.getPrev());
//				swap(pivot, pivot.getPrev());
//				pivot = pivot.getPrev();
//			}
//			while (compare(pivot, pivot.getPrev()) < 0) {
//				swap(pivot, pivot.getPrev());
//				pivot = pivot.getPrev();
//			}
//			System.out.println(d);
//			quickSortInPlaceByNodes(d, a, left);
//			quickSortInPlaceByNodes(d, left.getNext(), b);
//		}
//	}

	public static Deck inplaceQuicksort(Deck d, int a, int b) {			
		if (a >= b)
			
			return d;
		int left = a;
		int right = b-1;
		
		System.out.println("Pivot: " + d.getIndex(d, b));
		while (left <= right) {

			while ((left <= right) && (compare(d.getIndex(d, left),d.getIndex(d, b))<0)) {
				left++;
			}		
			while ((left <= right) && (compare(d.getIndex(d, right),d.getIndex(d, b))>0)) {
				right--;
			}
			

			if (left <= right) {
				swap(d,d.getIndex(d, left), d.getIndex(d, right));
				left++;
				right--;
			}
			

		}
		
		swap(d,d.getIndex(d, left), d.getIndex(d, b));
		

		
		
		System.out.println(d);

		inplaceQuicksort(d, a, left -1);
		inplaceQuicksort(d, left + 1, b);
		
		return d;
	}


	public static void swap(Deck d,Card c1, Card c2) {
		// System.out.println("Swapped " + c1 + " - " + c2);
		String suit = c1.getSuit();
		int rank = c1.getRank();
		c1.setSuit(c2.getSuit());
		c1.setRank(c2.getRank());
		c2.setSuit(suit);
		c2.setRank(rank);
	}



	public static void printDeck(LinkedList deck) {
		System.out.println(deck);
	}
	
	public Card getIndex(Deck d,int i) {
		Card c = d.getHead();
		for (int j = 0; j < i; j++) {
			c=c.getNext();
		}
		
		return c;
	}

}
