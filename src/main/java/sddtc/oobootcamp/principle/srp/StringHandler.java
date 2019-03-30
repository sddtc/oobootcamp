package sddtc.oobootcamp.principle.srp;

public class StringHandler {
    private String input;
    private String result;

    public StringHandler(String input) {
        this.input = input;
    }

    public String convert() {
        if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
            result = input.replaceAll("-", "");
            return result;
        }
        return null;
    }

    public void print() {
        System.out.println(result);
    }
}
