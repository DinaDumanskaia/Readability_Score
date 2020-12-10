import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String m = scanner.nextLine();
        String[] inputs = m.split("\\s");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(inputs[i]));
        }
        boolean isOrdered = checkIsOrdered(numbers);
        System.out.println(isOrdered);
    }

    private static boolean checkIsOrdered(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
