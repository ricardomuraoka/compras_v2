package pucpr.compras_v2;

public class Sobre {
        String nomeLoja = "Utilidades Bebidas";
        String versao = "0.0.1";
        String autor = "Ricardo Muraoka";


    @Override
    public String toString() {
        return String.format("\nNome da loja: " + nomeLoja
                + "\nVersão: " + versao + "\nCriado por: " + autor + "\n");
    }


}
