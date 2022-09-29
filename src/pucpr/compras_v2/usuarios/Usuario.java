package pucpr.compras_v2.usuarios;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe usuário
 */
public abstract class Usuario {
    private List<Usuario> usuarios = new ArrayList<>();
    private String cpf;
    private String senha;

    public Usuario(String cpf, String senha) {
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


}