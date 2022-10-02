package pucpr.compras_v2.historico;

import pucpr.compras_v2.carrinho.CarrinhoDeCompras;


import java.util.ArrayList;
import java.util.List;


public class Historico {
    private List<CarrinhoDeCompras> historicoCompras = new ArrayList<>();

    public void adicionarCompra(CarrinhoDeCompras car) {
        historicoCompras.add(car);
    }

    public List<CarrinhoDeCompras> getHistoricoCompras() {
        return historicoCompras;
    }


}
