package pucpr.compras_v2.usuarios;

import pucpr.compras_v2.carrinho.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe usuário
 */
public abstract class Usuario {
    private List<Usuario> usuarios = new ArrayList<>();
    private String cpf;
    private String senha;

    protected Usuario() {
    }

    protected Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<CarrinhoDeCompras> getCarrinhoCliente() {
        return null;
    }

    public void adicionarCarrinho(CarrinhoDeCompras car) {
    }
}