package pucpr.compras_v2.historico;

import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Historico {
    private List<CarrinhoDeCompras> historicoCompras = new ArrayList<>();

    public void adicionarCompra(CarrinhoDeCompras car) {
        historicoCompras.add(car);
    }

    public List<CarrinhoDeCompras> getHistoricoCompras() {
        return historicoCompras;
    }


    public static double RelatorioTotalCompras(Historico his){
        var hist = his.getHistoricoCompras();
        double total = 0;
        for (CarrinhoDeCompras entry: hist) {
            for (Map.Entry<Produto, Integer> entry2 : entry.getProdutosNoCarrinho().entrySet()) {
                total += entry2.getKey().getPreco() * entry2.getValue();
            }
        }
        return total;
    }

    public static int RelatorioNumeroCompras(Historico his) {
        var hist = his.getHistoricoCompras();
        int i = 0;
        for (CarrinhoDeCompras entry: hist) {
            i++;
        }
        return i;
    }

    public static double RelatorioMediaComprado(Historico his) throws ArithmeticException {
        try {
            return Historico.RelatorioTotalCompras(his) / Historico.RelatorioNumeroCompras(his);
        }
        catch(Exception e) {
            throw new ArithmeticException("Não pode ser divido");
        }
    }


}
