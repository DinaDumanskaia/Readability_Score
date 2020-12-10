import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        scanner.close();

        int ax = Integer.parseInt(line1[0]);
        int ay = Integer.parseInt(line1[1]);
        int bx = Integer.parseInt(line2[0]);
        int by = Integer.parseInt(line2[1]);

        double cos = (ax * bx + ay * by) / (Math.sqrt(ax * ax + ay * ay) * Math.sqrt(bx * bx + by * by));
        double arccos = Math.acos(cos);
        System.out.println(Math.toDegrees(arccos));
    }
}