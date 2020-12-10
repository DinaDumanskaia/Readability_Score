import java.util.*;

public class Main {
    public static Set<Character> vowels = new HashSet<>();
    public static void main(String[] args) {
        prepareVowelsSet();
        Scanner scanner = new Scanner(System.in);
        char[] inputLetters = scanner.nextLine().toLowerCase().toCharArray();
        int vowelsCounter = 0;
        int consonantsCounter = 0;
        int lettersToAddAmount = 0;
        if (inputLetters.length < 3) {
            System.out.println(0);
        } else {
            for (char letters : inputLetters) {
                if (isVowel(letters)) {
                    vowelsCounter++;
                    if (consonantsCounter >= 3) {
                        lettersToAddAmount = getInsideLettersAmount(consonantsCounter, lettersToAddAmount);
                    }
                    consonantsCounter = 0;
                } else {
                    consonantsCounter++;
                    if (vowelsCounter >= 3) {
                        lettersToAddAmount = getInsideLettersAmount(vowelsCounter, lettersToAddAmount);
                    }
                    vowelsCounter = 0;
                }
            }
            int tail = checkTail(consonantsCounter, vowelsCounter);
            System.out.println(lettersToAddAmount + tail);
        }
    }

    static int getInsideLettersAmount(int vowelsCounter, int lettersToAddAmount) {
        lettersToAddAmount += vowelsCounter / 2 - 1;
        if (vowelsCounter % 2 != 0) {
            lettersToAddAmount += 1;
        }
        return lettersToAddAmount;
    }

    private static int checkTail(int consonantsCounter, int vowelsCounter) {
        int tail = 0;
        if (consonantsCounter >= 3) {
            tail = getInsideLettersAmount(consonantsCounter, tail);
        } else if (vowelsCounter >= 3) {
            tail = getInsideLettersAmount(vowelsCounter, tail);
        }
        return tail;
    }

    protected static void prepareVowelsSet() {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
    }

    static boolean isVowel(char letter) {
        return vowels.contains(letter);
    }
}