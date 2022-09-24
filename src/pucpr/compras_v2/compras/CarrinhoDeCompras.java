package pucpr.compras_v2.compras;



import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.usuarios.Cliente;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static pucpr.compras_v2.estoque.Produto.getProdutos;


public class CarrinhoDeCompras {
    private Map<Produto, Integer> produtosNoCarrinho = new LinkedHashMap<Produto, Integer>();
    private double totalCompras;
    private Cliente clienteCarrinho;


    public CarrinhoDeCompras(Cliente atual) {
        clienteCarrinho = atual;
    }


    public CarrinhoDeCompras adicionaProduto(CarrinhoDeCompras car) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Qual produto gostaria de adicionar? \n");
        String itemProduto = in.nextLine();
        System.out.println("Quantos itens gostaria de adicionar? \n");
        int qtdeProdutos = Integer.parseInt(in.nextLine());
        buscaProduto(itemProduto);
        for (Produto produtoEstoque : getProdutos()) {
            if (produtoEstoque.getNome().equals(itemProduto)) {
                for (Map.Entry<Produto, Integer> entry : car.getProdutosNoCarrinho().entrySet()) {
                    if (entry.getValue() < qtdeProdutos) {
                        System.out.println("Não temos essa quantidade em estoque");
                        Thread.sleep(3000);
                        car.adicionaProduto(car);
                    } else {
                        produtosNoCarrinho.put(produtoEstoque, qtdeProdutos);
                    }
                }
            }
        }
        return car;
    }

    public static void buscaProduto(String busca) {
        String resultadoBusca = "";
        for (Produto produtoEstoque : getProdutos()) {
            if (produtoEstoque.getNome().toLowerCase().contains(busca.toLowerCase())) {
                resultadoBusca = ("Temos em estoque: " + produtoEstoque);
                System.out.println(resultadoBusca);
            }
        }
        if (resultadoBusca.equals("")) {
            resultadoBusca = ("Não temos " + busca + " em estoque");
            System.out.println(resultadoBusca);
        }

    }

    public static Double totalCompras(CarrinhoDeCompras car) {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : car.getProdutosNoCarrinho().entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }


    public static void fecharCompra(CarrinhoDeCompras car, Map<Produto, Integer> est) {
        var estoque = est;
        for (Map.Entry<Produto, Integer> entry : car.getProdutosNoCarrinho().entrySet()) {
            int qtdeProdutoCarrinho = entry.getValue();
            int qtdeProdutoEstoque =
            estoque.get(estoque.indexOf(produtoCarrinho)).setQuantidade(qtdeProdutoEstoque - qtdeProdutoCarrinho);
            produtosNoCarrinho.get(produtosNoCarrinho.indexOf(produtoCarrinho)).setQuantidade(qtdeProdutoCarrinho);
        }
        Cliente.adicionaCompra(produtosNoCarrinho);
        produtosNoCarrinho = new ArrayList<>();
    }

    public Map<Produto, Integer> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void setProdutosNoCarrinho(Map<Produto, Integer> produtosNoCarrinho) {
        this.produtosNoCarrinho = produtosNoCarrinho;
    }


    public double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }

    public Cliente getClienteCarrinho() {
        return clienteCarrinho;
    }

    public void setClienteCarrinho(Cliente clienteCarrinho) {
        this.clienteCarrinho = clienteCarrinho;
    }



    @Override
    public String toString() {
        return getCarrinhoProdutos() + "\nValor Total: R$" + totalCompras();
    }
}


