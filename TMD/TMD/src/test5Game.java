import java.util.Random;
import java.util.Scanner;

public class test5Game {
    private static char[][][] maps = {
        {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            }
    };

    private static char WALL = '#';
    private static char EMPTY = ' ';
    private static char PLAYER = 'X';
    private static char EXIT = 'E';

    private static char[][] currentMap;
    private static int playerX, playerY;
    private static int movesLeft = 50;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mapIndex = random.nextInt(maps.length);
        currentMap = maps[mapIndex];

        initializePlayer();

        while (true) {
            displayMaze();
            System.out.println("Movimentos Restantes: " + movesLeft);
            System.out.print("Enter move (W/A/S/D): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (isValidMove(move)) {
                movePlayer(move);
                movesLeft--;

                if (currentMap[playerY][playerX] == EXIT) {
                    System.out.println("Você escapou do labirinto! Parabéns!");
                    break;
                }

                if (movesLeft <= 0) {
                    System.out.println("Você não conseguiu escapar a tempo. Game Over!");
                    break;
                }
            } else {
                System.out.println("Movimento Inválido, Tente Novamente.");
            }
        }
        scanner.close();
    }

    private static void initializePlayer() {
        playerX = random.nextInt(currentMap[0].length);
        playerY = random.nextInt(currentMap.length);
        currentMap[playerY][playerX] = PLAYER;
    
        // Adiciona a saída no mapa
        int exitX, exitY;
        do {
            exitX = random.nextInt(currentMap[0].length);
            exitY = random.nextInt(currentMap.length);
        } while (currentMap[exitY][exitX] != EMPTY || (exitX == playerX && exitY == playerY));
    
        currentMap[exitY][exitX] = EXIT;
    }
    

    private static void displayMaze() {
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[i].length; j++) {
                System.out.print(currentMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(char move) {
        if (move == 'W') {
            return playerY > 0 && currentMap[playerY - 1][playerX] != WALL;
        } else if (move == 'S') {
            return playerY < currentMap.length - 1 && currentMap[playerY + 1][playerX] != WALL;
        } else if (move == 'A') {
            return playerX > 0 && currentMap[playerY][playerX - 1] != WALL;
        } else if (move == 'D') {
            return playerX < currentMap[0].length - 1 && currentMap[playerY][playerX + 1] != WALL;
        }
        return false;
    }

    private static void movePlayer(char move) {
        currentMap[playerY][playerX] = EMPTY;
        if (move == 'W') {
            playerY--;
        } else if (move == 'S') {
            playerY++;
        } else if (move == 'A') {
            playerX--;
        } else if (move == 'D') {
            playerX++;
        }
        currentMap[playerY][playerX] = PLAYER;
    }
}
