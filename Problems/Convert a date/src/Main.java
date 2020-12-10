import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] arrayFromInputLine = inputLine.split("-");
        String result = arrayFromInputLine[1] + "/" + arrayFromInputLine[2] + "/" + arrayFromInputLine[0];
        System.out.println(result);
    }
}