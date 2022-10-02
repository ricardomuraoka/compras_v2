package pucpr.compras_v2.login;

import pucpr.compras_v2.helpers.Cadastro;
import pucpr.compras_v2.carrinho.CarrinhoDeCompras;
import pucpr.compras_v2.estoque.Estoque;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.helpers.MenuInicial;
import pucpr.compras_v2.usuarios.Admin;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.List;
import java.util.Scanner;

public class Login {

    public Login() {

    }



    public Usuario login(List<Cliente> clientes) {
        Admin admin = new Admin();
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o login (cpf): ");
        String userLogin = in.nextLine();
        System.out.println("Digite a senha: ");
        String psd = in.nextLine();
        Usuario usuarioLogin = null;
        if ((userLogin.equals(admin.getCpf())) && (userLogin.equals(admin.getSenha()))) {
            usuarioLogin = admin;
        } else {
            for (Usuario usuarioAtual : clientes) {
                if (userLogin.equals(usuarioAtual.getCpf()) && psd.equals(usuarioAtual.getSenha())) {
                    usuarioLogin = usuarioAtual;
                }
            }
        }
        return usuarioLogin;
    }

    public static boolean validaUsuario(Usuario usuario, List<Cliente> clientes) {
        boolean valida = false;
        Admin admin = new Admin();
        if (usuario == null) {
            valida = false;
        } else if ((usuario.getCpf().equals(admin.getCpf())) && (usuario.getSenha().equals(admin.getSenha()))) {
            valida = true;
        } else {
            for (Object cli : clientes)
                valida = usuario.equals(cli);
        }
        return valida;
    }

    public static void trocaUsuario(Estoque est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        Login log = new Login();
        Usuario novoUsuario = log.login(clientes);
        if (validaUsuario(novoUsuario, clientes)) {
            new MenuInicial().menu(novoUsuario, new CarrinhoDeCompras(novoUsuario),est, hist, clientes);
        } else {
            System.out.println("Usuário não cadastrado");
            new Cadastro().desejaCadastrar(est, hist, clientes);
        }
    }
}
