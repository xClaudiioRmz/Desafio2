import java.util.Scanner;
import java.util.Stack;
//Cláudio Rodriguez Monteiro - 081180042 - EC6 - Challenge 2
public class Desafio {
    public static void main(String[] args) {
        boolean sair = false;
        while (sair != true) {
            System.out.println("1- Verificar string");
            System.out.println("0- Sair");
            Scanner scan = new Scanner(System.in);
            int opcao = 0;
            opcao = scan.nextInt();
            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    InsereCodigo();
                    break;
                default:
                    System.out.println("Opção invalida.");
                    sair = false;
                    break;

            }
        }
    }

    public static void InsereCodigo() {
        System.out.println("Alfabeto da linguagem: <{[( )]}>");
        System.out.print("Digite a string para verificar: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        boolean valido = AnalisaCodigo(text);
        if (valido) {
            System.out.println(text + " - OK - Válido");
        } else {
            System.out.println(text + " - NÃO ! - Não Válido");
        }
    }

    public static boolean AnalisaCodigo(String text) {
        Stack<Character> pilha = new Stack<Character>();
        boolean retorno = true;
        for (int i = 0; i < text.length(); i++) {
            char aux = text.charAt(i);
            if (aux == '<' || aux == '{' || aux == '[' || aux == '(') {
                pilha.push(aux);

            } else if (aux == '>' || aux == '}' || aux == ']' || aux == ')') {
                if (pilha.empty()) {
                    retorno = false;
                    break;
                }
                char ultimo = pilha.pop();
                if ((aux == ']' && ultimo == '[') || (aux == ')' && ultimo == '(')
                        || (aux == '}' && ultimo == '{') || (aux == '>' && ultimo == '<')) {
                    continue;

                } else {
                    retorno = false;
                    break;
                }
            } else {
                continue;
            }
        }
        if (!pilha.empty()) {
            retorno = false;
        }
        return retorno;
    }

}
