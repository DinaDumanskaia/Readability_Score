import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        double a = Double.parseDouble(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        double c = Math.pow(a, b);
        System.out.println(c);
    }
}