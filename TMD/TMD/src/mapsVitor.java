public class mapsVitor {
    private static final int WALL = 1;
    private static final int PATH = 0;
    private int[][] maze;
    private int rows, cols;

    public mapsVitor(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new int[rows][cols];
        generateMaze();
    }

    private void generateMaze() {
        // Inicializa com paredes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = WALL;
            }
        }
        // Começa a geração do labirinto a partir do ponto (1, 1)
        maze[1][1] = PATH;
        generatePath(1, 1);
    }

    private void generatePath(int row, int col) {
        int[] directions = {0, 1, 2, 3}; // 0: up, 1: right, 2: down, 3: left
        shuffleArray(directions);
        
        for (int direction : directions) {
            int newRow = row, newCol = col;
            
            switch (direction) {
                case 0: newRow -= 2; break; // up
                case 1: newCol += 2; break; // right
                case 2: newRow += 2; break; // down
                case 3: newCol -= 2; break; // left
            }
            
            if (isValidPosition(newRow, newCol)) {
                if (maze[newRow][newCol] == WALL) {
                    maze[newRow][newCol] = PATH;
                    maze[row + (newRow - row) / 2][col + (newCol - col) / 2] = PATH;
                    generatePath(newRow, newCol);
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        return row > 0 && row < rows - 1 && col > 0 && col < cols - 1;
    }

    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = (int)(Math.random() * (i + 1));
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] == WALL ? "#" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        mapsVitor labirinto = new mapsVitor(21, 21);
        labirinto.printMaze();
    }
}
