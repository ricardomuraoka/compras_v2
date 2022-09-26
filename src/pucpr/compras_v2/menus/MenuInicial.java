package pucpr.compras_v2.menus;

import pucpr.compras_v2.Sobre;
import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Estoque;
import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.login.Login;
import pucpr.compras_v2.usuarios.Admin;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static pucpr.compras_v2.menus.MenuRelatorios.escolhaRelatorio;

/**
 * Classe utilitária menu
 */
public final class MenuInicial {
    private MenuInicial() {
        throw new UnsupportedOperationException("Classe de utilidade não pode ser instanciada.");
    }

    public static void menu(Usuario usuario, CarrinhoDeCompras carrinho, Estoque est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("ESCOLHA UMA OPÇÃO");
        if (!Objects.equals(usuario.getClass(), Admin.class)) {
            System.out.println("1 - DIGITE 1 - FAZER COMPRAS. ");
        }
        System.out.println("2 - DIGITE 2 - TROCAR USUÁRIO. ");
        System.out.println("3 - DIGITE 3 - SOBRE. ");
        System.out.println("4 - DIGITE 4 - SAIR. ");
        if (Objects.equals(usuario.getClass(), Admin.class)) {
            System.out.println("5 - DIGITE 5 - RELATÓRIOS SOBRE CLIENTES. ");
        }
        int option = Integer.parseInt(in.nextLine());
        try {
            switch (option) {
                case 1 -> MenuCompras.menuCompras(usuario, carrinho, est, hist, clientes);
                case 2 -> Login.trocaUsuario(est, hist, clientes);
                case 3 -> {
                    System.out.println(new Sobre());
                    Thread.sleep(3000);
                    MenuInicial.menu(usuario, carrinho, est, hist, clientes);
                }
                case 4 -> System.exit(0);
                case 5 -> escolhaRelatorio(usuario, carrinho, est, hist, clientes);
                default -> System.out.println("Escolha uma das opções: ");
            }
        } catch (NumberFormatException e) {
            MenuInicial.menu(usuario, carrinho, est, hist, clientes);
        }
    }
}

