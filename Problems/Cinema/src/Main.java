import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //получаем из первой строки ввода координаты для матрицы
        String yxString = scanner.nextLine();
        String[] coordinates = yxString.split(" ");
        int rows = Integer.parseInt(coordinates[0]);
        int seatsCount = Integer.parseInt(coordinates[1]);

        //считываем и сохраняем строки в List
        List<String> inputYLines = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            inputYLines.add(scanner.nextLine());
        }

        //считываем и сохраняем число билетов k
        int k = Integer.parseInt(scanner.nextLine());

        //проверяем, есть ли нужное количество ноликов построчно
        int freeRow = checkEmptySeats(rows, k, inputYLines);
        System.out.println(freeRow);
    }

    private static int checkEmptySeats(int rows, int k, List<String> inputYLines) {
        int freeRow = 0;
        for (int choosenRow = 0; choosenRow < rows; choosenRow++) {
            String[] line = inputYLines.get(choosenRow).split(" ");
            boolean isItAFreeRow = checkTheFreeRow(line, k);
            if (isItAFreeRow) {
                freeRow = choosenRow + 1;
                break;
            }
        }
        return freeRow;
    }

    private static boolean checkTheFreeRow(String[] line, int k) {
        int counter = 0;
        for (String s : line) {
            if (counter < k) {
                if (s.equals("0")) {
                    counter++;
                } else {
                    counter = 0;
                }
            } else {
                break;
            }
        }
        return counter == k;
    }
}