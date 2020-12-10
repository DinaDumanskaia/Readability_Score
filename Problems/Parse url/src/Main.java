import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splittedURL = scanner.nextLine().split("\\?");
        String[] splittedSecondPartOfURLLine = splittedURL[1].split("&");
        String ifPassExists = null;
        for (String s : splittedSecondPartOfURLLine) {
            String[] smallLineOfWordAndNumber = s.split("=");
            String word = smallLineOfWordAndNumber[0];
            String number;
            if (smallLineOfWordAndNumber.length > 1) {
                number = s.split("=")[1];
            } else {
                number = "not found";
            }
            System.out.println(word + " : " + number);
            if ("pass".equals(word)) {
                ifPassExists = "password : " + number;
            }
        }
        if (ifPassExists != null) {
            System.out.println(ifPassExists);
        }
    }
}
