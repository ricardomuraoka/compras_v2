package pucpr.compras_v2.menus;

import pucpr.compras_v2.Sobre;
import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.login.Login;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.Map;
import java.util.Scanner;

/**
 * Classe utilitária menu
 */
public final class MenuInicial {
    private MenuInicial() {
        throw new UnsupportedOperationException("Classe de utilidade não pode ser instanciada.");
    }

    public static void menu(Usuario usuario, CarrinhoDeCompras carrinho, Map<Produto, Integer> est, Historico hist) throws InterruptedException {
        Usuario logado = usuario;
        Scanner in = new Scanner(System.in);
        System.out.println("ESCOLHA UMA OPÇÃO");
        if (logado.getCpf() != ("admin") && logado.getSenha() != ("admin")) {
            System.out.println("1 - DIGITE 1 - FAZER COMPRAS. ");
        }
        System.out.println("2 - DIGITE 2 - TROCAR USUÁRIO. ");
        System.out.println("3 - DIGITE 3 - SOBRE. ");
        System.out.println("4 - DIGITE 4 - SAIR. ");
        if (logado.getCpf().equals("admin") && logado.getSenha().equals("admin")) {
            System.out.println("5 - DIGITE 5 - RELATÓRIOS SOBRE CLIENTES. ");
        }
        int option = Integer.parseInt(in.nextLine());
        try {
        switch(option) {
            case 1:
                MenuCompras.menuCompras(logado, carrinho, est, hist);
                break;
            case 2:
                Login.trocaUsuario(est, hist);
                break;
            case 3:
                System.out.println(new Sobre());
                Thread.sleep(3000);
                MenuInicial.menu(logado, carrinho, est, hist);
                break;
            case 4:
                System.exit(0);
                break;
            case 5:
                //escolhaRelatorio();
                break;
            default:
                System.out.println("Escolha uma das opções: ");
        }
        } catch (NumberFormatException e) {
            MenuInicial.menu(logado, carrinho, est, hist);
        }
    }
}

