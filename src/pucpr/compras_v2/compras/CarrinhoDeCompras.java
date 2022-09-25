package pucpr.compras_v2.compras;



import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.menus.MenuCompras;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static pucpr.compras_v2.estoque.Estoque.getEstoque;
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



    public void adicionaProduto(CarrinhoDeCompras car) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Qual produto gostaria de adicionar? \n");
        String itemProduto = in.nextLine();
        System.out.println("Quantos itens gostaria de adicionar? \n");
        int qtdeProdutos = Integer.parseInt(in.nextLine());
        buscaProduto(itemProduto);
        for (Map.Entry<Produto, Integer> entry : getEstoque().entrySet()) {
            if (entry.getKey().getNome().equals(itemProduto)) {

                    if (entry.getValue() < qtdeProdutos) {
                        System.out.println("Não temos essa quantidade em estoque");
                        Thread.sleep(3000);
                    } else {
                        car.produtosNoCarrinho.put(entry.getKey(), qtdeProdutos);
                        setTotalCompras(totalCompras(car));
                    }
                }
        }
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




    public void fecharCompra(CarrinhoDeCompras car, Map<Produto, Integer> est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        if (car == null) {
            System.out.println("Carrinho vazio, nada para mostrar");
            Thread.sleep(3000);
            MenuCompras.menuCompras(this.clienteCarrinho, null, est, hist, clientes);
        } else {
            for (Map.Entry<Produto, Integer> produtosCarrinho : car.getProdutosNoCarrinho().entrySet()) {
                int qtdeProdutoCarrinho = produtosCarrinho.getValue();
                for (Map.Entry<Produto, Integer> produtoEstoque : est.entrySet()) {
                    if (produtosCarrinho.getKey().equals(produtoEstoque.getKey())) {
                        est.put(produtoEstoque.getKey(), produtoEstoque.getValue() - qtdeProdutoCarrinho);
                    }
                }
            }
            CarrinhoDeCompras another = new CarrinhoDeCompras(car);
            hist.adicionarCompra(another);
        }
        produtosNoCarrinho = new LinkedHashMap<>();
        totalCompras = 0;
    }

    public Map<Produto, Integer> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }



    @Override
    public String toString() {
        String carrinho;
        if (produtosNoCarrinho == null) {
            carrinho = "\nCliente: " + clienteCarrinho + "Valor Total: R$" + totalCompras + "\nCarrinho Vazio";
        } else {
            carrinho = "\nCliente: " + clienteCarrinho + "Valor Total: R$" + totalCompras + "\nCarrinho:" + produtosNoCarrinho;
        }
        return carrinho;
    }
}


