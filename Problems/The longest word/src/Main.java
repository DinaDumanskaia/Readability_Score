import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordsOfTheInputLine = scanner.nextLine().split(" ");
        String theLongest = "";
        for (int i = 0; i < wordsOfTheInputLine.length; i++) {
            if (wordsOfTheInputLine[i].length() > theLongest.length()) {
                theLongest = wordsOfTheInputLine[i];
            }
        }
        System.out.println(theLongest);
    }
}