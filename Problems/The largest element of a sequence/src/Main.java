import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfInputNumbers = new ArrayList<>();
        int inputNumber;
        do {
            inputNumber = scanner.nextInt();
            listOfInputNumbers.add(inputNumber);
        } while (inputNumber != 0);
        scanner.close();
        int max = getMax(listOfInputNumbers);
        System.out.println(max);
    }

    private static int getMax(List<Integer> listOfInputNumbers) {
        int minVal = Integer.MIN_VALUE;
        for (Integer listOfInputNumber : listOfInputNumbers) {
            if (listOfInputNumber > minVal) {
                minVal = listOfInputNumber;
            }
        }
        return minVal;
    }
}