package pucpr.compras_v2.usuarios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtrar {
    public Cliente filtrarCpf(List<Cliente> clientes, String cpf) {
        return clientes.stream()
                .filter(cli -> cli.getCpf().equals(cpf))
                .toList()
                .get(0);
    }
}
