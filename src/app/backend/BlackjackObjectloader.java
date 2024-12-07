package app.backend;

public class BlackjackObjectloader {
	
	private int money;
	private String name;
	
	public BlackjackObjectloader(String name, int money) {
		this.money = money;
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}
	

}
