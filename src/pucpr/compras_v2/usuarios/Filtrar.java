package pucpr.compras_v2.usuarios;

import java.util.List;

public class Filtrar {

    /**
     *
     * @param clientes
     * @param cpf
     * @return client matching given CPF
     */

    public Cliente filtrarCpf(List<Cliente> clientes, String cpf) throws NullPointerException{
        return clientes.stream()
                .filter(cli -> cli.getCpf().equals(cpf))
                .toList()
                .get(0);
    }
}
