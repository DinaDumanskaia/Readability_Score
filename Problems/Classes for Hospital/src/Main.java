class Person {
    public static void main(String[] args) {
        String s = "ten";            // 1
        int n = Integer.parseInt(s); // 2
        System.out.println(n);       // 3
        n += 20;                     // 4
        System.out.println(n);
    }
}

class Employee extends Person {

}

class Doctor extends Employee {

}

class Patient extends Person {

}
