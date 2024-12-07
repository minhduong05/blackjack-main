package app.backend;

import java.io.IOException;

public interface BlackJackIOInterface {

    void save(String filename, String name, int money) throws IOException;

    BlackJackObjectloader load(String filename) throws IOException;

}
