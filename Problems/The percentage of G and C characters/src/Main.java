import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lettersFromTheInputLine = scanner.nextLine().split("");
        int cgAmount = countTheAmoungOfCGLetters(lettersFromTheInputLine);
        double percentage  = (double)cgAmount / lettersFromTheInputLine.length * 100;System.out.println(percentage);
    }

    private static int countTheAmoungOfCGLetters(String[] lettersFromTheInputLine) {
        int counter = 0;
        for (String s : lettersFromTheInputLine) {
            if ("c".equals(s.toLowerCase()) || "g".equals(s.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }
}