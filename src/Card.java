
public class Card {
	private Card prev;
	private Card next;
	private String suit;
	private int rank;
	private int priority;

	
	public Card(String suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
		
		switch (suit) {
		case "S":
			setPriority(0);
			break;
		case "H":
			setPriority(1);
			break;
		case "C":
			setPriority(2);
			break;
		case "D":
			setPriority(3);
			break;

		default:
			break;
		}
	}

	public Card getPrev() {
		return prev;
	}

	public void setPrev(Card prev) {
		this.prev = prev;
	}

	public Card getNext() {
		return next;
	}

	public void setNext(Card next) {
		this.next = next;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return suit + "|" + rank;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
}
