import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String s = "";
        while (!"0".equals(s)) {
            s = scanner.nextLine();
            input.add(s);
        }
        input.remove(input.size() - 1);
        for (String value : input) {
            try {
                System.out.println(Integer.parseInt(value) * 10);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + value);
            }
        }
    }
}
