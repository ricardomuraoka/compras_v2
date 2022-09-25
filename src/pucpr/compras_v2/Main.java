package pucpr.compras_v2;

import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.login.Login;
import pucpr.compras_v2.menus.MenuInicial;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.ArrayList;

import static pucpr.compras_v2.estoque.Estoque.getEstoque;
import static pucpr.compras_v2.login.Login.validaUsuario;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var estoque = getEstoque();
        var clientes = new ArrayList<>(Cliente.getClienteList());
        var historico = new Historico();
        System.out.println(estoque);
        Usuario logado = Login.login(clientes);
        if (validaUsuario(logado, clientes) == true) {
            var carrinho = new CarrinhoDeCompras(logado);
            MenuInicial.menu(logado, carrinho, estoque, historico, clientes);
        } else {
            System.out.println("Usuário não cadastrado");
            Cadastro.desejaCadastrar(estoque, historico, clientes);
        }
    }
}


