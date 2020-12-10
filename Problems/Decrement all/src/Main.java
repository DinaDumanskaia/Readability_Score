import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //сохраяем строку в массив строк методом split
        String[] input = scanner.nextLine().split(" ");
        //зная, что у нас всего 4 числа в строке, высчитваем каждое из чисел
        int n1 = Integer.parseInt(input[0]) - 1;
        int n2 = Integer.parseInt(input[1]) - 1;
        int n3 = Integer.parseInt(input[2]) - 1;
        int n4 = Integer.parseInt(input[3]) - 1;

        //выводим числа на экран в прямой последовательности
        System.out.println(n1 + " " + n2 + " " + n3 + " " + n4);
    }
}