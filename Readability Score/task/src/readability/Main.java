package readability;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Math.max;
import static java.lang.Math.scalb;

public class Main {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
    public static int sumOfAge = 0;
    public static String line = "";
    public static void main(String[] args) {


        try{
            line = readFileAsString(args[0]);
            final String line2 = line;
            int wordCount = line.split("\\s+").length; // liczenie slow
            System.out.println("Words: " + wordCount);
            int sentenceCount = line.split("[.!?]").length; // liczenie zdan
            System.out.println("Sentences: " + sentenceCount);
            line = line.replaceAll("\\s+",""); // zamiana spacji na ich brak
            int charactersCount = line.split("").length; // liczenie znakow
            System.out.println("Characters: " + charactersCount);
            //////////////////////////////////////////////////////
            line = line.replaceAll("e\\b","").replaceAll("you", "a").replaceAll("[aeiouy]{2}", "a").replaceAll(" th "," a ").replaceAll(",","").replaceAll(" w "," a ").replaceAll("[0-9]+", "a").replaceAll("[^aeiouy]", "");
            int syllablesCount = line.length();
            System.out.println("Syllables: " + syllablesCount);
            int polysyllableCount = 0;
            String[] parts = line2.split("\\s+");
            for (int i = 0; i < parts.length; i++) {
                if (isPolysyllable(parts[i])) {
                    polysyllableCount++;
                }
            }
            System.out.println("Polysyllables: " + polysyllableCount);
            //////////////////////////////////////////////////////////
            System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            Scanner scanner = new Scanner(System.in);
            String function = scanner.next();
            //////////////////////////////////////////////////////////
            switch(function) {
                case "ARI":
                    double score = (4.71 * ((double)charactersCount/(double)wordCount)) + (0.5 * ((double)wordCount/(double)sentenceCount)) - 21.43;
                    System.out.print("Automated Readability Index: " + Math.round(score));
                    switches(score);
                    break;
                case "FK":
                    System.out.println("");
                    double flesch = (0.39 * ((double)wordCount/(double)sentenceCount)) + (11.8 * ((double)syllablesCount/(double)wordCount)) - 15.59;
                    System.out.print("Flesch–Kincaid readability tests: " + Math.round(flesch));
                    switches(flesch);
                    break;
                case "SMOG":
                    System.out.println("");
                    double gobbledygook = 1.043 * (Math.sqrt((polysyllableCount * (30/sentenceCount))) + 3.1291);
                    System.out.print("Simple Measure of Gobbledygook: " + Math.round(gobbledygook));
                    gobbledygook = Math.round(gobbledygook);
                    switches(gobbledygook);
                    break;
                case "CL":
                    System.out.println("");
                    double coleman = (0.0588 * (((double)charactersCount/(double)wordCount) * 100)) - (0.296 * (((double)sentenceCount/(double)wordCount) * 100)) - 15.8;
                    System.out.print("Coleman–Liau index: " + Math.round(coleman));
                    coleman = Math.round(coleman);
                    switches(coleman);
                    break;
                case "all":
                    // ARI
                    score = (4.71 * ((double)charactersCount/(double)wordCount)) + (0.5 * ((double)wordCount/(double)sentenceCount)) - 21.43;
                    System.out.print("Automated Readability Index: " + Math.round(score));
                    switches(score);
                    //Flesch
                    System.out.println("");
                    flesch = (0.39 * ((double)wordCount/(double)sentenceCount)) + (11.8 * ((double)syllablesCount/(double)wordCount)) - 15.59;
                    System.out.print("Flesch–Kincaid readability tests: " + Math.round(flesch));
                    switches(flesch);
                    //SMOG
                    System.out.println("");
                    gobbledygook = 1.043 * (Math.sqrt((polysyllableCount * (30/sentenceCount))) + 3.1291);
                    System.out.print("Simple Measure of Gobbledygook: " + Math.round(gobbledygook));
                    gobbledygook = Math.round(gobbledygook);
                    switches(gobbledygook);
                    //Coleman
                    System.out.println("");
                    coleman = (0.0588 * (((double)charactersCount/(double)wordCount) * 100)) - (0.296 * (((double)sentenceCount/(double)wordCount) * 100)) - 15.8;
                    System.out.print("Coleman–Liau index: " + Math.round(coleman));
                    coleman = Math.round(coleman);
                    switches(coleman);
                    break;
            }

            System.out.println("\nThis text should be understood in average by " + sumOfAge +"-year-olds.");
        }
        catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }

    }
    public static int countSyllables(final String word) {
        return max(1, word.toLowerCase()
                .replaceAll("e$", "")
                .replaceAll("[aeiouy]{2}", "a")
                .replaceAll("[^aeiouy]", "")
                .length());
    }
    public static boolean isPolysyllable(final String word) {
        return countSyllables(word) > 2;
    }
    public static void switches(double score) {
        score = Math.ceil(score);
        switch ((int) score) {
            case 1:
                System.out.print(" about 6-year-olds.");
                sumOfAge += 6;
                break;
            case 2:
                System.out.print(" about 7-year-olds.");
                sumOfAge += 7;
                break;
            case 3:
                System.out.print(" about 9-year-olds.");
                sumOfAge += 9;
                break;
            case 4:
                System.out.print(" about 10-year-olds.");
                sumOfAge += 10;
                break;
            case 5:
                System.out.print(" about 11-year-olds.");
                sumOfAge += 11;
                break;
            case 6:
                System.out.print(" about 12-year-olds.");
                sumOfAge += 12;
                break;
            case 7:
                System.out.print(" about 13-year-olds.");
                sumOfAge += 13;
                break;
            case 8:
                System.out.print(" about 14-year-olds.");
                sumOfAge += 14;
                break;
            case 9:
                System.out.print(" about 15-year-olds.");
                sumOfAge += 15;
                break;
            case 10:
                System.out.print(" about 16-year-olds.");
                sumOfAge += 16;
                break;
            case 11:
                System.out.print(" about 17-year-olds.");
                sumOfAge += 17;
                break;
            case 12:
                System.out.print(" about 18-year-olds.");
                sumOfAge += 18;
                break;
            case 13:
                System.out.print(" about 19-year-olds.");
                sumOfAge += 19;
                break;
            case 14:
                System.out.print(" about 20-year-olds+");
                sumOfAge += 20;
                break;
        }
    }


}

