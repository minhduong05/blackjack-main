package app.backend;

public class Card {
	
	private char suit;
	private int rank;
	
	public Card(char suit, int rank) { 					
		if (!validCard(suit, rank)) {
			throw new IllegalArgumentException("Lá bài không hợp lệ");		
		}
		this.suit = suit;											
		this.rank = rank;
	}
	
	private boolean validCard(char suit, int rank) {			
		if (!(suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C')) {
			return false;
		}
		if (!(rank >= 1 && rank <= 13)) {
			return false;
		}
		return true;
	}
	
	public char getSuit() {
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String toString() {
		return ""+suit+rank;
	}
	
}
