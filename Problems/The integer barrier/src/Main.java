import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int sc;
        do {
            if (sum >= 1000) {
                break;
            }
            sc = scanner.nextInt();
            sum += sc;
            if (sum >= 1000) {
                break;
            }
        } while (sc != 0);

        if (sum < 1000) {
            System.out.println(sum);
        } else {
            System.out.println(sum - 1000);
        }
    }
}