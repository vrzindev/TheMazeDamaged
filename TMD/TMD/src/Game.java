import java.util.*;

public class Game {
    // Declaração dos mapas dos labirintos
    private static char[][][] maps = {
        {
            // Mapa 01 (Principal)
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#'},
            {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
            // Mapa 02 
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
            // Mapa 03 
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        } 
    };

    // Declaração dos caracteres utilizados no labirinto.
    private static char paradeLabirinto = '#';
    private static char emptySlot = ' ';
    private static char jogador = 'X';
    private static char saidaLabirinto = 'F';
    private static char inimigo = 'E';

    // Declaração das variáveis de controle do jogo
    private static char[][] mapaAtual;
    public static int jogadorX, jogadorY;
    private static int movimentosRestantes;
    private static String nomeJogador;
    private static String dificuldadeEscolhida;
    private static int faseAtual = 1;
    private static boolean inimigoVivo = false; // Indica se um inimigo está ativo
    private static int inimigoX, inimigoY; // Posição do inimigo
    public static String resetar_cores = "\u001B[0m";
    public static String cor_vermelha = "\u001B[31m";
    public static String cor_verde = "\u001B[32m";
    public static String cor_amarelo = "\u001B[33m";
    public static int saidaLabirintoX, saidaLabirintoY;

    private static double percentualChance = 0.001; // % de chance base
        
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Chama o menu para inicializar as configurações do jogo
        exibirMenu();

        // Loop principal do jogo
        while (true) {
            // Escolhe aleatoriamente um dos 3 mapas
            int mapIndex = random.nextInt(maps.length);
            mapaAtual = maps[mapIndex];

            // Inicializa a posição do jogador e a saída do labirinto
            iniciarGame();

            // Loop da fase atual
            while (true) {
                exibirLabirinto();
                if (inimigoVivo) {
                    System.out.println(cor_vermelha + "Um inimigo está na sua frente! Derrote-o digitando 'ATACAR'." + resetar_cores);
                }

                System.out.print("Escolha o movimento do jogador (W/A/S/D / ATACAR): ");
                String acaoJogador = scanner.next().toUpperCase();

                if (acaoJogador.equals("ATACAR") && inimigoVivo) {
                    derrotarInimigo();
                } else if (validarMovimentoJogador(acaoJogador.charAt(0))) {
                    movimentoJogador(acaoJogador.charAt(0));
                    movimentosRestantes--;

                    if (mapaAtual[saidaLabirintoY][saidaLabirintoX] == emptySlot || (saidaLabirintoX == jogadorX && saidaLabirintoY == jogadorY)) {
                        mapaAtual[jogadorY][jogadorX] = jogador;
                        System.out.println("Você escapou do labirinto! Parabéns!");

                        // Passar para a próxima fase
                        faseAtual++;
                        System.out.println("Passando Para A Fase Seguinte" + faseAtual + "...");

                        // Resetar movimentos e aumentar a chance de spawn de inimigos
                        movimentosRestantes = calcularMovimentosRestantes(); // Reseta para a quantidade inicial
                        percentualChance += 0.1; // Aumenta a chance em 10% a cada fase
                        percentualChance = Math.min(percentualChance, 1.0); // Limita a chance máxima a 100%
                        
                        inimigoVivo = false; // Garante que o inimigo não comece ativo na nova fase
                        break; // Começa a próxima fase
                    }

                    if (movimentosRestantes <= 0) {
                        System.out.println("Você não conseguiu escapar a tempo. Game Over!");
                        break; // Encerra o jogo
                    }
                } else {
                    System.out.println("Movimento Inválido, Tente Novamente.");
                }
            }
            if (movimentosRestantes <= 0) {
                break; // Encerra o jogo caso o jogador perca
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

        // Painel contendo informações de jogador/jogo.
        System.out.println("\nOlá " + nomeJogador + ", você escolheu o personagem '" + jogador + "' e a dificuldade '" + dificuldadeEscolhida + "'. Boa sorte!");
    }

    public static void iniciarGame() {
        int mapIndex = random.nextInt(maps.length);  
    
        switch (mapIndex) {
            case 0: // Mapa 01
                mapaAtual = maps[0]; 
                jogadorX = 1;
                jogadorY = 1;
                saidaLabirintoX = 18;
                saidaLabirintoY = 11;
                break;
            case 1: // Mapa 02
                mapaAtual = maps[1];
                jogadorX = 18;
                jogadorY = 11;
                saidaLabirintoX = 1;
                saidaLabirintoY = 1;
                break;
            case 2: // Mapa 03
                mapaAtual = maps[2]; 
                jogadorX = 18;
                jogadorY = 11;
                saidaLabirintoX = 1;
                saidaLabirintoY = 5;
                break;
            default:
                System.err.println("Mapa inválido selecionado.");
                System.exit(1);
        }
    
        mapaAtual[jogadorY][jogadorX] = jogador;
        mapaAtual[saidaLabirintoY][saidaLabirintoX] = saidaLabirinto;

        // Gerar um inimigo no início da fase (caso a dificuldade permita)
        inimigoVivo = (faseAtual <= 3); // Exemplo: Inimigos nas 3 primeiras fases.
        if (inimigoVivo) {
            gerarInimigo();
        }
    }

    // Exibe o labirinto atual na tela
    private static void exibirLabirinto() {
        for (int i = 0; i < mapaAtual.length; i++) {
            for (int j = 0; j < mapaAtual[i].length; j++) {
                System.out.print(mapaAtual[i][j] + " ");
            }
            System.out.print("   "); // Espaço entre o labirinto e as informações.
            if (i == 0) {
                System.out.println(cor_verde +"Nome do Jogador: "+ resetar_cores + nomeJogador);
            } else if (i == 1) {
                System.out.println(cor_amarelo +"Personagem: "+ resetar_cores + jogador);
            } else if (i == 2) {
                System.out.println(cor_vermelha +"Dificuldade: "+ resetar_cores + dificuldadeEscolhida);
            } else if (i == 3) {
                System.out.println("Fase Atual: " + faseAtual);
            } else if (i == 4) {
                System.out.println("Movimentos Restantes: " + movimentosRestantes);
            } else {
                System.out.println();
            }
        }
    }

    // Método para validar o movimento do jogador
    private static boolean validarMovimentoJogador(char movimentoJogador) {
      // Se o inimigo estiver vivo, nenhum movimento é permitido
      if (inimigoVivo) {
          System.out.println("Você não pode se mover enquanto o inimigo estiver presente. Derrote-o primeiro!");
          return false; 
      }

      // Se o inimigo não estiver vivo, valida o movimento normalmente
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

      // Tentar gerar inimigo aleatoriamente após o movimento
      tentarGerarInimigo(); 
  }

  private static void tentarGerarInimigo() {
    if (!inimigoVivo && random.nextDouble() < percentualChance) {
        gerarInimigo();
    }
}

    // Gerar um inimigo aleatoriamente no mapa
    private static void gerarInimigo() {
      // Definir direções possíveis para o inimigo
      int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      
      // Escolher uma direção aleatória
      int direcaoIndex = random.nextInt(direcoes.length);
      int dx = direcoes[direcaoIndex][0];
      int dy = direcoes[direcaoIndex][1];

      // Calcular a posição do inimigo
      inimigoX = jogadorX + dx;
      inimigoY = jogadorY + dy;

      // Verificar se a posição do inimigo é válida
      if (inimigoX >= 0 && inimigoX < mapaAtual[0].length && 
          inimigoY >= 0 && inimigoY < mapaAtual.length &&
          mapaAtual[inimigoY][inimigoX] == emptySlot) {
          mapaAtual[inimigoY][inimigoX] = inimigo;
          inimigoVivo = true;
      } else {
          // Se a posição não for válida, tentar gerar novamente
          gerarInimigo(); 
      }
  }

    // Derrotar o inimigo
    private static void derrotarInimigo() {
        if (inimigoVivo) {
            mapaAtual[inimigoY][inimigoX] = emptySlot;
            inimigoVivo = false;
            movimentosRestantes -= 5; // Perder 5 movimentos
            System.out.println("Você derrotou o inimigo!");
        }
    }

    // Função para calcular a quantidade de movimentos (resetando para a quantidade inicial).
    private static int calcularMovimentosRestantes() {
        // Reseta os movimentos para a quantidade inicial, de acordo com a dificuldade.
        switch (dificuldadeEscolhida) {
            case "Fácil":
                return 60;
            case "Médio":
                return 50;
            case "Difícil":
                return 40;
            default:
                return 50; // Padrão
        }
    }
}
