
public class LinkedList {
	private Card tail;
	private int size;
	public Boolean isEmpty() {return size==0;};
	
	public LinkedList() {
		size = 0;
	}

	public Card getTail() {
		return tail;
	}
	
	public Card getHead() {
		return tail.getNext();
	}

	public void setTail(Card tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void addFirst(Card c){
		if(size==0){
			tail = c;
			tail.setNext(tail);
		}else{
			Card newCard = c;
			if(size==1){
				newCard.setNext(tail);
				newCard.setPrev(tail);
				tail.setNext(newCard);
				tail.setPrev(newCard);			
			}else{
			newCard.setNext(tail.getNext());
			newCard.setPrev(tail);
			tail.getNext().setPrev(newCard);
			tail.setNext(newCard);
			}
		}
		size++;
	}
	
	public void addLast(Card c){
		addFirst(c);
		tail = tail.getNext();
	}
	
	public Card removeFirst(){
		if(!isEmpty()){
			
		Card h = tail.getNext();
		
		if(tail == h)
			tail = null;
		else{
			h.getNext().setPrev(tail);
			tail.setNext(h.getNext());
		}			
		size--;	
		return h;
		}
		return null;
	}

	@Override
	public String toString() {
		if(isEmpty())
			return "";
		Card current = tail.getNext();
		String s = "";
		while(current!=tail){
			s += current + " -> ";
			current = current.getNext();
		}
		s += current;

		return s;
	}
	

		
	
	
	
}
