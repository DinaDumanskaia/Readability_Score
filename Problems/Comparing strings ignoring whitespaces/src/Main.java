import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine().replaceAll("\\s", "");
        String secondLine = scanner.nextLine().replaceAll("\\s", "");

        System.out.println(firstLine.equals(secondLine));

    }
}
