package pucpr.compras_v2.login;

import pucpr.compras_v2.Cadastro;
import pucpr.compras_v2.compras.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.menus.MenuInicial;
import pucpr.compras_v2.usuarios.Admin;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Login {
    public static Usuario login(List<Cliente> clientes) throws InterruptedException {
        Admin admin = new Admin();
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o login (cpf): ");
        String userLogin = in.nextLine();
        System.out.println("Digite a senha: ");
        String psd = in.nextLine();
        Usuario usuarioLogin = null;
        if ((userLogin.equals(admin.getCpf())) && (userLogin.equals(admin.getCpf()))) {
            usuarioLogin = admin;
        } else {
            for (Usuario usuarioAtual : clientes) {
                if (userLogin.equals(usuarioAtual.getCpf()) && psd.equals(usuarioAtual.getSenha())) {
                    usuarioLogin = usuarioAtual;
                }
            }
        };
        return usuarioLogin;
    }

    public static boolean validaUsuario(Usuario usuario, List<Cliente> clientes) throws InterruptedException {
        boolean valida = false;
        Admin admin = new Admin();
        if (usuario == null) {
            valida = false;
        } else if ((usuario.getCpf().equals(admin.getCpf())) && (usuario.getSenha().equals(admin.getSenha()))) {
            valida = true;
        } else {
            for (Object cli : clientes)
                if (usuario.equals(cli)) {
                    valida = true;
                } else {
                    valida = false;
                }
        }
        return valida;
    }

    public static void trocaUsuario(Map<Produto, Integer> est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        Usuario novoUsuario = Login.login(clientes);
        if (validaUsuario(novoUsuario, clientes) == true) {
            MenuInicial.menu(novoUsuario, new CarrinhoDeCompras(novoUsuario),est, hist, clientes);
        } else {
            System.out.println("Usuário não cadastrado");
            Cadastro.desejaCadastrar(est, hist, clientes);
        }
    }
}
