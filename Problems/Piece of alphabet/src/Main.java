import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Scanner scanner = new Scanner(System.in);
        char[] formTheInput = scanner.nextLine().toCharArray();
        int counter = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (formTheInput[0] == alphabet[i]) {
                counter = i;
                break;
            }
        }
        boolean isItAMatch = true;
        for (int i = 1; i < formTheInput.length; i++) {
            if (formTheInput[i] == alphabet[counter + 1]) {
                counter++;
            } else {
                isItAMatch = false;
            }
        }
        System.out.println(isItAMatch);
    }
}
