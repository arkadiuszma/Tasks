package NumberChoosingGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(100);
        for (int i = 1; i <= MAX_TRIES; i++) {
            int userNumber = getValidNumberFromUser();
            if (numberToGuess == userNumber) {
                System.out.println("You guessed it!");
                return;
            }
            if (i == MAX_TRIES) {
                System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
                return;
            }
            printHint(MAX_TRIES - i, numberToGuess < userNumber ? "GREATER" : "LOWER");
        }
    }

    private static void printHint(int countTriesToEnd, String hint) {
        System.out.println("Your number is " + hint + " than the one you're trying to guess. You have " + countTriesToEnd + " tries left. Please try again");
    }

    private static int getValidNumberFromUser() {
        System.out.println("Guess number from 0 to 99. Enter it below: ");
        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                int userNumber = s.nextInt();
                if (userNumber < 0 || userNumber > 99) {
                    System.out.println("Number should be from 0 to 99. Please enter correct number: ");
                    continue;
                }
                return userNumber;
            } catch (InputMismatchException e) {
                System.out.println("Number which you entered isn't in correct type. Please try again.");
            }
        }
    }
}