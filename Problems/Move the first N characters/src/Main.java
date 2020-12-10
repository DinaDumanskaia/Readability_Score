import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] arrayFromInputLine = inputLine.split(" ");
        String word = arrayFromInputLine[0];
        int number = Integer.parseInt(arrayFromInputLine[1]);
        if (number < word.length()) {
            String shiftedPart = word.substring(0, number);
            String leaderPart = word.substring(number);
            System.out.println(leaderPart + shiftedPart);
        } else {
            System.out.println(word);
        }
    }
}