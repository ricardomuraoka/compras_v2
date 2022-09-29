package pucpr.compras_v2;

import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.login.Login;
import pucpr.compras_v2.helpers.Cadastro;
import pucpr.compras_v2.helpers.MenuInicial;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static pucpr.compras_v2.estoque.Estoque.criaEstoque;
import static pucpr.compras_v2.login.Login.validaUsuario;

public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
        var estoque = criaEstoque();
        var clientes = new ArrayList<>(Cliente.criaClienteList());
        var historico = new Historico();
        new MenuInicial().iniciaMenu(clientes, estoque, historico);
    }
}


