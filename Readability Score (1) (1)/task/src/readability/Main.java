package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final Map<Integer, Integer> ARI_TO_AGE_MAP = new HashMap<>();
    private static final int ARI_SPECIAL_CASE = Integer.MIN_VALUE;

    static {
        ARI_TO_AGE_MAP.put(1, 6);
        ARI_TO_AGE_MAP.put(2, 7);
        ARI_TO_AGE_MAP.put(3, 9);
        ARI_TO_AGE_MAP.put(4, 10);
        ARI_TO_AGE_MAP.put(5, 11);
        ARI_TO_AGE_MAP.put(6, 12);
        ARI_TO_AGE_MAP.put(7, 13);
        ARI_TO_AGE_MAP.put(8, 14);
        ARI_TO_AGE_MAP.put(9, 15);
        ARI_TO_AGE_MAP.put(10, 16);
        ARI_TO_AGE_MAP.put(11, 17);
        ARI_TO_AGE_MAP.put(12, 18);
        ARI_TO_AGE_MAP.put(13, 24);
    }

    public static char[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'y'};
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        readTheTextAndAnaliseIt(fileName);
    }

    private static void readTheTextAndAnaliseIt(String fileName) throws FileNotFoundException {

        //берем название файла и создаем объект типа File
        File file = new File(fileName);
        //считываем файл
        Scanner scanner = new Scanner(file);

        //сохраняем все строки текста в лист
        StringBuilder text = new StringBuilder();
        while (scanner.hasNext()) {
            text.append(scanner.nextLine());
        }
        scanner.close();

        String sentence = text.toString();
        System.out.println(sentence);
        String[] ourText = sentence.split(" ");
        //считаем количество предложений
        int sentences = countSentences(sentence);
        //считаем количество слов
        int words = countWords(sentence);
        //считаем количество символов
        int symbols = countSymbols(sentence);
        //считаем количество слогов в одном слове
//        int syllablesInOneWord = countSyllablesInOneWord(ourText[0]);
        //считаем слоги во всем тексте
        int syllables = countSyllables(ourText);
        //считаем многослоговые :)) слова
        int polysyllables = countPolysyllables(ourText);

        //считаем ARI Automated Readability Index
        double ARIDouble = 4.71 * (double)symbols / words + 0.5 * (double)words / sentences - 21.43;
        String ARIString = String.format("%4.2f", ARIDouble).replace(',', '.');
        //считаем FK Flesch–Kincaid readability tests
        double FKDouble = 0.39 * (double)words / sentences + 11.8 * (double)syllables / words - 15.59;
        String FKString =  String.format("%4.2f", FKDouble).replace(',', '.');
        //считаем SMOG Simple Measure of Gobbledygook
        double SMOGDouble = 1.043 * Math.sqrt(polysyllables * (double)30 / sentences) + 3.1291;
        String SMOGString = String.format("%4.2f", SMOGDouble).replace(',', '.');
        //считаем CL Coleman–Liau index
        double L = (double) symbols / words * 100;
        double S = (double) sentences / words * 100;
        double CLDouble = 0.0588 * L - 0.296 * S - 15.8;
        String CLString = String.format("%4.2f", CLDouble).replace(',', '.');
        //выводим данные на экран
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + symbols);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);

        //сдесь читаем со сканнера, что нужно вывести на экран ARI, FK, SMOG, CL, all
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        Scanner scanner1 = new Scanner(System.in);
        String input = scanner1.nextLine();
        int ARI1;
        int FK1;
        int SMOG1;
        int CL1;

        switch (input) {
            case "ARI":
                System.out.print("Automated Readability Index: " + ARIString + findAgeForIndex(ARIDouble));
                break;
            case "FK":
                System.out.print("Flesch–Kincaid readability tests: " + FKString + findAgeForIndex(FKDouble));
                break;
            case "SMOG":
                System.out.print("Simple Measure of Gobbledygook: " + SMOGString + findAgeForIndex(SMOGDouble));
                break;
            case "CL":
                System.out.print("Coleman–Liau index: " + CLString + findAgeForIndex(CLDouble));
                break;
            case "all":
                System.out.print("Automated Readability Index: " + ARIString);
                ARI1 = findAgeForIndex(ARIDouble);
                System.out.print("Flesch–Kincaid readability tests: " + FKString);
                FK1 = findAgeForIndex(FKDouble);
                System.out.print("Simple Measure of Gobbledygook: " + SMOGString);
                SMOG1 = findAgeForIndex(SMOGDouble);
                System.out.print("Coleman–Liau index: " + CLString);
                CL1 = findAgeForIndex(CLDouble);

                double score = (double)(ARI1 + FK1 + SMOG1 + CL1) / 4;
                String scoreStr = String.format("%4.2f", score).replace(',', '.');
                System.out.println();
                System.out.println("This text should be understood in average by " + scoreStr + " year olds.");
                break;
            default:
                System.out.println("Unknown input");
        }
    }

    private static int findAgeForIndex(double indexDouble) {
        int ARI = (int)Math.ceil(indexDouble);
        Integer age = ARI_TO_AGE_MAP.get(ARI);

        if (age != null) {
            System.out.println(" (about " + age + " year olds).");
        } else {
            specialARICase();
            age = ARI_SPECIAL_CASE;
        }
        return age;
    }

    private static void specialARICase() {
        System.out.println("This text should be understood by 24+ year olds.");
    }


    private static int countPolysyllables(String[] text) {
        int counter = 0;
        for (String word : text) {
            int syl = countSyllablesInOneWord(word);
            if (syl > 2) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isVowel(char letter) {
        for (char vowel : VOWELS) {
            if (vowel == letter)
                return true;
        }
        return false;

    }
    private static int countSyllablesInOneWord(String a) {
        int counter = 0;
        boolean isPreviousLetterVowel = false;
        char[] aWord = a.toCharArray();
        for (char c : aWord) {
            if (isVowel(c)) {
                if (!isPreviousLetterVowel) {
                    counter++;
                    isPreviousLetterVowel = true;
                }
            } else {
                isPreviousLetterVowel = false;
            }
        }

        if (aWord[aWord.length - 1] == 'e') {
            counter--;
        }

        return counter > 0 ? counter : 1;
    }

    private static int countSyllables(String[] text) {
        int counter = 0;
        for (String word : text) {
            counter += countSyllablesInOneWord(word);
        }
        return counter;
    }

    private static int countSymbols(String text) {
        int amount = 0;
        char[] letters = text.toCharArray();
        for (char letter : letters) {
            if (' ' != letter && '\t' != letter && '\n' != letter) {
                amount++;
            }
        }
        return amount;
    }

    private static int countWords(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    private static int countSentences(String text) {
        int amount = 0;
        char[] letters = text.toCharArray();
        for (char letter : letters) {
            if (letter == '.' || letter == '!' || letter == '?') {
                amount++;
            }
        }
        if (letters[letters.length - 1] != '.' && letters[letters.length - 1] != '!' && letters[letters.length - 1] != '?') {
            amount++;
        }
        return amount;
    }

}
