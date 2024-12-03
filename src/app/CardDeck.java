package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	public List<Card> carddeck = new ArrayList<>();
	
	public CardDeck(int n) {
		if (!(n>=1 && n<= 13)) {
			throw new IllegalArgumentException("quá nhiều/quá ít thẻ bài");
		}
		for (int i=1;i<n+1;i++) {
			carddeck.add(new Card('S', i));
		}
		
		for (int i=1;i<n+1;i++) {
			carddeck.add(new Card('H', i));
		}
		
		for (int i=1;i<n+1;i++) {
			carddeck.add(new Card('D', i));
		}
		
		for (int i=1;i<n+1;i++) {
			carddeck.add(new Card('C', i));
		}
	}
	
	public CardDeck() {						//Khoi tao bo bai
		this(13);
	}
	
	public int getCardCount() {					//tra ve so luong bai
		return carddeck.size();
	}
	
	public Card getCard(int n) {						//tra ve la bai o vi tri thu n
		if (!(n >= 0 && n <= carddeck.size()-1)) {
			throw new IllegalArgumentException("Số không hợp lệ");
		}
		
		return carddeck.get(n);
	}
	
	public void shufflePerfectly() {					//tron bai voi nhau
		List<Card> pile1 = new ArrayList<>(carddeck.subList(0, (carddeck.size()/2)));
		List<Card> pile2 = new ArrayList<>(carddeck.subList((carddeck.size()/2), carddeck.size()));
		carddeck.clear();
		for (int i = 0; i<pile1.size(); i++) {
			carddeck.add(pile1.get(i));
			carddeck.add(pile2.get(i));
		}
	}
	
	public static void main(String[] args) {					
		CardDeck ting = new CardDeck();
		ting.shufflePerfectly();
		System.out.println(ting.carddeck);
	}
	
}
