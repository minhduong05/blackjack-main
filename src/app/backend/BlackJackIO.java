package app.backend;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BlackJackIO implements BlackJackIOInterface {

    @Override
    public void save(String filename, String name, int money) throws IOException {
        PrintWriter writer = new PrintWriter(filename);

        String s = String.format("%s,%d", name, money);

        writer.print(s);

        writer.flush();
        writer.close();
    }

    @Override
    public BlackJackObjectloader load(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));

        String[] person = scanner.nextLine().split(",");
        scanner.close();

        BlackJackObjectloader loader = new BlackJackObjectloader(person[0], Integer.parseInt(person[1]));

        return loader;
    }
}
