package pucpr.compras_v2;

import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Estoque;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.login.Login;
import pucpr.compras_v2.menus.MenuInicial;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import static pucpr.compras_v2.login.Login.validaUsuario;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var estoque = Estoque.getEstoque();
        var clientes = Cliente.getClienteList();
        var historico = new Historico();

        Usuario logado = Login.login();
        if (validaUsuario(logado) == true) {
            var carrinho = new CarrinhoDeCompras(logado);
            MenuInicial.menu(logado, carrinho, estoque, historico);
        } else {
            System.out.println("Usuário não cadastrado");
            Cadastro.desejaCadastrar(estoque, historico);
        }
    }
}


