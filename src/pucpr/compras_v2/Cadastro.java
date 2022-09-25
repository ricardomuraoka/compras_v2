package pucpr.compras_v2;

import pucpr.compras_v2.estoque.Produto;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.usuarios.Cliente;
import pucpr.compras_v2.usuarios.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static pucpr.compras_v2.login.Login.trocaUsuario;

public class Cadastro {
    public static void cadastraCliente(Map<Produto, Integer> est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Insira seu nome: ");
        String name = in.nextLine();
        System.out.println("Insira seu cpf: ");
        String cpf = in.nextLine();
        System.out.println("insira a senha que deseja cadastrar: ");
        String senha = in.nextLine();
        Cliente novo = new Cliente(name, cpf, senha);
        System.out.println("Insira a cidade onde você mora: ");
        String cidadeUsuario = in.nextLine();
        novo.setCidade(cidadeUsuario);
        adicionaCliente(novo, clientes);
        trocaUsuario(est, hist, clientes);
    }

    public static void adicionaCliente(Cliente novo, List<Cliente> clientes) {
        if (clientes.contains(novo)) {
            System.out.println("Este cliente já existe");
        } else {
            clientes.add(novo);
        }
    }


    public static void desejaCadastrar(Map<Produto, Integer> est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        System.out.println("Deseja realizar seu cadastro? ");
        Scanner in = new Scanner(System.in);
        System.out.println("1 - SIM");
        System.out.println("2 - NÃO");
        int option = Integer.parseInt(in.nextLine());
        if (option == 1) Cadastro.cadastraCliente(est, hist, clientes);
        else if (option == 2) System.exit(0);
        else {
            System.out.println("Digite uma opção corretamente");
            desejaCadastrar(est, hist, clientes);
        }
    }
}
