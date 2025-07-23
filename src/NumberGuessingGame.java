

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game statistics
        int roundsPlayed = 0;
        int roundsWon = 0;
        int bestScore = Integer.MAX_VALUE;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            // Game setup
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            final int MAX_ATTEMPTS = 10;
            boolean guessedCorrectly = false;

            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            // Guessing loop
            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("\nAttempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ". Enter your guess: ");

                // Validate input
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Clear invalid input
                    System.out.print("Enter your guess: ");
                }

                int guess = scanner.nextInt();
                attempts++;

                // Validate guess range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                // Evaluate guess
                if (guess == secretNumber) {
                    System.out.println("\n🎉 Correct! You guessed the number in " + attempts + " attempt" + (attempts > 1 ? "s" : "") + "!");
                    guessedCorrectly = true;
                    roundsWon++;

                    // Update best score
                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                } else if (guess < secretNumber) {
                    System.out.println("⬆️ Too low! Try a higher number.");
                } else {
                    System.out.println("⬇️ Too high! Try a lower number.");
                }
            }

            // Handle loss
            if (!guessedCorrectly) {
                System.out.println("\n💥 Game over! The number was " + secretNumber + ". You've used all your attempts.");
            }

            // Play again prompt
            System.out.print("\nPlay another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            while (!playAgain.equals("yes") && !playAgain.equals("no") &&
                    !playAgain.equals("y") && !playAgain.equals("n")) {
                System.out.println("Please enter 'yes' or 'no'.");
                System.out.print("Play another round? (yes/no): ");
                playAgain = scanner.next().toLowerCase();
            }

            if (playAgain.equals("no") || playAgain.equals("n")) {
                break;
            }
        }

        // Display final statistics
        System.out.println("\n========== Game Results ==========");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);

        if (roundsWon > 0) {
            double winRate = (double) roundsWon / roundsPlayed * 100;
            System.out.printf("Win rate: %.1f%%\n", winRate);
            System.out.println("Best score: " + bestScore + " attempt" + (bestScore > 1 ? "s" : ""));
        } else {
            System.out.println("Best score: N/A");
        }

        System.out.println("\nThanks for playing! Goodbye 👋");
        scanner.close();
    }
}