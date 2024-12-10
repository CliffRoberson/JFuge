package org.example;

import org.jfugue.player.Player;
import org.jfugue.theory.ChordProgression;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        char userInput = ' ';

        // Loop that will continue until the user chooses to exit
        while (true) {
            // Code to be repeated in the loop
            System.out.println("This is the loop running...");

            // Wait for user input at the end of each loop iteration
            System.out.print("Press 'x' to exit or 'c' to continue: ");
            try {
                // Read user input (key press)
                userInput = (char) System.in.read();
                // Clear the buffer (consume the newline character)
                System.in.read();
            } catch (IOException e) {
                System.out.println("Error reading input.");
            }

            // Check which key the user pressed
            if (userInput == 'x' || userInput == 'X') {
                System.out.println("Exiting loop...");
                break;  // Exit the loop if 'x' or 'X' is pressed
            } else if (userInput == 'c' || userInput == 'C') {
                System.out.println("Continuing loop...");
                continue;  // Continue to the next iteration if 'c' or 'C' is pressed
            } else {
                System.out.println("Invalid input, please press 'x' to exit or 'c' to continue.");
            }
        }

        // Close the scanner
        scanner.close();



        Player player = new Player();
        String chords =
                "I I^ I^^ " +
                "II II^ II^^ " +
                "III III^ III^^ " +
                "IV IV^ IV^^" +
                "V V^ V^^" +
                "VI VI^ VI^^" +
                "VII VII^ VII^^" +
                "i i^ i^^" +
                "ii ii^ ii^^" +
                "iii iii^ iii^^" +
                "iv iv^ iv^^" +
                "v v^ v^^" +
                "vi vi^ vi^^" +
                "vii vii^ vii^^";
        String[] parts = chords.split(" ");

        int rnd = new Random().nextInt(parts.length);
        StringBuilder chordprog = new StringBuilder();
        chordprog.append(parts[rnd] + " ");
        rnd = new Random().nextInt(parts.length);
        chordprog.append(parts[rnd]);

        //ChordProgression cp = new ChordProgression(chordprog.toString());


        ChordProgression cp = new ChordProgression("I I^ I^^");
        System.out.println(cp.toString());
        player.play(cp);
    }
}