package pucpr.compras_v2.usuarios;

import java.util.Arrays;
import java.util.List;


/**
 Classe Cliente
 */
public class Cliente extends Usuario {
    private String name;
    private String cidade;


    public Cliente(String name, String cpf, String senha) {
        this.name = name;
        super.setCpf(cpf);
        this.setSenha(senha);
    }

    public Cliente() {
        super();
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

    public static List<Cliente> getClienteList() {
        return Arrays.asList(
                new Cliente("João", "123456", "123456"),
                new Cliente("Márcio", "12", "12"),
                new Cliente("Marina", "13", "13"),
                new Cliente("Maria", "14", "14"),
                new Cliente("Mariana", "15", "15"),
                new Cliente("Zé", "16", "17"),
                new Cliente("Lucas", "18", "18"),
                new Cliente("Dolores", "19", "19"),
                new Cliente("Bárbara", "20", "20"),
                new Cliente("ok", "ok", "ok")
        );
    }



    @Override
    public String toString() {
        return "Cliente: " + name + "\n";
    }


}
