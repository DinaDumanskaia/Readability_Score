import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        String[] fileOne = f1.toString().split("/");
        String[] fileTwo = f2.toString().split("/");
        return fileOne[0].equals(fileTwo[0]);
    }
}