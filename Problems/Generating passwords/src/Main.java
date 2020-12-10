import java.util.*;

public class Main {
    public static final String ADDITIONAL_BIG_LETTER = "A";
    public static final String ADDITIONAL_BIG_LETTER_ADDITIONAL = "V";
    public static final String ADDITIONAL_SMALL_LETTER = "a";
    public static final String ADDITIONAL_DIGIT = "1";
    public static final String BIG_LETTERS_FILLER = "AB";
    public static final String BIG_LETTERS_FILLER_ADDITIONAL = "CS";
    public static final String SMALL_LETTERS_FILLER = "ab";
    public static final String DIGITS_FILLER = "12";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        int bigLettersCount = Integer.parseInt(numbers[0]);
        int smallLettersCount = Integer.parseInt(numbers[1]);
        int numbersCount = Integer.parseInt(numbers[2]);
        int requiredPasswordSize = Integer.parseInt(numbers[3]);

        StringBuilder password = new StringBuilder();

        password.append(createMinimalPart(bigLettersCount, smallLettersCount, numbersCount));
        password.append(createAdditionalPart(requiredPasswordSize, password.length()));

        System.out.println(password);
    }

    protected static String createAdditionalPart(int n, int passwordLength) {
        String retVal = "";
        if (passwordLength != n) {
            int lettersLeft = n - passwordLength;
            retVal = createPart(lettersLeft, BIG_LETTERS_FILLER_ADDITIONAL, ADDITIONAL_BIG_LETTER_ADDITIONAL).toString();
        }
        return retVal;
    }

    protected static String createMinimalPart(int bigLettersCount, int smallLettersCount, int numbersCount) {
        return String.valueOf(createPart(bigLettersCount, BIG_LETTERS_FILLER, ADDITIONAL_BIG_LETTER)) +
                createPart(smallLettersCount, SMALL_LETTERS_FILLER, ADDITIONAL_SMALL_LETTER) +
                createPart(numbersCount, DIGITS_FILLER, ADDITIONAL_DIGIT);
    }


    private static StringBuilder createPart(int size, String template, String additional) {
        StringBuilder bigLetters = new StringBuilder();

        if (size != 0) {
            for (int i = 0; i < size / 2; i++) {
                bigLetters.append(template);
            }
            if (size % 2 != 0) {
                bigLetters.append(additional);
            }
        }
        return bigLetters;
    }
}