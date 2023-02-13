package FirstWeek;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TokenGenerator {
    public static void main(String[] args) {
        int numberOfChars = getCharactersNumber();
        String token = tokenGenerator(numberOfChars);
        System.out.println(token);
    }

    private static int getCharactersNumber() {
        System.out.println("Choose number of chars in token from 5, 10 or 15: ");
        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                int numberOfChars = s.nextInt();
                switch (numberOfChars) {
                    case 5, 10, 15 -> {
                        return numberOfChars;
                    }
                    default ->
                            System.out.println("Number you entered isn't equal 5, 10 or 15. Please enter correct number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Number which you entered isn't in correct type. Please try again.");
            }
        }
    }

    private static int validCharactersNumber() {
        while (true) {
            int randomNumber = new Random().nextInt(90) + 33;
            if (randomNumber == 33 || 35 <= randomNumber && randomNumber <= 38 || 40 <= randomNumber && randomNumber <= 42 || 48 <= randomNumber && randomNumber <= 57 ||
                    64 <= randomNumber && randomNumber <= 90 || randomNumber == 94 || randomNumber >= 97) {
                return randomNumber;
            }
        }
    }

    private static String tokenGenerator(int numberOfChars) {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < numberOfChars; i++) {
            int randomNumber = validCharactersNumber();
            char b = (char) randomNumber;
            characters.add(b);
        }
        StringBuilder token = new StringBuilder(characters.size());
        for (Character ch : characters) {
            token.append(ch);
        }
        return token.toString();
    }
}