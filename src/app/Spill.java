package app;

import java.util.Collections;

public class Spill {
	
	public Spiller spiller, dealer;
	public CardDeck cdeck;
	public Card card3, card4, card5, dcard3, dcard4, dcard5 = null;
	public int bet;
	
	public Spill(int money) {					//khoi tao cuoc choi
		
		if (money > 0) {
			this.cdeck = new CardDeck();
			cdeck.shufflePerfectly();
			this.spiller = new Spiller(money, cdeck.carddeck.remove(0), cdeck.carddeck.remove(0));
			this.dealer = new Spiller(0, cdeck.carddeck.remove(0), cdeck.carddeck.remove(0));
		} else {
			throw new IllegalArgumentException("Amount must be a number higher than zero");
		}
	}
		
	public void bet(int bet) {				//phuong thuc dat cuoc
		if (bet < 1 || bet > this.spiller.getMoney() || bet != (int) bet) {
			throw new IllegalArgumentException("Illegal bet");
		}
		//this.spiller.money -= bet;
		this.spiller.setMoney(this.spiller.getMoney() - bet);
		this.bet = bet;
	}
	
	public void cashout() {					//phuong thuc lay tien
		if (isBlackJack()) {
			//this.spiller.money += this.bet + this.bet*1.5;
			this.spiller.setMoney((int) Math.round(((this.spiller.getMoney() + this.bet + this.bet*1.5))));
		} else if (sumDealer() > 21 || isVictory()){
			//this.spiller.money += (this.bet)*2;
			this.spiller.setMoney(this.spiller.getMoney() + (this.bet)*2);
		} else if (isDraw()) {
			//this.spiller.money += this.bet;
			this.spiller.setMoney(this.spiller.getMoney() + this.bet);
		}
	}
	
	public int sumSpillerHelper() {			//phuong thuc tinh tong diem
		int sum = 0;
		if (Integer.parseInt(this.spiller.getCard1().toString().substring(1)) > 9) {
			 sum += 10;
		} else if (Integer.parseInt(this.spiller.getCard1().toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.spiller.getCard1().toString().substring(1));
		}
		if (Integer.parseInt(this.spiller.getCard2().toString().substring(1)) > 9) {
			sum += 10;
		} else if (Integer.parseInt(this.spiller.getCard2().toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.spiller.getCard2().toString().substring(1));
		}
		if (this.card3 == null) {return sum;}
		if (Integer.parseInt(this.card3.toString().substring(1)) > 9) {
			sum += 10;
		} else if (Integer.parseInt(this.card3.toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.card3.toString().substring(1));
		}
		if (this.card4 == null) {return sum;}
		if (Integer.parseInt(this.card4.toString().substring(1)) > 9) {
			sum += 10;
		} else if (Integer.parseInt(this.card4.toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.card4.toString().substring(1));
		}
		if (this.card5 == null) {return sum;}
		if (Integer.parseInt(this.card5.toString().substring(1)) > 9) {
			return sum+10;
		} else if (Integer.parseInt(this.card5.toString().substring(1)) == 1) {
			return sum+11;
		} else {
			return sum+Integer.parseInt(this.card5.toString().substring(1));
		}
	}
	
	public int sumSpiller() {
		int sum = sumSpillerHelper();
		if (sum > 21) {
			if (Integer.parseInt(this.spiller.getCard1().toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (Integer.parseInt(this.spiller.getCard2().toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (card3 == null) {return sum;}
			if (Integer.parseInt(this.card3.toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (card4 == null) {return sum;}
			if (Integer.parseInt(this.card4.toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (card5 == null) {return sum;}
			if (Integer.parseInt(this.card5.toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		return sum;
	}

	public int sumSpillerUtenEss() {
		int nr1, nr2, nr3, nr4 = 0;
		if (Integer.parseInt(this.spiller.getCard1().toString().substring(1)) > 10) {
			nr1 = 10;
		} else {
			nr1 = Integer.parseInt(this.spiller.getCard1().toString().substring(1));
		}
		if (Integer.parseInt(this.spiller.getCard2().toString().substring(1)) > 10) {
			nr2 = 10;
		} else {
			nr2 = Integer.parseInt(this.spiller.getCard2().toString().substring(1));
		}
		if (this.card3 == null) {return nr1 + nr2;}
		if (Integer.parseInt(this.card3.toString().substring(1)) > 10) {
			nr3 = 10;
		} else {
			nr3 = Integer.parseInt(this.card3.toString().substring(1));
		}
		if (this.card4 == null) {return nr1 + nr2 + nr3;}
		if (Integer.parseInt(this.card4.toString().substring(1)) > 10) {
			nr4 = 10;
		} else {
			nr4 = Integer.parseInt(this.card4.toString().substring(1));
		}
		if (this.card5 == null) {return nr1 + nr2 + nr3 + nr4;}
		if (Integer.parseInt(this.card5.toString().substring(1)) > 10) {
			return nr1+nr2+nr3+nr4+10;
		} else {
			return nr1+nr2+nr3+nr4+Integer.parseInt(this.card5.toString().substring(1));
		}
	}
	
	public int sumDealerUtenEss() {
		int nr1, nr2, nr3, nr4 = 0;
		if (Integer.parseInt(this.dealer.getCard1().toString().substring(1)) > 10) {
			nr1 = 10;
		} else {
			nr1 = Integer.parseInt(this.dealer.getCard1().toString().substring(1));
		}
		if (Integer.parseInt(this.dealer.getCard2().toString().substring(1)) > 10) {
			nr2 = 10;
		} else {
			nr2 = Integer.parseInt(this.dealer.getCard2().toString().substring(1));
		}
		if (this.dcard3 == null) {return nr1 + nr2;}
		if (Integer.parseInt(this.dcard3.toString().substring(1)) > 10) {
			nr3 = 10;
		} else {
			nr3 = Integer.parseInt(this.dcard3.toString().substring(1));
		}
		if (this.dcard4 == null) {return nr1 + nr2 + nr3;}
		if (Integer.parseInt(this.dcard4.toString().substring(1)) > 10) {
			nr4 = 10;
		} else {
			nr4 = Integer.parseInt(this.dcard4.toString().substring(1));
		}
		if (this.dcard5 == null) {return nr1 + nr2 + nr3 + nr4;}
		if (Integer.parseInt(this.dcard5.toString().substring(1)) > 10) {
			return nr1+nr2+nr3+nr4+10;
		} else {
			return nr1+nr2+nr3+nr4+Integer.parseInt(this.dcard5.toString().substring(1));
		}
	}
	
	public int sumDealerHelper() {
		int sum = 0;
		if (Integer.parseInt(this.dealer.getCard1().toString().substring(1)) > 9) {
			 sum += 10;
		} else if (Integer.parseInt(this.dealer.getCard1().toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.dealer.getCard1().toString().substring(1));
		}
		if (Integer.parseInt(this.dealer.getCard2().toString().substring(1)) > 9) {
			sum += 10;
		} else if (Integer.parseInt(this.dealer.getCard2().toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.dealer.getCard2().toString().substring(1));
		}
		if (this.dcard3 == null) {return sum;}
		if (Integer.parseInt(this.dcard3.toString().substring(1)) > 9) {
			sum += 10;
		} else if (Integer.parseInt(this.dcard3.toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.dcard3.toString().substring(1));
		}
		if (this.dcard4 == null) {return sum;}
		if (Integer.parseInt(this.dcard4.toString().substring(1)) > 9) {
			sum += 10;
		} else if (Integer.parseInt(this.dcard4.toString().substring(1)) == 1) {
			sum += 11;
		} else {
			sum += Integer.parseInt(this.dcard4.toString().substring(1));
		}
		if (this.dcard5 == null) {return sum;}
		if (Integer.parseInt(this.dcard5.toString().substring(1)) > 9) {
			return sum+10;
		} else if (Integer.parseInt(this.dcard5.toString().substring(1)) == 1) {
			return sum+11;
		} else {
			return sum+Integer.parseInt(this.dcard5.toString().substring(1));
		}
	}
	
	public int sumDealer() {
		int sum = sumDealerHelper();
		if (sum > 21) {
			if (Integer.parseInt(this.dealer.getCard1().toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (Integer.parseInt(this.dealer.getCard2().toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (dcard3 == null) {return sum;}
			if (Integer.parseInt(this.dcard3.toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (dcard4 == null) {return sum;}
			if (Integer.parseInt(this.dcard4.toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		if (sum > 21) {
			if (dcard5 == null) {return sum;}
			if (Integer.parseInt(this.dcard5.toString().substring(1)) == 1) {
				sum -= 10;
			}
		}
		return sum;
	}
	
	public boolean isBlackJack() {
		if (sumSpiller() == 21 && card3 == null && card4 == null && card5 == null) {
			return true;
		}
		return false;
	}
	
	public boolean sumIsValid() {
		if (sumSpiller() <= 21) {
			return true;
		}
		return false;
	}
	
	public void drawCard() {
		if (sumSpiller() <= 21) {
			if (this.card3 == null) {
				this.card3 = this.cdeck.carddeck.remove(0);
				return;
			}
			if (this.card4 == null) {
				this.card4 = this.cdeck.carddeck.remove(0);
				return;
			}
			if (this.card5 == null) {
				this.card5 = this.cdeck.carddeck.remove(0);
				return;
			}
		}
		throw new IllegalArgumentException("Can't draw card");
	}
	
	public void dDrawCard() {
		if (sumDealer() < 17) {
			if (this.dcard3 == null) {
				this.dcard3 = this.cdeck.carddeck.remove(0);
				return;
			}
			if (this.dcard4 == null) {
				this.dcard4 = this.cdeck.carddeck.remove(0);
				return;
			}
			if (this.dcard5 == null) {
				this.dcard5 = this.cdeck.carddeck.remove(0);
				return;
			}
		}
		throw new IllegalArgumentException("Dealer can't draw card");
	}
	
	public boolean isVictory() {
		if (sumSpiller() > sumDealer()) {
			return true;
		}
		return false;
	}
	
	public boolean isDraw() {
		if (sumSpiller() == sumDealer()) {
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		Spill spill = new Spill(500);
		System.out.println(spill.spiller.getCard1());System.out.println(spill.spiller.getCard2());System.out.println(spill.sumSpiller());System.out.println(spill.card3);
		spill.drawCard();System.out.println(spill.card3);spill.drawCard();System.out.println(spill.card4);spill.drawCard();System.out.println(spill.card5);
		System.out.println(spill.sumSpiller());
	}
}
