import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineOfTicketNumbers = scanner.nextLine();
        String[] splitedLineToNumbers = lineOfTicketNumbers.split("");
        compareSummFirstThreeAndNextThree(splitedLineToNumbers);
    }

    private static void compareSummFirstThreeAndNextThree(String[] splitedLineToNumbers) {
        int sumOfFirstThree = Integer.parseInt(splitedLineToNumbers[0]) 
            + Integer.parseInt(splitedLineToNumbers[1]) 
            + Integer.parseInt(splitedLineToNumbers[2]);
        int sumOfSecondThree = Integer.parseInt(splitedLineToNumbers[3]) 
            + Integer.parseInt(splitedLineToNumbers[4]) 
            + Integer.parseInt(splitedLineToNumbers[5]);
        if (sumOfFirstThree == sumOfSecondThree) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
