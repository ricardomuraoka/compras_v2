package pucpr.compras_v2.helpers;

import pucpr.compras_v2.estoque.Estoque;
import pucpr.compras_v2.historico.Historico;
import pucpr.compras_v2.usuarios.Cliente;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static pucpr.compras_v2.login.Login.trocaUsuario;

public class Cadastro {

    public void cadastraCliente(Estoque est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Insira seu nome: ");
        String name = in.nextLine();
        System.out.println("Insira seu cpf: ");
        String cpf = in.nextLine();
        if (new Cadastro().validaCPF(cpf) == true) {
            System.out.println("CPF válido");
        } else {
            System.out.println("CPF inválido");
            new Cadastro().cadastraCliente(est, hist, clientes);
        }
        System.out.println("insira a senha que deseja cadastrar: ");
        String senha = in.nextLine();
        Cliente novo = new Cliente(name, cpf, senha);
        System.out.println("Insira a cidade onde você mora: ");
        String cidadeUsuario = in.nextLine();
        novo.setCidade(cidadeUsuario);
        adicionaCliente(novo, clientes);
        trocaUsuario(est, hist, clientes);
    }

    public void adicionaCliente(Cliente novo, List<Cliente> clientes) {
        if (clientes.contains(novo)) {
            System.out.println("Este cliente já existe");

        } else {
            clientes.add(novo);
        }
    }


    public void desejaCadastrar(Estoque est, Historico hist, List<Cliente> clientes) throws InterruptedException {
        System.out.println("Deseja realizar seu cadastro? ");
        Scanner in = new Scanner(System.in);
        System.out.println("1 - SIM");
        System.out.println("2 - NÃO");
        int option = Integer.parseInt(in.nextLine());
        if (option == 1) new Cadastro().cadastraCliente(est, hist, clientes);
        else if (option == 2) System.exit(0);
        else {
            System.out.println("Digite uma opção corretamente");
            desejaCadastrar(est, hist, clientes);
        }
    }

    public boolean validaCPF(String CPF) {
        /* Toda pessoa que se inscreve no Cadastro de Pessoas Físicas da Receita Federal do Brasil recebe um número de
        inscrição de onze dígitos decimais com a seguinte configuração: ABC.DEF.GHI-JK.
        1 - Os primeiros oito dígitos,
        ABCDEFGH, formam o número-base definido pela Receita Federal no momento da inscrição.
        2 - O nono dígito, I, define a Região Fiscal responsável pela inscrição.
        3 - O penúltimo, J, é o dígito verificador dos nove primeiros.
        4 - O último, K, é o dígito verificador dos noves anteriores a ele.
        5 - Os nove primeiros algarismos são ordenadamente multiplicados pela sequência 10, 9, 8, 7, 6, 5, 4, 3, 2
        (o primeiro por 10, o segundo por 9, e assim sucessivamente). Em seguida, calcula-se o resto r da divisão da
        soma dos resultados das multiplicações por  11:
            * se esse resto for 0 ou 1, o primeiro dígito verificador é zero (d1=0); caso contrário, d1=11−r.
        6 -  O segundo Dígito Verificador (d2) é calculado pela mesma regra, na qual os números a serem multiplicados
        pela sequência 10, 9, 8, 7, 6, 5, 4, 3, 2 são contados a partir do segundo algarismo, sendo d1 o último
        algarismo. Se s é o resto da divisão por 11 das somas das multiplicações, então:
            * d2 é zero, se s for 0 ou 1; caso contrário, d2=11−s. */
        if (CPF.contains(".")) {
            CPF = CPF.replace(".", "");
        }
        if (CPF.contains("-")) {
            CPF = CPF.replace("-", "");
        }


        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
                CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") ||
                CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dv1, dv2;
        int soma, i, resto, digito, multiplicador;


        try {
            soma = 0;
            multiplicador = 10;
            for (i = 0; i < 9; i++) {
                digito = Integer.parseInt(String.valueOf(CPF.charAt(i)));
                soma = soma + (digito * multiplicador);
                multiplicador = multiplicador - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                dv1 = '0';
            else
                dv1 = Character.forDigit(resto, 10); //radix 10 is for decimal number

            soma = 0;
            multiplicador = 11;
            for (i = 0; i < 10; i++) {
                digito = Integer.parseInt(String.valueOf(CPF.charAt(i)));
                soma = soma + (digito * multiplicador);
                multiplicador = multiplicador - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                dv2 = '0';
            else
                dv2 = Character.forDigit(resto, 10); //radix 10 is for decimal number

            if ((dv1 == CPF.charAt(9)) && (dv2 == CPF.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
