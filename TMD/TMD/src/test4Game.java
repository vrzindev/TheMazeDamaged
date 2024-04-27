import java.util.Random;
import java.util.Scanner;

public class test4Game {
    private static final int MAZE_SIZE = 10; // Tamanho do labirinto
    private static final char WALL = '#';    // Representação da parede
    private static final char EMPTY = ' ';   // Representação do espaço vazio
    private static final char PLAYER = 'X';  // Representação do jogador

    private static char[][] maze = new char[MAZE_SIZE][MAZE_SIZE];
    private static int playerX, playerY;
    private static int movesLeft = 50;
    private static int timeLeft = 1000; // Tempo em segundos

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeMaze();
        initializePlayer();

        while (true) {
            displayMaze();
            System.out.println("Moves left: " + movesLeft + " | Time left: " + timeLeft + "s");
            System.out.print("Enter move (W/A/S/D): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (isValidMove(move)) {
                movePlayer(move);
                movesLeft--;

                if (maze[playerY][playerX] == EMPTY) {
                    System.out.println("You won!");
                    break;
                }

                if (movesLeft <= 0 || timeLeft <= 0) {
                    System.out.println("You lost!");
                    break;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }

            // Simula a mudança dinâmica do labirinto
            try {
                Thread.sleep(100); // Aguarda 100 milissegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Atualiza o tempo restante
            timeLeft--;
        }
        scanner.close();
    }

    private static void initializeMaze() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                maze[i][j] = random.nextBoolean() ? WALL : EMPTY;
            }
        }
    }

    private static void initializePlayer() {
        playerX = random.nextInt(MAZE_SIZE);
        playerY = random.nextInt(MAZE_SIZE);
        maze[playerY][playerX] = PLAYER;
    }

    private static void displayMaze() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(char move) {
        if (move == 'W') {
            return playerY > 0 && maze[playerY - 1][playerX] != WALL;
        } else if (move == 'S') {
            return playerY < MAZE_SIZE - 1 && maze[playerY + 1][playerX] != WALL;
        } else if (move == 'A') {
            return playerX > 0 && maze[playerY][playerX - 1] != WALL;
        } else if (move == 'D') {
            return playerX < MAZE_SIZE - 1 && maze[playerY][playerX + 1] != WALL;
        }
        return false;
    }

    private static void movePlayer(char move) {
        maze[playerY][playerX] = EMPTY;
        if (move == 'W') {
            playerY--;
        } else if (move == 'S') {
            playerY++;
        } else if (move == 'A') {
            playerX--;
        } else if (move == 'D') {
            playerX++;
        }
        maze[playerY][playerX] = PLAYER;
    }
}
