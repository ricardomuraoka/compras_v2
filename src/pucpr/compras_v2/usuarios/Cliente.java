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
                new Cliente("Bárbara", "367.019.640-44", "20"),
                new Cliente("ok", "048.080.870-81", "ok")
        );
    }



    @Override
    public String toString() {
        return String.format("Cliente: %s%n", getName());
    }


}
