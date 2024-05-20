
//Importa todas as classes e interfaces do pacote java.util
import java.util.*;

public class testUpdate {
    // Declaração dos mapas dos labirintos
    private static char[][][] maps = {
        {
            // Mapa 01 (Principal)
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
            // Mapa 02
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        }/* ,
    {
            // Mapa 03
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
            // Mapa 04
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        }  */
    };

    // Declaração dos caracteres utilizados no labirinto.
    private static char paradeLabirinto = '#';
    private static char emptySlot = ' ';
    private static char jogador = 'X';
    private static char saidaLabirinto = 'F';

    // Declaração das variáveis de controle do jogo
    private static char[][] mapaAtual;
    public static int jogadorX, jogadorY;
    private static int movimentosRestantes;
    private static String nomeJogador;
    private static String dificuldadeEscolhida;
    public static String resetar_cores = "\u001B[0m";
    public static String cor_vermelha = "\u001B[31m";
    public static String cor_verde = "\u001B[32m";
    public static String cor_amarelo = "\u001B[33m";
    public static int saidaLabirintoX, saidaLabirintoY;
    
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Chama o menu para inicializar as configurações do jogo
        exibirMenu();

        // Escolhe aleatoriamente um dos mapas
        int mapIndex = random.nextInt(maps.length);
        mapaAtual = maps[mapIndex];

        // Inicializa a posição do jogador e a saída do labirinto
        iniciarGame();
 
        
        // Loop principal do jogo
        while (true) {
            exibirLabirinto();
            System.out.print("Escolha o movimento do jogador (W/A/S/D): ");
            char movimentoJogador = scanner.next().toUpperCase().charAt(0);

            if (validarMovimentoJogador(movimentoJogador)) {
                movimentoJogador(movimentoJogador);
                movimentosRestantes--;

                if (mapaAtual[saidaLabirintoY][saidaLabirintoX] == emptySlot || (saidaLabirintoX == jogadorX && saidaLabirintoY == jogadorY)) {
                    mapaAtual[jogadorY][jogadorX] = jogador;
                    System.out.println("Você escapou do labirinto! Parabéns!");
                    break;
                }                

                if (movimentosRestantes <= 0) {
                    System.out.println("Você não conseguiu escapar a tempo. Game Over!");
                    break;
                }
            } else {
                System.out.println("Movimento Inválido, Tente Novamente.");
            }
            
        }
        scanner.close();
    }

    // Método para exibir o menu
    private static void exibirMenu() {
        System.out.println("Bem-vindo ao Jogo do Labirinto!");
        System.out.print("Digite seu nome: ");
        nomeJogador = scanner.nextLine();

        System.out.println("Escolha seu personagem:");
        System.out.println("1. X");
        System.out.println("2. O");
        System.out.println("3. @");
        System.out.print("Digite o número do personagem: ");
        int personagemEscolhido = scanner.nextInt();

        switch (personagemEscolhido) {
            case 1:
                jogador = 'X';
                break;
            case 2:
                jogador = 'O';
                break;
            case 3:
                jogador = '@';
                break;
            default:
                System.out.println("Escolha inválida. Usando o personagem padrão 'X'.");
                jogador = 'X';
                break;
        }

        System.out.println("Escolha a dificuldade do jogo:");
        System.out.println("1. Fácil (60 movimentos)");
        System.out.println("2. Médio (50 movimentos)");
        System.out.println("3. Difícil (40 movimentos)");
        System.out.print("Digite o número da dificuldade: ");
        int dificuldade = scanner.nextInt();

        switch (dificuldade) {
            case 1:
                movimentosRestantes = 60;
                dificuldadeEscolhida = "Fácil";
                break;
            case 2:
                movimentosRestantes = 50;
                dificuldadeEscolhida = "Médio";
                break;
            case 3:
                movimentosRestantes = 40;
                dificuldadeEscolhida = "Difícil";
                break;
            default:
                System.out.println("Escolha inválida. Usando a dificuldade padrão 'Médio'.");
                movimentosRestantes = 50;
                dificuldadeEscolhida = "Médio";
                break;
        }

        scanner.nextLine(); // Consumir a nova linha pendente
        System.out.println("\nOlá " + nomeJogador + ", você escolheu o personagem '" + jogador + "' e a dificuldade '" + dificuldadeEscolhida + "'. Boa sorte!");
    }

    
    // Inicializa a posição do jogador e a saída do labirinto
    public static void iniciarGame() {
        
        do {
            jogadorX = random.nextInt(mapaAtual[0].length);
            jogadorY = random.nextInt(mapaAtual.length);
        } while (mapaAtual[jogadorY][jogadorX] != emptySlot);
        mapaAtual[jogadorY][jogadorX] = jogador;

        // Adiciona a saída no mapa
    
        do {
            saidaLabirintoX = random.nextInt(mapaAtual[0].length);
            saidaLabirintoY = random.nextInt(mapaAtual.length);
        } while (mapaAtual[saidaLabirintoY][saidaLabirintoX] != emptySlot || (saidaLabirintoX == jogadorX && saidaLabirintoY == jogadorY));
    

        mapaAtual[saidaLabirintoY][saidaLabirintoX] = saidaLabirinto;

        return;
    }

    // Exibe o labirinto atual na tela
    private static void exibirLabirinto() {
        for (int i = 0; i < mapaAtual.length; i++) {
            for (int j = 0; j < mapaAtual[i].length; j++) {
                System.out.print(mapaAtual[i][j] + " ");
            }
            System.out.print("   "); // Espaço entre o labirinto e as informações
            if (i == 0) {
                System.out.println(cor_verde +"Nome do Jogador: "+ resetar_cores + nomeJogador);
            } else if (i == 1) {
                System.out.println(cor_amarelo +"Personagem: "+ resetar_cores + jogador);
            } else if (i == 2) {
                System.out.println(cor_vermelha +"Dificuldade: "+ resetar_cores + dificuldadeEscolhida);
            } else if (i == 3) {
                System.out.println("Movimentos Restantes: " + movimentosRestantes);
            } else {
                System.out.println();
            }
        }
    }

    // Método para validar o movimento do jogador

    //Se a nova posição estiver dentro dos limites do mapa, o código verifica se o caractere na posição desejada é diferente de paradeLabirinto (que é '#').
    private static boolean validarMovimentoJogador(char movimentoJogador) {
        if (movimentoJogador == 'W') {
            return jogadorY > 0 && mapaAtual[jogadorY - 1][jogadorX] != paradeLabirinto;
        } else if (movimentoJogador == 'S') {
            return jogadorY < mapaAtual.length - 1 && mapaAtual[jogadorY + 1][jogadorX] != paradeLabirinto;
        } else if (movimentoJogador == 'A') {
            return jogadorX > 0 && mapaAtual[jogadorY][jogadorX - 1] != paradeLabirinto;
        } else if (movimentoJogador == 'D') {
            return jogadorX < mapaAtual[0].length - 1 && mapaAtual[jogadorY][jogadorX + 1] != paradeLabirinto;
        }
        return false;
    }

    // Método para movimentar o jogador no mapa
    private static void movimentoJogador(char movimentoJogador) {
        mapaAtual[jogadorY][jogadorX] = emptySlot;
        if (movimentoJogador == 'W') {
            jogadorY--;
        } else if (movimentoJogador == 'S') {
            jogadorY++;
        } else if (movimentoJogador == 'A') {
            jogadorX--;
        } else if (movimentoJogador == 'D') {
            jogadorX++;
        }
        mapaAtual[jogadorY][jogadorX] = jogador;
    }
}
