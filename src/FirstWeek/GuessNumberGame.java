package FirstWeek;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        playGame();
    }

    private static void checkNumber(int numberToGuess, int userNumber, int countTriesToEnd) {
        if (numberToGuess == userNumber) {
            System.out.println("You guessed it!");
        } else if (numberToGuess < userNumber) {
            System.out.println("Your number is GREATER than the one you're trying to guess. You have " + countTriesToEnd + " tries left.");
        } else {
            System.out.println("Your number is LOWER than the one you're trying to guess. You have " + countTriesToEnd + " tries left.");
        }
    }

    private static void infoAfterLoop(int numberToGuess, int i, int maxTries, int userNumber) {
        if (i < maxTries && numberToGuess != userNumber) {
            System.out.println("Please try again");
        } else if (i == maxTries) {
            System.out.println("Sorry You didn't guess the number, the answer was: " + numberToGuess);
        }
    }

    private static int getUserNumber() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Guess number from 0 to 99. Enter it below: ");
            return Integer.parseInt(s.nextLine());
        } catch (Exception e) {
            System.out.println("Number which you entered isn't in correct type. Please try again.");
            return getUserNumber();
        }
    }

    private static int numberValidation(int userNumber) {
        if (userNumber < 0 || userNumber > 99) {
            System.out.println("Number should be from 0 to 99. Please enter correct number: ");
            return getUserNumber();
        } else {
            return userNumber;
        }
    }

    private static void playGame() {
        int numberToGuess = new Random().nextInt(100);
        int i = 0;
        int maxTries = 5;
        int userNumber;
        do {
            i++;
            userNumber = numberValidation(getUserNumber());
            int countTriesToEnd = maxTries - i;
            checkNumber(numberToGuess, userNumber, countTriesToEnd);
            infoAfterLoop(numberToGuess, i, maxTries, userNumber);
        } while (i < maxTries && numberToGuess != userNumber);
    }
}