import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        char[] arrayOfSymbols = inputLine.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (char symbol : arrayOfSymbols) {
            newString.append(symbol).append(symbol);
        }
        System.out.println(newString.toString());
    }
}