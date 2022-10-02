package pucpr.compras_v2.usuarios;

import pucpr.compras_v2.carrinho.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 Classe Cliente
 */
public class Cliente extends Usuario {
    private List<CarrinhoDeCompras> carrinhoCliente = new ArrayList<>();
    private String name;
    private String cidade;


    public Cliente() {
    }


    public Cliente(String name, String cpf, String senha) {
        super(cpf, senha);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public List<CarrinhoDeCompras> getCarrinhoCliente() {
        return carrinhoCliente;
    }

    public void setCarrinhoCliente(List<CarrinhoDeCompras> carrinhoCliente) {
        this.carrinhoCliente = carrinhoCliente;
    }

    @Override
    public void adicionarCarrinho(CarrinhoDeCompras car) {
        this.carrinhoCliente.add(car);
    }



    public static List<Cliente> criaClienteList() {
        return Arrays.asList(
                new Cliente("João", "547.135.570-99", "123456"),
                new Cliente("Márcio", "434.267.090-90", "12"),
                new Cliente("Marina", "403.148.270-13", "13"),
                new Cliente("Maria", "724.715.790-94", "14"),
                new Cliente("Mariana", "404.882.260-82", "15"),
                new Cliente("Zé", "934.651.030-76", "17"),
                new Cliente("Lucas", "465.001.450-62", "18"),
                new Cliente("Dolores", "013.569.560-09", "19"),
                new Cliente("Bárbara", "20", "20"),
                new Cliente("ok", "ok", "ok")
        );
    }



    @Override
    public String toString() {
        return String.format("Cliente: %s%n", getName());
    }


}
