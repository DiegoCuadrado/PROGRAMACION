package vista; 
import modelo.ClienteDAO;
import javax.swing.*;

public class TestClientesGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteDAO clienteDAO = new ClienteDAO();
            JFrame frame = new JFrame("Gestión de Clientes Otaku");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new ClientesPanel(clienteDAO));
            frame.setSize(700, 400);
            frame.setVisible(true);
        });
    }
}

