package pucpr.compras_v2.helpers;

import pucpr.compras_v2.carrinho.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Filtrar;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Relatorios {
    public double relatorioTotalCompras(Historico his){
        var hist = his.getHistoricoCompras();
        double total = 0;
        for (CarrinhoDeCompras entry: hist) {
            for (Map.Entry<Produto, Integer> entry2 : entry.getProdutosNoCarrinho().entrySet()) {
                total += entry2.getKey().getPreco() * entry2.getValue();
            }
        }
        return total;
    }

    public int relatorioNumeroCompras(Historico his) {
        var hist = his.getHistoricoCompras();
        int i = 0;
        for (CarrinhoDeCompras entry: hist) {
            i++;
        }
        return i;
    }

    public double relatorioMediaComprado(Historico his) throws ArithmeticException {
        try {
            return relatorioTotalCompras(his) / relatorioNumeroCompras(his);
        }
        catch(Exception e) {
            throw new ArithmeticException("Não pode ser divido");
        }
    }

    public double relatorioTotalComprasCliente(List<Cliente> clientes){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o CPF para relatórios de cliente desejado");
        String busca = in.nextLine();
        var cliente = new Filtrar().filtrarCpf(clientes, busca);
        var carrinhos = cliente.getCarrinhoCliente();


        double total = 0;
        for (CarrinhoDeCompras entry: carrinhos) {
            for (Map.Entry<Produto, Integer> entry2 : entry.getProdutosNoCarrinho().entrySet()) {
                total += entry2.getKey().getPreco() * entry2.getValue();
            }
        }
        return total;
    }


    public int relatorioNumeroComprasCliente(List<Cliente> clientes) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o CPF para relatórios de cliente desejado");
        String busca = in.nextLine();
        var cliente = new Filtrar().filtrarCpf(clientes, busca);
        var carrinhos = cliente.getCarrinhoCliente();

        int i = 0;
        for (CarrinhoDeCompras entry: carrinhos) {
            i++;
        }
        return i;
    }

    public double relatorioMediaCompradoCliente(List<Cliente> clientes) throws ArithmeticException {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Digite o CPF para relatórios de cliente desejado");
            String busca = in.nextLine();
            var cliente = new Filtrar().filtrarCpf(clientes, busca);
            var carrinhos = cliente.getCarrinhoCliente();


            double total = 0;
            for (CarrinhoDeCompras entry: carrinhos) {
                for (Map.Entry<Produto, Integer> entry2 : entry.getProdutosNoCarrinho().entrySet()) {
                    total += entry2.getKey().getPreco() * entry2.getValue();
                }
            }

            int i = 0;
            for (CarrinhoDeCompras entry: carrinhos) {
                i++;
            }
            return total / i;
        }
        catch(Exception e) {
            throw new ArithmeticException("Não pode ser divido");
        }
    }

}
