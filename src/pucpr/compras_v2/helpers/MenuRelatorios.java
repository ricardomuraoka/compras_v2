package pucpr.compras_v2.helpers;

import pucpr.compras_v2.carrinho.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Estoque;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MenuRelatorios {

    public void escolhaRelatorio(Usuario usuario, CarrinhoDeCompras carrinho, Estoque est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - DIGITE 1 - RELATORIO DE CLIENTES - NUMERO DE COMPRAS");
        System.out.println("2 - DIGITE 2 - RELATORIO DE CLIENTES - TOTAL COMPRADO");
        System.out.println("3 - DIGITE 3 - RELATORIO DE CLIENTES - VALOR MÉDIO DE COMPRAS");
        System.out.println("4 - DIGITE 4 - NUMERO DE COMPRAS");
        System.out.println("5 - DIGITE 5 - TOTAL COMPRADO");
        System.out.println("6 - DIGITE 6 - VALOR MÉDIO DE COMPRAS");
        System.out.println("7 - DIGITE 7 - VOLTAR");
        int tipoRelatorio = Integer.parseInt(in.nextLine());

        /* if (tipoRelatorio == 1) {
            final int pageSize = 5;
            final int pages = (Cliente.criaClienteList().size() + pageSize - 1) / pageSize;
            for (int i = 1; i <= pages; i++) {
                System.out.println(getPageClient(Cliente.criaClienteList(), i, pageSize));
                Thread.sleep(3000);
            } */
        if (tipoRelatorio == 1) {
            System.out.printf("Total de compras: %d%n", new Relatorios().relatorioNumeroComprasCliente(clientes));
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        } else if (tipoRelatorio == 2) {
            System.out.printf("Valor total em compras: %.2f%n", new Relatorios().relatorioTotalComprasCliente(clientes));
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        } else if (tipoRelatorio == 3) {
            System.out.printf("Valor médio em compras: %.2f%n", new Relatorios().relatorioMediaCompradoCliente(clientes));
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        } else if (tipoRelatorio == 4) {
            System.out.printf("Total de compras: %d%n", new Relatorios().relatorioNumeroCompras(hist));
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        } else if (tipoRelatorio == 5) {
            System.out.printf("Valor total em compras: %.2f%n", new Relatorios().relatorioTotalCompras(hist));
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        } else if (tipoRelatorio == 6) {
            System.out.printf("Valor médio em compras: %.2f%n", new Relatorios().relatorioMediaComprado(hist));
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        } else if (tipoRelatorio ==7){
            new MenuInicial().menu(usuario, carrinho, est, hist, clientes);
        } else {
            System.out.println("Escolha uma das opções");
            escolhaRelatorio(usuario, carrinho, est, hist, clientes);
        }
    }






    // Remember to use iterator with size() to iterate through a list
    public static List<Cliente> getPageClient(List<Cliente> clientes, int page, int pageSize) {
        if(pageSize <= 0 || page <= 0) {
            throw new IllegalArgumentException("invalid page size: " + pageSize);
        }

        int fromIndex = (page - 1) * pageSize;
        if(clientes == null || clientes.size() <= fromIndex){
            return Collections.emptyList();
        }

        return clientes.subList(fromIndex, Math.min(fromIndex + pageSize, clientes.size()));
    }


}
