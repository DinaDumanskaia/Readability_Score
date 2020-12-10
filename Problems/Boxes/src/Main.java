import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] one = scanner.nextLine().split("\\s");
        String[] two = scanner.nextLine().split("\\s");
        List<Integer> boxOne = new ArrayList<>();
        List<Integer> boxTwo = new ArrayList<>();
        for (int i = 0; i < one.length; i++) {
            boxOne.add(Integer.parseInt(one[i]));
            boxTwo.add(Integer.parseInt(two[i]));
        }

        boxOne.sort(Comparator.comparingInt(element -> element));
        boxTwo.sort(Comparator.comparingInt(el -> el));

        System.out.println(compareCollections(boxOne, boxTwo));
    }

    private static String compareCollections(List<Integer> boxOne, List<Integer> boxTwo) {
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < boxOne.size(); i++) {
            if (boxOne.get(i).equals(boxTwo.get(i))) {
                return "Incompatible";
            } else if (boxOne.get(i) > (boxTwo.get(i))) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        if (list.contains(true) && !list.contains(false)) {
            return "Box 1 > Box 2";
        } else if (list.contains(false) && !list.contains(true)) {
            return "Box 1 < Box 2";
        } else {
            return "Incompatible";
        }
    }
}