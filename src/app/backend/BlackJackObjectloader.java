package app.backend;

public class BlackJackObjectloader {

    private int money;
    private String name;

    public BlackJackObjectloader(String name, int money) {
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

