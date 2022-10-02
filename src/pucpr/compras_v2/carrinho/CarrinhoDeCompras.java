package pucpr.compras_v2.carrinho;



import pucpr.compras_v2.estoque.Estoque;
import pucpr.compras_v2.estoque.FiltrarProdutos;
import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.helpers.MenuCompras;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static pucpr.compras_v2.estoque.Produto.getProdutos;


public class CarrinhoDeCompras {
    private Map<Produto, Integer> produtosNoCarrinho = new LinkedHashMap<>();
    private double totalCompras;
    private final Usuario clienteCarrinho;


    public CarrinhoDeCompras(Usuario atual) {
        clienteCarrinho = atual;
    }

    public CarrinhoDeCompras(CarrinhoDeCompras another) {
        this.produtosNoCarrinho = another.produtosNoCarrinho;
        this.totalCompras = another.totalCompras;
        this.clienteCarrinho = another.clienteCarrinho;
    }



    public void adicionaProduto(CarrinhoDeCompras car, Estoque est) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Qual produto gostaria de adicionar? \n");
        String itemProduto = in.nextLine();
        System.out.println("Quantos itens gostaria de adicionar? \n");
        int qtdeProdutos = Integer.parseInt(in.nextLine());
        new FiltrarProdutos().filtrarProdutos(est, itemProduto);
        for (Map.Entry<Produto, Integer> entry : est.getItensEstoque().entrySet()) {
            if (entry.getKey().getNome().equals(itemProduto)) {
                    if (entry.getValue() < qtdeProdutos) {
                        car.produtosNoCarrinho.put(entry.getKey(), entry.getValue());
                        System.out.printf("Não temos essa quantidade em estoque, ajustamos automaticamente para %d," +
                                "quantidade que temos no momento %n",entry.getValue() );
                        Thread.sleep(3000);

                    } else {
                        car.produtosNoCarrinho.put(entry.getKey(), qtdeProdutos);
                        setTotalCompras(totalCompras(car));
                    }
                }
        }
    }

    public static Double totalCompras(CarrinhoDeCompras car) {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : car.getProdutosNoCarrinho().entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }




    public void fecharCompra(CarrinhoDeCompras car, Estoque est, Historico hist, List<Cliente> clientes, Usuario logado) throws InterruptedException {
        if (car.getProdutosNoCarrinho().size() == 0) {
            System.out.println("Carrinho vazio, nada para mostrar");
            Thread.sleep(3000);
            new MenuCompras().menuCompras(car.getClienteCarrinho(), null, est, hist, clientes);
        } else {
            for (Map.Entry<Produto, Integer> produtosCarrinho : car.getProdutosNoCarrinho().entrySet()) {
                int qtdeProdutoCarrinho = produtosCarrinho.getValue();
                for (Map.Entry<Produto, Integer> produtoEstoque : est.getItensEstoque().entrySet()) {
                     if (produtosCarrinho.getKey().equals(produtoEstoque.getKey()) &&
                                produtoEstoque.getValue() >= produtosCarrinho.getValue()) {
                            est.getItensEstoque().put(produtoEstoque.getKey(), produtoEstoque.getValue() - qtdeProdutoCarrinho);
                        }
                    }
                }
            CarrinhoDeCompras another = new CarrinhoDeCompras(car);
            hist.adicionarCompra(another);
            logado.adicionarCarrinho(another);
        }
        this.produtosNoCarrinho = new LinkedHashMap<>();
        this.totalCompras = 0;
    }

    public Map<Produto, Integer> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }

    public StringBuilder produtosNoCarrinho() {
        var str = new StringBuilder();
        for (var i : produtosNoCarrinho.entrySet()) {
            str.append(String.format("%nProduto: %-15s Preco: %-6.2f R$ Qtde: %-3d", i.getKey().getNome(), i.getKey().getPreco(), i.getValue()));
        }
        return str;
    }

    public Usuario getClienteCarrinho() {
        return clienteCarrinho;
    }


    @Override
    public String toString() {
        String carrinho;
        if (produtosNoCarrinho.size() == 0) {
            carrinho = String.format("%nCliente: %s Valor Total: R$%f%nCarrinho Vazio", clienteCarrinho, totalCompras);
        } else {
            carrinho = new StringBuilder().append(String.format("%nCliente: %sValor Total: R$%.2f%nCarrinho: ", clienteCarrinho, totalCompras))
                    .append(produtosNoCarrinho()).toString();
        }
        return carrinho;
    }
}


