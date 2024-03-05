import java.util.Scanner;

public class Main {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        Scanner scanner = new Scanner(System.in);
        int row, col;

        // Game loop
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                // Check if the current player wins
                if (checkWin(row, col)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Check if the board is full (tie)
                if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a tie!");
                    break;
                }

                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                displayBoard();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    // Initialize the board with empty cells
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Display the current state of the board
    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Check if the given move is valid
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // Check if the current player wins
    private static boolean checkWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                || (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                || (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Check if the board is full
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
