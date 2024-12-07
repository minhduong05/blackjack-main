package app.frontend;

import java.io.File;

import app.backend.BlackJackIO;
import app.backend.BlackJackObjectloader;
import app.backend.Spill;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BlackJackController {

	@FXML private TextField writeNameField;
	@FXML private Label spillerSum, dealerSum, outcome, pot, bank, info, bet, name, writeNameLabel, saveInfoLabel;
	@FXML private ImageView card1, card2, card3, card4, card5, dcard1, dcard2, dcard3, dcard4, dcard5;
	@FXML private Button zero, one, ten, twentyFive, hundred, fiveHundred, tipp, hit, stand, back, back2, load, load1, load2, load3, load4, enterName, newGame;
	@FXML private AnchorPane start;
	private String tall;

	Spill spill = null;
	BlackJackIO io1 = new BlackJackIO();
	BlackJackIO io2 = new BlackJackIO();
	BlackJackIO io3 = new BlackJackIO();
	BlackJackIO io4 = new BlackJackIO();

	public void startNewGameClick() {
		try {
			if (writeNameField.getText().length() == 0) {
				throw new IllegalArgumentException("Write name");
			}
			spill = new Spill(500);
			bank.setText(Integer.toString(spill.spiller.getMoney()));
			name.setText(writeNameField.getText());
			card1.setImage(null);
			card2.setImage(null);
			card3.setImage(null);
			card4.setImage(null);
			card5.setImage(null);
			dcard1.setImage(null);
			dcard2.setImage(null);
			dcard3.setImage(null);
			dcard4.setImage(null);
			dcard5.setImage(null);
			spillerSum.setText("");
			dealerSum.setText("");
			writeNameField.setText("");
			bet.setText("");info.setText("");
			pot.setText("");outcome.setText("");
			tipp.setVisible(false);
			hit.setVisible(false);
			stand.setVisible(false);
			start.setVisible(false);
		} catch (Exception e) {
			info.setText("Write a name");
		}
	}

	public void enterNameClick() {
		try {
			if (writeNameField.getText().length() == 0) {
				throw new IllegalArgumentException("Write a name");
			}
			writeNameField.setVisible(false);
			writeNameLabel.setVisible(false);
			enterName.setVisible(false);
			load1.setVisible(true);
			load2.setVisible(true);
			load3.setVisible(true);
			load4.setVisible(true);
			load.setVisible(false);
			saveInfoLabel.setVisible(true);
		} catch (Exception e) {
			info.setText(e.getMessage());
		}
	}

	public void newGameClick() {
		try {
			newGame.setVisible(false);
			load.setVisible(false);
			writeNameField.setVisible(true);
			writeNameLabel.setVisible(true);
			enterName.setVisible(true);
			if (new File("spill1.txt").isFile()) {
				BlackJackObjectloader l1 = io1.load("spill1.txt");
				load1.setText(l1.getName());
			}
			if (new File("spill2.txt").isFile()) {
				BlackJackObjectloader l2 = io2.load("spill2.txt");
				load2.setText(l2.getName());
			}
			if (new File("spill3.txt").isFile()) {
				BlackJackObjectloader l3 = io3.load("spill3.txt");
				load3.setText(l3.getName());
			}
			if (new File("spill4.txt").isFile()) {
				BlackJackObjectloader l4 = io4.load("spill4.txt");
				load4.setText(l4.getName());
			}
		} catch (Exception e) {
			info.setText(e.getMessage());
		}

	}

	public void clickLoad() {
		try {
			load1.setVisible(true);
			load2.setVisible(true);
			load3.setVisible(true);
			load4.setVisible(true);
			load.setVisible(false);
			newGame.setVisible(false);
			back2.setVisible(true);

			if (new File("spill1.txt").isFile()) {
				BlackJackObjectloader l1 = io1.load("spill1.txt");
				load1.setText(l1.getName());
			}
			if (new File("spill2.txt").isFile()) {
				BlackJackObjectloader l2 = io2.load("spill2.txt");
				load2.setText(l2.getName());
			}
			if (new File("spill3.txt").isFile()) {
				BlackJackObjectloader l3 = io3.load("spill3.txt");
				load3.setText(l3.getName());
			}
			if (new File("spill4.txt").isFile()) {
				BlackJackObjectloader l4 = io4.load("spill4.txt");
				load4.setText(l4.getName());
			}
		} catch (Exception e) {

		}
	}

	public void startNewGameClick(String name, int money) {
		try {
			if (name == null || name== "") {
				throw new IllegalArgumentException("No load available");
			}
			spill = new Spill(money);
			bank.setText(Integer.toString(spill.spiller.getMoney()));this.name.setText(name);
			card1.setImage(null);
			card2.setImage(null);
			card3.setImage(null);
			card4.setImage(null);
			card5.setImage(null);
			dcard1.setImage(null);
			dcard2.setImage(null);
			dcard3.setImage(null);
			dcard4.setImage(null);
			dcard5.setImage(null);
			spillerSum.setText("");
			dealerSum.setText("");
			writeNameField.setText("");
			bet.setText("");
			info.setText("Welcome back!");
			pot.setText("");
			outcome.setText("");
			tipp.setVisible(false);
			hit.setVisible(false);
			stand.setVisible(false);
			start.setVisible(false);
		} catch (Exception e) {
			info.setText("No load");
		}
	}


	public void betClick() {
		try {
			info.setText("");
			if (pot.getText().length() != 0) {
				throw new IllegalArgumentException("Money already in pot");
			}
			spill.bet(Integer.parseInt(bet.getText()));
			bank.setText(Integer.toString(spill.spiller.getMoney()));
			pot.setText(bet.getText());
			bet.setText("");
			Image b1 = new Image("/app/kort/" + spill.spiller.getCard1().toString() + ".png");
			card1.setImage(b1);
			Image b2 = new Image("/app/kort/" + spill.spiller.getCard2().toString() + ".png");
			card2.setImage(b2);
			Image bd1 = new Image("/app/kort/" + spill.dealer.getCard1().toString() + ".png");
			dcard1.setImage(bd1);
			Image bak = new Image("/app/kort/bakside.png");
			dcard2.setImage(bak);
			card3.setImage(null);card4.setImage(null);card5.setImage(null);dcard3.setImage(null);dcard4.setImage(null);dcard5.setImage(null);
			outcome.setText("");
			spillerSum.setText(Integer.toString(spill.sumSpiller()));
			dealerSum.setText("");info.setText("");
			hit.setVisible(true);stand.setVisible(true);tipp.setVisible(false);
			if (spill.isBlackJack()) {
				spill.cashout();
				outcome.setText("Blackjack!");
				bank.setText(Integer.toString(spill.spiller.getMoney()));
				info.setText("");pot.setText("");bet.setText("");
				spill = new Spill(spill.spiller.getMoney());
				hit.setVisible(false);stand.setVisible(false);
			}
		} catch (Exception e) {
			info.setText("");
		}
	}

	public void hitClick() {
		try {
			info.setText("");
			if ((pot.getText().length() == 0)) {
				throw new IllegalArgumentException("Place bet first");
			}
			spill.drawCard();
			if (card3.getImage() == null) {
				Image b3 = new Image("/app/kort/" + spill.card3.toString() + ".png");
				card3.setImage(b3);
			}
			if (card4.getImage() == null && spill.card4 != null) {
				Image b4 = new Image("/app/kort/" + spill.card4.toString() + ".png");
				card4.setImage(b4);
			}
			if (card5.getImage() == null && spill.card5 != null) {
				Image b5 = new Image("/app/kort/" + spill.card5.toString() + ".png");
				card5.setImage(b5);
			}
			spillerSum.setText(Integer.toString(spill.sumSpiller()));
			if (!(spill.sumIsValid())) {
				if (spill.spiller.getMoney() == 0) {
					info.setText("No more money");
					outcome.setText("You lost...");
					pot.setText("");bet.setText("");
					hit.setVisible(false);stand.setVisible(false);
					return;
				}
				outcome.setText("You lost...");
				bank.setText(Integer.toString(spill.spiller.getMoney()));
				info.setText("");pot.setText("");bet.setText("");
				spill = new Spill(spill.spiller.getMoney());
				hit.setVisible(false);stand.setVisible(false);
			}
		} catch (Exception e) {
			info.setText(e.getMessage());
		}
	}

	public void clickStand() {
		try {
			info.setText("");
			if (pot.getText().length() == 0) {
				throw new IllegalArgumentException("Place bet first");
			}
			Image bd2 = new Image("/app/kort/" + spill.dealer.getCard2().toString() + ".png");
			dcard2.setImage(bd2);
			dealerSum.setText(Integer.toString(spill.sumDealer()));
			while (spill.sumDealer() < 17) {
				spill.dDrawCard();
				if (dcard3.getImage() == null) {
					Image bd3 = new Image("/app/kort/" + spill.dcard3.toString() + ".png");
					dcard3.setImage(bd3);
				}
				if (dcard4.getImage() == null && spill.dcard4 != null) {
					Image bd4 = new Image("/app/kort/" + spill.dcard4.toString() + ".png");
					dcard4.setImage(bd4);
				}
				if (dcard5.getImage() == null && spill.dcard5 != null) {
					Image bd5 = new Image("/app/kort/" + spill.dcard5.toString() + ".png");
					dcard5.setImage(bd5);
				}
				dealerSum.setText(Integer.toString(spill.sumDealer()));
				if (dcard5.getImage() != null) {
					break;
				}
			}
			if (spill.isVictory() || spill.sumDealer() > 21) {
				spill.cashout();
				outcome.setText("You won!");
				bank.setText(Integer.toString(spill.spiller.getMoney()));
				info.setText("");
				pot.setText("");bet.setText("");
				spill = new Spill(spill.spiller.getMoney());
				hit.setVisible(false);stand.setVisible(false);
			} else if (spill.isDraw()) {
				spill.cashout();
				outcome.setText("It's a draw");
				bank.setText(Integer.toString(spill.spiller.getMoney()));
				info.setText("");
				pot.setText("");bet.setText("");
				spill = new Spill(spill.spiller.getMoney());
				hit.setVisible(false);stand.setVisible(false);
			} else {
				if (spill.spiller.getMoney() == 0) {
					info.setText("No more money...");
					pot.setText("");bet.setText("");
					outcome.setText("You lost...");
					hit.setVisible(false);stand.setVisible(false);
					return;
				}
				outcome.setText("You lost...");
				bank.setText(Integer.toString(spill.spiller.getMoney()));
				info.setText("");pot.setText("");bet.setText("");
				spill = new Spill(spill.spiller.getMoney());
				hit.setVisible(false);stand.setVisible(false);
			}
		} catch (Exception e) {
			info.setText(e.getMessage());
		}
	}

	public void clickFiveHundred() {
		try {
			if (pot.getText() != "") {
				throw new IllegalArgumentException();
			}
			if (Integer.parseInt(bank.getText()) < 500) {
				throw new IllegalArgumentException("Too poor...");
			}
			if (bet.getText() != "") {
				int sum = Integer.parseInt(bet.getText())+500;
				bet.setText(Integer.toString(sum));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-500));
			} else {
				bet.setText(Integer.toString(500));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-500));
			}
			if (bet.getText().length() != 0) {
				tipp.setVisible(true);
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
			}
		}
	}

	public void clickHundred() {
		try {
			if (pot.getText() != "") {
				throw new IllegalArgumentException();
			}
			if (Integer.parseInt(bank.getText()) < 100 || pot.getText() != "") {
				throw new IllegalArgumentException("Too poor...");
			}
			if (bet.getText() != "") {
				int sum = Integer.parseInt(bet.getText())+100;
				bet.setText(Integer.toString(sum));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-100));
			} else {
				bet.setText(Integer.toString(100));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-100));
			}
			if (bet.getText().length() != 0) {
				tipp.setVisible(true);
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
			}
		}
	}

	public void clickTwentyFive() {
		try {
			if (pot.getText() != "") {
				throw new IllegalArgumentException();
			}
			if (Integer.parseInt(bank.getText()) < 25 || pot.getText() != "") {
				throw new IllegalArgumentException("Too poor...");
			}
			if (bet.getText() != "") {
				int sum = Integer.parseInt(bet.getText())+25;
				bet.setText(Integer.toString(sum));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-25));
			} else {
				bet.setText(Integer.toString(25));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-25));
			}
			if (bet.getText().length() != 0) {
				tipp.setVisible(true);
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
			}
		}
	}

	public void clickTen() {
		try {
			if (pot.getText() != "") {
				throw new IllegalArgumentException();
			}
			if (Integer.parseInt(bank.getText()) < 10 || pot.getText() != "") {
				throw new IllegalArgumentException("Too poor...");
			}
			if (bet.getText() != "") {
				int sum = Integer.parseInt(bet.getText())+10;
				bet.setText(Integer.toString(sum));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-10));
			} else {
				bet.setText(Integer.toString(10));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-10));
			}
			if (bet.getText().length() != 0) {
				tipp.setVisible(true);
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
			}
		}
	}

	public void clickOne() {
		try {
			if (pot.getText() != "") {
				throw new IllegalArgumentException();
			}
			if (Integer.parseInt(bank.getText()) < 1 || pot.getText() != "") {
				throw new IllegalArgumentException("Too poor...");
			}
			if (bet.getText() != "") {
				int sum = Integer.parseInt(bet.getText())+1;
				bet.setText(Integer.toString(sum));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-1));
			} else {
				bet.setText(Integer.toString(1));
				bank.setText(Integer.toString(Integer.parseInt(bank.getText())-1));
			}
			if (bet.getText().length() != 0) {
				tipp.setVisible(true);
			}
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
			}
		}
	}

	public void clickNull() {
		try {
			if (bet.getText() == "") {
				return;
			}
			int sum = Integer.parseInt(bet.getText()) + Integer.parseInt(bank.getText());
			bank.setText(Integer.toString(sum));
			bet.setText("");
			tipp.setVisible(false);
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
			}
		}
	}

	public void back() {
		try {
			if (hit.isVisible()) {
				throw new IllegalArgumentException("Play hand first!");
			}
			if (bet.getText().length() != 0) {
				throw new IllegalArgumentException("Money in the pot! Press '0'");
			}
			newGame.setVisible(true);
			start.setVisible(true);
			load1.setVisible(false);
			load2.setVisible(false);
			load3.setVisible(false);
			load4.setVisible(false);
			load.setVisible(true);
			saveInfoLabel.setVisible(false);
			back2.setVisible(false);
			save();
		} catch (Exception e) {
			info.setText(e.getMessage());
		}
	}

	public void back2() {
		try {
			newGame.setVisible(true);
			start.setVisible(true);
			load1.setVisible(false);
			load2.setVisible(false);
			load3.setVisible(false);
			load4.setVisible(false);
			load.setVisible(true);
			saveInfoLabel.setVisible(false);
			back2.setVisible(false);
		} catch (Exception e) {
			info.setText(e.getMessage());
		}
	}


	public void save() {
		try {
			if (this.tall == "1") {
				io1.save("spill1.txt", name.getText(), Integer.parseInt(bank.getText()));
				return;
			}
			if (this.tall == "2") {
				io2.save("spill2.txt", name.getText(), Integer.parseInt(bank.getText()));
				return;
			}
			if (this.tall == "3") {
				io3.save("spill3.txt", name.getText(), Integer.parseInt(bank.getText()));
				return;
			}
			if (this.tall == "4") {
				io4.save("spill4.txt", name.getText(), Integer.parseInt(bank.getText()));
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			info.setText("Something failed");
		}
	}

	public void load1() {
		try {
			if (writeNameField.getText().length() != 0) {
				load1.setText(writeNameField.getText());
				tall = "1";
				info.setText(tall);
				startNewGameClick();
				return;
			}
			if(!(new File("spill1.txt").isFile())) {
				tall ="1";
				startNewGameClick();
				return;
			}
			BlackJackObjectloader loader = io1.load("spill1.txt");
			if (loader.getMoney() == 0) {
				load1.setText("0 money");
				tall = "1";
				return;
			}
			load1.setText(loader.getName());
			tall = "1";
			startNewGameClick(loader.getName(), loader.getMoney());
			back2.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			info.setText("Can't load");
		}
	}

	public void load2() {
		try {
			if (writeNameField.getText().length() != 0){
				load2.setText(writeNameField.getText());
				tall = "2";
				startNewGameClick();
				return;
			}
			if(!(new File("spill2.txt").isFile())) {
				tall = "2";
				startNewGameClick();
				return;
			}
			BlackJackObjectloader loader2 = io2.load("spill2.txt");
			if (loader2.getMoney() == 0) {
				load2.setText("0 money");
				tall = "2";
				startNewGameClick();
				return;
			}
			load2.setText(loader2.getName());
			tall = "2";
			startNewGameClick(loader2.getName(), loader2.getMoney());
			back2.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			info.setText("Can't load");
		}
	}

	public void load3() {
		try {
			if (writeNameField.getText().length() != 0){
				load3.setText(writeNameField.getText());
				tall = "3";
				startNewGameClick();
				return;
			}
			if(!(new File("spill3.txt").isFile())) {
				tall = "3";
				startNewGameClick();
				return;
			}
			BlackJackObjectloader loader3 = io3.load("spill3.txt");
			if (loader3.getMoney() == 0) {
				load3.setText("0 money");
				tall = "3";
				startNewGameClick();
				return;
			}
			load3.setText(loader3.getName());
			tall = "3";
			startNewGameClick(loader3.getName(), loader3.getMoney());
			back2.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			info.setText("Can't load");
		}
	}

	public void load4() {
		try {
			if (writeNameField.getText().length() != 0){
				load4.setText(writeNameField.getText());
				tall = "4";
				startNewGameClick();
				return;
			}
			if(!(new File("spill4.txt").isFile())) {
				tall = "4";
				startNewGameClick();
				return;
			}
			BlackJackObjectloader loader4 = io4.load("spill4.txt");
			if (loader4.getMoney() == 0) {
				load4.setText("0 money");
				tall = "4";
				startNewGameClick();
				return;
			}
			load4.setText(loader4.getName());
			tall = "4";
			startNewGameClick(loader4.getName(), loader4.getMoney());
			back2.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			info.setText("Can't load");
		}
	}








}