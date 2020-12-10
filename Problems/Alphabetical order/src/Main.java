import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringArray = scanner.nextLine().split(" ");
//        System.out.println("abc".compareTo("acd")); // -1 "abc" < "acd"
//        System.out.println("abc".compareTo("aac")); //  1 "abc" > "aac"
//        System.out.println("abc".compareTo("abc")); //  0 "abc" = "abc"
        String stringToCompareWith = stringArray[0];
        boolean isCorrectOrder = true;
        if (stringArray.length > 1) {
            for (int i = 1; i < stringArray.length; i++) {
                if (stringArray[i].compareTo(stringToCompareWith) < 0) {
                    isCorrectOrder = false;
                    break;
                } else {
                    stringToCompareWith = stringArray[i];
                }
            }
            System.out.println(isCorrectOrder);
        } else {
            System.out.println("true");
        }
    }
}
