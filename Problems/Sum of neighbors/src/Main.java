import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Main {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static List<String> generateTable(int size) {
        List<String> retVal = new ArrayList<>();


        for (int i = 0; i < size; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < size; j++) {
                sb.append(RANDOM.nextInt());
                if (j < size - 1) {
                    sb.append(" ");
                } else {
                    //sb.append("\n");
                }
            }
            retVal.add(sb.toString());
        }
        return retVal;
    }

    public static void main(String[] args) {
            List<String> linesWithNumbers = readTheInput();
            if (linesWithNumbers.isEmpty()) {
                return;
            }
            //распарсить строки и внести числовые значения в массив
            int[][] tableNeighbors = fillTheTable(linesWithNumbers);
            //пересчитываем массив
            int[][] newTable = reorganizeTable(tableNeighbors);
            //распечатываем новую таблицу
            printNewTable(newTable);
    }

    private static void printNewTable(int[][] newTable) {
        for (int[] ints : newTable) {
            for (int x = 0; x < newTable[0].length; x++) {
                if (x != newTable[0].length - 1) {
                    System.out.print(ints[x] + " ");
                } else {
                    System.out.println(ints[x]);
                }
            }
        }
    }

    protected static int[][] fillTheTable(List<String> linesWithNumbers) {
        //создаем массив, в который будем записывать числа
        int size = linesWithNumbers.size();
        int[][] tableNeighbors = new int[size][];
        for (int y = 0; y < size; y++) {
            String[] numbers = linesWithNumbers.get(y).split(" ");
            tableNeighbors[y] = new int[numbers.length];
            for (int x = 0; x < numbers.length; x++) {
                tableNeighbors[y][x] = Integer.parseInt(numbers[x]);
            }
        }
        return tableNeighbors;
    }

    protected static List<String> readTheInput() {
        List<String> listOfInputLines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        do {
            inputLine = scanner.nextLine();
            if (!inputLine.trim().isEmpty()) {
                listOfInputLines.add(inputLine);
            }
        } while (!inputLine.equals("end"));
        listOfInputLines.remove(listOfInputLines.size() - 1);
        return listOfInputLines;
    }

    private static int[][] reorganizeTable(int[][] s) {
        int height = s.length;
        int width = s[0].length;
        //создаем массив, который будем заполняться новыми значениями
        int[][] newTable = new int[height][width];
        //
        //прописываем соседей чисел, чтобы подходило всем елементам
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int t = countTheBottom(x, y, s, width, height);
                int b = countTheTop(x, y, s, width, height);
                int l = countTheLeft(x, y, s, width, height);
                int r = countTheRight(x, y, s, width, height);
                newTable[y][x] = t + b + l + r;
            }
        }
        return newTable;
    }

    private static int countTheRight(int x, int y, int[][] s, int width, int height) {
        int result;
        if (x == width - 1) {
            result = s[y][0];
        } else {
            result = s[y][x + 1];
        }
        return result;
    }

    private static int countTheLeft(int x, int y, int[][] s, int width, int height) {
        int result;
        if (x == 0) {
            result = s[y][width - 1];
        } else {
            result = s[y][x - 1];
        }
        return result;
    }

    private static int countTheTop(int x, int y, int[][] s, int width, int height) {
        int result;
        if (y == 0) {
            result = s[height - 1][x];
        } else {
            result = s[y - 1][x];
        }
        return result;
    }

    private static int countTheBottom(int x, int y, int[][] s, int width, int height) {
        int result;
        if (y == height - 1) {
            result = s[0][x];
        } else {
            result = s[y + 1][x];
        }
        return result;
    }

}
