package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteDAO {
    private final List<ClienteOtaku> clientes = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public void agregarCliente(ClienteOtaku cliente) {
        cliente.setId(idGenerator.getAndIncrement());
        clientes.add(cliente);
    }

    public ClienteOtaku obtenerClientePorId(int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean actualizarCliente(ClienteOtaku actualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == actualizado.getId()) {
                clientes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCliente(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }

    public List<ClienteOtaku> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }
}


