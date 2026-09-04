package basics.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void runSimulation(int rounds) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        // Sample moves for demo if run without interactive input
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] demoComputerMoves = {"Scissors", "Paper", "Rock", "Scissors", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        System.out.printf("%-8s | %-12s | %-14s | %-12s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String pMove = (i < demoPlayerMoves.length) ? demoPlayerMoves[i] : moves[random.nextInt(3)];
            String cMove = (i < demoComputerMoves.length) ? demoComputerMoves[i] : moves[random.nextInt(3)];

            String result = playRound(pMove, cMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else if (result.equals("Draw")) {
                draws++;
            }

            System.out.printf("Round %-2d | %-12s | %-14s | %-12s%n", (i + 1), pMove, cMove, result);
        }

        double winPct = (rounds > 0) ? ((double) wins / rounds) * 100.0 : 0.0;
        System.out.println("---------------------------------------------------------");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPct);
    }

    public static void main(String[] args) {
        runSimulation(5);
    }
}
