import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = b1 || b2;
        System.out.println(b1 && !b2 && b3);
    }

}