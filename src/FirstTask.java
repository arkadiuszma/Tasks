import java.util.Random;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(100);
        int i = 0;
        int maxTries = 5;
        do {
            i++;
            int userNumber = getUserNumber();
            int countTriesToEnd = maxTries - i;
            checkNumber(numberToGuess, userNumber, countTriesToEnd);
            infoAfterLoop(numberToGuess, i, maxTries);
        } while (i < maxTries);
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

    private static void infoAfterLoop(int numberToGuess, int i, int maxTries) {
        if (i < maxTries) {
            System.out.println("Please try again");
        } else
            System.out.println("Sorry You didn't guess the number, the answer was: " + numberToGuess);
    }

    private static int getUserNumber() {
        Scanner s = new Scanner(System.in);
        System.out.println("Guess number from 0 to 99. Enter it below: ");
        int userNumber = s.nextInt();
        if (userNumber < 0 || userNumber > 99) {
            System.out.println("Number should be from 0 to 99. Please enter correct number: ");
            getUserNumber();
        }
        return userNumber;
    }
}