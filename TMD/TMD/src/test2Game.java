import java.util.Scanner;
import java.util.Random;

public class test2Game {
public static void main(String[] args) {

Scanner scan = new Scanner(System.in);

 String answer = scan.nextLine();

System.out.println("COMERCAR O JOGO?");


if (answer.equalsIgnoreCase("Sim")) {
    System.out.println("Ok, o jogo irá comecar.");

    
}   

else if ( answer.equalsIgnoreCase("Nao")) {
    System.out.println("Ok, até a próxima!");
    
}

else  {
    System.out.println("Desculpe, não entendi. Por favor digite Sim ou Nao");
}

}

}