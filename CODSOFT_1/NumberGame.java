/* 

Task1:NUMBER GAME

1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.
*/

/* 
5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the  rounds won.
*/

/*Please note i am choosing based on rounds won */

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int roundsWon = 0;
        int totalRounds = 0;

        while (playAgain) {
            int number = random.nextInt(100) + 1;
            int numberOfGuesses = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            totalRounds++;

            System.out.println("Welcome to Round " + totalRounds + " of the Number Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");
            System.out.println("You have a maximum of " + maxAttempts + " attempts.\n");

            while (numberOfGuesses < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                numberOfGuesses++;
                
                if (guess > number) {
                    System.err.println("Oops! Too high. Try a lower number.\n");
                } else if (guess < number) {
                    System.err.println("Oops! Too low. Try a higher number.\n");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfGuesses + " attempts.\n");
                    guessedCorrectly = true;
                    roundsWon++;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + number + ".\n");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");

            System.out.println();
        }

        System.out.println("Thank you for playing!");
        System.out.println("You won " + roundsWon + " out of " + totalRounds + " rounds.");
        sc.close();
    }
}
