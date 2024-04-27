import java.util.Scanner;
import java.util.Random;

public class main {
public static void main(String[] args) {

Scanner scan = new Scanner(System.in);

System.out.println("BEM VINDO, DESEJA COMERCAR O JOGO?");

 String answer = scan.nextLine();

if (answer.equalsIgnoreCase ("Sim" )) {
    System.out.println("Ok, o jogo irá comecar.");

    
}   

else if ( answer.equalsIgnoreCase("Nao")) {
    System.out.print("Ok, até a próxima!");
    
}

else  {
    System.out.print("Desculpe, não entendi. Por favor digite Sim ou Nao");
}

}

}

