import java.util.Scanner;
import java.util.Random;

public class main {
public static void main(String[] args) {

Scanner scan = new Scanner(System.in);

 String answer = scan.nextLine();

System.out.println("COMERCAR O JOGO?");

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

