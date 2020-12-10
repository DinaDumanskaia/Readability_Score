import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] lineNumbers = inputLine.split("\\s+");
        int q = Integer.parseInt(lineNumbers[0]);
        int w = Integer.parseInt(lineNumbers[1]);
        int e = Integer.parseInt(lineNumbers[2]);
        int r = Integer.parseInt(lineNumbers[3]);
        System.out.println(q);
        System.out.println(w);
        System.out.println(e);
        System.out.println(r);
    }
}