import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        //переписала массив в лист
        List<Integer> numbersFromArray = new ArrayList<>();
        for (int j : numbers) {
            numbersFromArray.add(j);
        }
        //взять элемент, сравнить с мах, сохранить его индекс
        int min;
        int counter = 0;
        List<Integer> newOrder = new ArrayList<>();
        while (!numbersFromArray.isEmpty()) {
            min = Integer.MAX_VALUE;
            for (int u = 0; u < numbersFromArray.size(); u++) {
                if (numbersFromArray.get(u) < min) {
                    min = numbersFromArray.get(u);
                    counter = u;
                }
            }
            newOrder.add(min);
            numbersFromArray.remove(counter);
        }

        Object[] array = newOrder.toArray();

        for (int index = 0; index < array.length; index++) {
            numbers[index] = (Integer) array[index];
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
