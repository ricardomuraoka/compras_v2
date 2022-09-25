package pucpr.compras_v2.menus;

import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.usuarios.Cliente;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MenuRelatorios {
    private MenuRelatorios() {
        throw new UnsupportedOperationException("Classe de utilidade não pode ser instanciada.");
    }

    public static void escolhaRelatorio(Historico hist) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - DIGITE 1 - RELATORIO DE CLIENTES");
        System.out.println("2 - DIGITE 2 - NUMERO DE COMPRAS");
        System.out.println("3 - DIGITE 3 - TOTAL COMPRADO");
        System.out.println("4 - DIGITE 4 - VALOR MÉDIO DE COMPRAS");
        int tipoRelatorio = Integer.parseInt(in.nextLine());

        if (tipoRelatorio == 1) {
            final int pageSize = 5;
            final int pages = (Cliente.getClienteList().size() + pageSize - 1) / pageSize;
            for (int i = 1; i <= pages; i++) {
                System.out.println(getPageClient(Cliente.getClienteList(), i, pageSize));
                Thread.sleep(3000);
            }
            escolhaRelatorio(hist);
        } else if (tipoRelatorio == 2) {
            System.out.printf("Total de compras: %d\n", Historico.RelatorioNumeroCompras(hist));
            escolhaRelatorio(hist);
        } else if (tipoRelatorio == 3) {
            System.out.printf("Valor total em compras: %.2f\n", Historico.RelatorioTotalCompras(hist));
            escolhaRelatorio(hist);
        } else if (tipoRelatorio == 4) {
            System.out.printf("Valor médio em compras: %.2f\n", Historico.RelatorioMediaComprado(hist));
            escolhaRelatorio(hist);
        } else {
            System.out.println("Escolha uma das opções");
            escolhaRelatorio(hist);
        }
    }







    public static <Cliente> List<Cliente> getPageClient(List<Cliente> clientes, int page, int pageSize) {
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
