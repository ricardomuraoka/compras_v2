package pucpr.compras_v2.historico;

import pucpr.compras_v2.carrinho.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.usuarios.Cliente;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Historico {
    private List<CarrinhoDeCompras> historicoCompras = new ArrayList<>();

    public void adicionarCompra(CarrinhoDeCompras car) {
        historicoCompras.add(car);
    }

    public List<CarrinhoDeCompras> getHistoricoCompras() {
        return historicoCompras;
    }


}
