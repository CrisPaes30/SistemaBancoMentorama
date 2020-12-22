import java.util.Iterator;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Utils utils = new Utils();
        Scanner scanner = new Scanner(System.in);

        var listaClientes = utils.gerarClientes();

        MenuCliente menuCliente = new MenuCliente(listaClientes, scanner, utils);

        while (true){
            System.out.println("\n Escolha uma das opções abaixo: ");

            System.out.println(" 1 - Saldo total do banco");
            System.out.println(" 2 - Clientes");
            System.out.println(" 3 - Sair");

            int opcao = scanner.nextInt();

            if(opcao == 3){
                scanner.close();
                break;
            }

            if(opcao == 1){
                utils.imprimirSaldoGeralBanco(listaClientes);
            }

            if(opcao == 2){
                menuCliente.Menu();
            }
        }



    }

}
