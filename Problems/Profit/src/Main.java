import java.util.*;

public class Main {
    public static void main(String[] args) {
        //получаем строку и извлекаем из нее три числа
        Scanner scanner = new Scanner(System.in);
        String[] threeNumbers = scanner.nextLine().split(" ");
        double depositMoney = Double.parseDouble(threeNumbers[0]);
        double percent = Double.parseDouble(threeNumbers[1]);
        double finalSum = Double.parseDouble(threeNumbers[2]);

        int year = 0;
        while (finalSum > depositMoney) {
            depositMoney = getAfterYear(depositMoney, percent);
            year++;
        }

        System.out.println(year);
    }

    private static double getAfterYear(double depositMoney, double percent) {
        return depositMoney * percent / 100 + depositMoney;
    }
}
