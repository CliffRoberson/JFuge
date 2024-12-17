package org.example;

import org.jfugue.player.Player;
import org.jfugue.theory.ChordProgression;

import java.util.Random;
import java.util.Scanner;

public class ChordProgressionQuiz {
    private static final String[] KEYS = {"C", "D", "E", "F", "G", "A", "B"};
    private static final String[] SCALES = {"maj", "min"};
    private static final String[] CHORD_SYMBOLS = {"I", "ii", "iii", "IV", "V", "vi", "vii°"};
    private static final int[] INVERSIONS = {0, 1, 2};

    public static void main(String[] args) {
        Player player = new Player();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Chord Progression Quiz!");
        System.out.println("Listen carefully and guess the chord progression.\n");

        // Step 1: Select a random key and scale
        String key = KEYS[random.nextInt(KEYS.length)];
        String scale = SCALES[random.nextInt(SCALES.length)];
        System.out.println("The key is: " + key + " " + scale);

        // Step 2: Generate a random chord progression
        int progressionLength = 4;
        StringBuilder progressionBuilder = new StringBuilder();

        int[] progressionIndices = new int[progressionLength];
        System.out.print("Playing the chord progression: ");
        for (int i = 0; i < progressionLength; i++) {
            int chordIndex = random.nextInt(CHORD_SYMBOLS.length);
            progressionIndices[i] = chordIndex;

            int inversion = INVERSIONS[random.nextInt(INVERSIONS.length)];
            String chordWithInversion = CHORD_SYMBOLS[chordIndex] + " " + inversion;

            progressionBuilder.append(CHORD_SYMBOLS[chordIndex]).append(" ");
            System.out.print(CHORD_SYMBOLS[chordIndex] + "(inv " + inversion + ") ");
        }
        System.out.println("\nListen carefully!");

        // Step 3: Play the chord progression using ChordProgression
        ChordProgression progression = new ChordProgression(progressionBuilder.toString().trim())
                .setKey(key + (scale.equals("min") ? "min" : ""));

        player.play(progression.eachChordAs("$!w")); // Play each chord as a whole note

        // Step 4: Quiz the user
        System.out.println("\nWhat were the chords? Enter them separated by spaces (e.g., I IV V vi):");
        String userGuess = scanner.nextLine();

        // Step 5: Check the answer
        StringBuilder correctAnswer = new StringBuilder();
        for (int index : progressionIndices) {
            correctAnswer.append(CHORD_SYMBOLS[index]).append(" ");
        }

        if (userGuess.trim().equalsIgnoreCase(correctAnswer.toString().trim())) {
            System.out.println("Correct! Well done!");
        } else {
            System.out.println("Oops! The correct progression was: " + correctAnswer.toString().trim());
        }

        System.out.println("Thank you for playing!");
    }
}




