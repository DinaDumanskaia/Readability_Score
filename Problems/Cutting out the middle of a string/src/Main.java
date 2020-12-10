import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        int halfLengthOfTheLine = inputLine.length() / 2;
        String firstPart;
        String secondPart = inputLine.substring(halfLengthOfTheLine + 1);
        if (inputLine.length() % 2 == 0) {
            firstPart = inputLine.substring(0, halfLengthOfTheLine - 1);
        } else {
            firstPart = inputLine.substring(0, halfLengthOfTheLine);
        }
        System.out.println(firstPart + secondPart);
    }
}