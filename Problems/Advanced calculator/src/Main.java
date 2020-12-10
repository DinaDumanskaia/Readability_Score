import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
//        printArgs(args);
        String operator = args[0];
        //разделяем строку
//        String[] fromOperator = operator.split("\\s");
        //берем слово, которое обозначает действие, которое необходимо произвести с массивом
//        String action = fromOperator[0];
        //строки преобразуем в числа и создаем лист из полученных чисел
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            numbers.add(Integer.parseInt(args[i]));
        }
        //создаем три метода для MAX MIN SUM соответсвенно
        if ("MAX".equals(operator)) {
            getMax(numbers);
        } else if ("MIN".equals(operator)) {
            getMin(numbers);
        } else {
            getSum(numbers);
        }
    }

    private static void getMax(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println(max);
    }

    private static void getMin(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        System.out.println(min);
    }

    private static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}