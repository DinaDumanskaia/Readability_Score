import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arrayFromTheInputLine = scanner.nextLine().toCharArray();
        int counter = -1;
        if (arrayFromTheInputLine.length >= "the".length()) {
            for (int i = 0; i < arrayFromTheInputLine.length - 2; i++) {
                if (Character.toLowerCase(arrayFromTheInputLine[i]) == 't') {
                    if (Character.toLowerCase(arrayFromTheInputLine[i + 1]) == 'h') {
                        if (Character.toLowerCase(arrayFromTheInputLine[i + 2]) == 'e') {
                            counter = i;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}