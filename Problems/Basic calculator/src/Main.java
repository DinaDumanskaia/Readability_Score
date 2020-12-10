class Problem {

    public static void main(String[] args) {
        String simbol = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        if ("+".equals(simbol)) {
            System.out.println(a + b);
        } else if ("-".equals(simbol)) {
            System.out.println(a - b);
        } else if ("*".equals(simbol)) {
            System.out.println(a * b);
        } else {
            System.out.println("Unknown operator");
        }
    }
}