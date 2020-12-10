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
        int collum = Integer.parseInt(coordinates[1]);

        //считываем и сохраняем строки в List
        List<String> inputYLines = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            inputYLines.add(scanner.nextLine());
        }

        //идем по линиям и ищем максимальное значение, сохряняя координаты найденных значений
        String greatest = findTheNumber(inputYLines, rows, collum);
        System.out.println(greatest);
    }

    private static String findTheNumber(List<String> inputYLines, int rows, int column) {
        int max = Integer.MIN_VALUE;
        int y = 0;
        int x = 0;
        for (int i = 0; i < rows; i++) {
            //берем первую строку, создаем массив для цифр и записываем в нее числа из строки
            List<Integer> yLine = new ArrayList<>();
            for (int u = 0; u < column; u++) {
                String[] thisLine = inputYLines.get(i).split(" ");
                yLine.add(Integer.parseInt(thisLine[u]));
            }
            //из полученной строки узнаем максимальное значение и сохраняем его координаты
            for (int o = 0; o < column; o++) {
                if (yLine.get(o) > max) {
                    max = yLine.get(o);
                    y = i;
                    x = o;
                }
            }
        }
        return y + " " + x;
    }
}