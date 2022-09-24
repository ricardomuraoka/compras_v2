package pucpr.compras_v2.historico;

import pucpr.compras_v2.compras.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<CarrinhoDeCompras> historico = new ArrayList<>();

    public Historico() {
    }

    public void adicionarCompra(CarrinhoDeCompras car) {
        historico.add(car);
    }

    public List<CarrinhoDeCompras> getHistorico() {
        return historico;
    }

    public void setHistorico(List<CarrinhoDeCompras> historico) {
        this.historico = historico;
    }
}
