/*
You are going to write a word guessing game app in Java. This game is a simpler version of Hangman.

Requirements:

Initialize your array list with the following words:
tree
rain
bear
encourage
promise
soup
chess
insurance
pancakes
stream
When you run the application, randomly choose a word from that list for the user to guess.
For each letter the user guesses wrong, let them know along with how many wrong guesses they have left.
The user is allowed up to 5 wrong guesses. On the 6th wrong guess, they lose the game.
If the user guesses correctly, output the word with the letters they have guessed correctly so far and blanks for
letters they have not guessed yet.
The user can input either a letter or a word for their guess.
If the user guesses the word correctly, output "You've won!" and end the game.
 */

import java.util.Scanner;
public class HangmanArray {

    public static void main (String[] args){

        String[] storedWord = {"tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream"};
        String guessWord;

        String randWord;
        char[] hidden_word;
        Scanner input = new Scanner(System.in);
        String user_guess;
        int missChance = 0;
        char[] missed = new char[6];
        boolean letterFound = false, solved = false;

        System.out.println("Welcome, let's play hangman!");
        System.out.println("Here is the word I am thinking of: _ _ _ _ _ _ _ _ _ ");
        System.out.println("Enter letter or word guess:  \n");

        randWord = storedWord[ (int)(Math.random() * storedWord.length) ];
        hidden_word = new char[randWord.length()];
        for ( int i = 0; i < randWord.length(); i++ )
        {
            hidden_word[i] = '_';
        }

            while (missChance < 5 && !solved) {
                System.out.println("=================================================================\n");
                System.out.println("You have guessed incorrectly " + missChance + "/6" + " times.");
                System.out.print("\nYour guess so far:\t");
                for (int i = 0; i < randWord.length(); i++) {
                    System.out.print(hidden_word[i] + " ");
                }
                System.out.print("\nMissed letters: ");
                for (int i = 0; i < missed.length; i++) {
                    System.out.print(missed[i]);
                }

                System.out.print("\nGuessed letters: ");
                user_guess = input.next();
                letterFound = false;

                for (int i = 0; i < randWord.length(); i++) {
                    if (user_guess.charAt(0) == randWord.charAt(i)) {
                        hidden_word[i] = randWord.charAt(i);
                        letterFound = true;
                    }
                }
                if (!letterFound) {
                    missChance++;
                    missed[missChance] = user_guess.charAt(0);
                }

                int hidden_count = 0;
                for (int i = 0; i < randWord.length(); i++) {
                    if ('_' == hidden_word[i])
                        hidden_count++;
                }
                if (hidden_count > 0)
                    solved = false;
                else
                    solved = true;
            }

            System.out.println("================================================\n");
            System.out.println("You have guessed incorrectly " + missChance + "/6" + " times.");
            System.out.print("\nYour guess so far:\t");
            for (int i = 0; i < randWord.length(); i++) {
                System.out.print(hidden_word[i] + " ");
            }
            System.out.print("\nMissed letters: ");
            for (int i = 0; i < missed.length; i++) {
                System.out.print(missed[i]);
            }


            if (solved) {
                System.out.print("\n\nYou have won!");
                System.out.println("\tThe word was..." + randWord + ".");
                System.out.println("\nThank you for playing!");
            } else {
                System.out.println("\nSorry, you have no more guesses left.");
                System.out.println("The word was..." + randWord + ".");
                System.out.println("\nThank you for playing!");
            }

    }
}


