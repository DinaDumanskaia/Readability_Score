import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] arrayOfLetters = inputLine.split("");
        String theLetter;
        int theNextIndex;
        StringBuilder compression = new StringBuilder();
        if (!inputLine.isEmpty()) {
            theLetter = arrayOfLetters[0];
            int amount = 1;
            if (arrayOfLetters.length > 1) {
                for (theNextIndex = 1; theNextIndex < arrayOfLetters.length; theNextIndex++) {
                    if (theLetter.equals(arrayOfLetters[theNextIndex])) {
                        amount++;
                    } else {
                        compression.append(theLetter).append(amount);
                        theLetter = arrayOfLetters[theNextIndex];
                        amount = 1;
                    }
                }
            }
            compression.append(theLetter).append(amount);
            System.out.println(compression);
        }
    }
}
