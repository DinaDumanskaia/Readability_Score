import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        readTheInput();
    }

    public static void readTheInput() {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        String numbersInArray = scanner.nextLine();
        int numberToFindInArray = Integer.parseInt(scanner.nextLine());

        int[] homeArray = makeAnArrayFromString(firstNumber, numbersInArray);
        boolean isTheNumberOnTheList = findACurrentNumber(numberToFindInArray, homeArray);
        System.out.println(isTheNumberOnTheList);
    }

    private static boolean findACurrentNumber(int numberToFindInArray, int[] homeArray) {
        for(int i = 0; i < homeArray.length; i++) {
            if (homeArray[i] == numberToFindInArray) {
                return true;
            }
        }
        return false;
    }

    private static int[] makeAnArrayFromString(int firstNumber, String numbersInArray) {
        int[] inputArray = new int[firstNumber];
        String[] arrOfStr = numbersInArray.split(" ");
        for(int i = 0; i < inputArray.length; i++) {
            inputArray[i] = Integer.parseInt(arrOfStr[i]);
        }
        return inputArray;
    }

}