package pucpr.compras_v2.estoque;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Estoque {
    private Map<Produto, Integer> itensEstoque = new LinkedHashMap<>();


    public void setQtdeItensEstoque(Map<Produto, Integer> itensEstoque) {
        this.itensEstoque = itensEstoque;
    }

    public Integer getQtdeItensEstoque(String produto) {
        int qtde = 0;
        for (Map.Entry<Produto, Integer> entry : itensEstoque.entrySet()) {
            if (produto.equals(entry.getKey().getNome())) {
                qtde = entry.getValue();
            }
        }
        return qtde;
    }




    public static Map<Produto, Integer> getEstoque()
    {
        Random rn = new Random();
        var produtos = Produto.getProdutos();
        Map<Produto, Integer> estoque = new HashMap<>();
        for (Produto prod : produtos) {
            estoque.put(prod, rn.nextInt(5) + 2);
        }
        return estoque;
    }

    public Map<Produto, Integer> getItensEstoque() {
        return itensEstoque;
    }


    @Override
    public String toString() {
        String mapAsString = itensEstoque.keySet().stream()
                .map(key -> key + "=" + itensEstoque.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }
}
