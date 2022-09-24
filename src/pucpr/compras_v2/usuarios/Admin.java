package pucpr.compras_v2.usuarios;

/**
 * Classe administrador
 */
public class Admin extends Usuario {
    private static final String ADM = "admin";

    public Admin() {
        this.setCpf(ADM);
        this.setSenha(ADM);
    }



    @Override
    public String getCpf() {
        return ADM;
    }

    @Override
    public String getSenha() {
        return ADM;
    }
}


