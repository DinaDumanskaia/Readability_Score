import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //считываем данные
        String length = scanner.nextLine();
        String array = scanner.nextLine();
        String numbers = scanner.nextLine();

        //преобразуем данные
        String[] nArray = array.split(" ");
        String[] twoNumbers = numbers.split(" ");
        //получаем два читсла, кототорые нудно найти рядом
        int a = Integer.parseInt(twoNumbers[0]);
        int b = Integer.parseInt(twoNumbers[1]);

        //записываем числа из второй сторки в Лист
        List<Integer> list = new ArrayList<>();
        for (String s : nArray) {
            int newN = Integer.parseInt(s);
            list.add(newN);
        }

        //пишем метод, которые будет возвращать булин
        System.out.println(isNextToEachOther(a, b, list));

    }

    private static boolean isNextToEachOther(int a, int b, List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i) == a && list.get(i - 1) == b) || (list.get(i) == b && list.get(i - 1) == a)) {
                return true;
            }
        }
        return false;
    }
}