package sddtc.oobootcamp.principle.srp;

import java.util.logging.Logger;

public class Client {
    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        String data = "2019-03-26";
        StringHandler stringHandler = new StringHandler(data);
        stringHandler.convert();

        stringHandler.print();
    }
}
