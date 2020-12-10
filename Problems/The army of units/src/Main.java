import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfUnits = scanner.nextInt();
        System.out.println(callTheUnit(numberOfUnits));
    }

    private static String callTheUnit(int n) {
        String nameOfTheUnit = null;
        if (n < 1) {
            nameOfTheUnit = "no army";
        } else if (n <= 19) {
            nameOfTheUnit = "pack";
        } else if (n <= 249) {
            nameOfTheUnit = "throng";
        } else if (n <= 999) {
            nameOfTheUnit = "zounds";
        } else {
            nameOfTheUnit = "legion";
        }
        return nameOfTheUnit;
    }
}