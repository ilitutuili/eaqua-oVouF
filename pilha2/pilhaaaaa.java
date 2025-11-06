import java.util.Scanner;

class No {
    char dado;
    No proximo;

    public No(char dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class Pilha {
    private No topo;

    public Pilha() {
        topo = null;
    }

    public void empilhar(char c) {
        No novo = new No(c);
        novo.proximo = topo;
        topo = novo;
    }

    public char desempilhar() {
        if (vazia()) {
            return '\0'; 
        }
        char valor = topo.dado;
        topo = topo.proximo;
        return valor;
    }

    public boolean vazia() {
        return topo == null;
    }
}

public class pilhaaaaa {
    public static boolean verificarExpressao(String exp) {
        Pilha pilha = new Pilha();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.empilhar(c);
            } else if (c == ')' || c == ']' || c == '}') {
                char topo = pilha.desempilhar();

                if (topo == '\0') {
                    return false;
                }

                if ((c == ')' && topo != '(') ||
                    (c == ']' && topo != '[') ||
                    (c == '}' && topo != '{')) {
                    return false;
                }
            }
        }

        return pilha.vazia();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Verificar expressão");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            String linha = entrada.nextLine().trim();
            try {
                opcao = Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite uma expressão: ");
                    String expressao = entrada.nextLine();
                    if (verificarExpressao(expressao)) {
                        System.out.println("Expressão CORRETA!");
                    } else {
                        System.out.println("Expressão INCORRETA!");
                    }
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);

        entrada.close();
    }
}