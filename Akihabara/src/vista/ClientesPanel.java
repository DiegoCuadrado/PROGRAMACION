package vista;

import modelo.ClienteDAO;
import modelo.ClienteOtaku;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class ClientesPanel extends JPanel {
    private final ClienteDAO clienteDAO;
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;

    private final JTextField campoNombre = new JTextField(15);
    private final JTextField campoEmail = new JTextField(15);
    private final JTextField campoTelefono = new JTextField(10);

    public ClientesPanel(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;

        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Email", "Teléfono", "Registro"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        add(crearFormulario(), BorderLayout.SOUTH);
        cargarClientes();
    }

    private JPanel crearFormulario() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JPanel campos = new JPanel();
        campos.add(new JLabel("Nombre:"));
        campos.add(campoNombre);
        campos.add(new JLabel("Email:"));
        campos.add(campoEmail);
        campos.add(new JLabel("Teléfono:"));
        campos.add(campoTelefono);
        panel.add(campos);

        JPanel botones = new JPanel();
        JButton botonAgregar = new JButton("Agregar");
        JButton botonActualizar = new JButton("Actualizar");
        JButton botonEliminar = new JButton("Eliminar");

        botones.add(botonAgregar);
        botones.add(botonActualizar);
        botones.add(botonEliminar);
        panel.add(botones);

        // Listeners
        botonAgregar.addActionListener(e -> agregarCliente());
        botonActualizar.addActionListener(e -> actualizarCliente());
        botonEliminar.addActionListener(e -> eliminarCliente());

        return panel;
    }

    private void cargarClientes() {
        modeloTabla.setRowCount(0);
        List<ClienteOtaku> clientes = clienteDAO.obtenerTodosLosClientes();
        for (ClienteOtaku c : clientes) {
            modeloTabla.addRow(new Object[]{
                c.getId(), c.getNombre(), c.getEmail(), c.getTelefono(), c.getFechaRegistro()
            });
        }
    }

    private void agregarCliente() {
        if (!validarCampos()) return;

        ClienteOtaku nuevo = new ClienteOtaku(
                campoNombre.getText(),
                campoEmail.getText(),
                campoTelefono.getText()
        );

        clienteDAO.agregarCliente(nuevo);
        limpiarCampos();
        cargarClientes();
    }

    private void actualizarCliente() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            mostrarError("Selecciona un cliente para actualizar.");
            return;
        }

        if (!validarCampos()) return;

        int id = (int) modeloTabla.getValueAt(fila, 0);

        ClienteOtaku actualizado = new ClienteOtaku(
                id,
                campoNombre.getText(),
                campoEmail.getText(),
                campoTelefono.getText(),
                LocalDate.parse(modeloTabla.getValueAt(fila, 4).toString()) // conserva la fecha original
        );

        clienteDAO.actualizarCliente(actualizado);
        limpiarCampos();
        cargarClientes();
    }

    private void eliminarCliente() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            mostrarError("Selecciona un cliente para eliminar.");
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        clienteDAO.eliminarCliente(id);
        limpiarCampos();
        cargarClientes();
    }

    private boolean validarCampos() {
        if (campoNombre.getText().isBlank() ||
            campoEmail.getText().isBlank() ||
            campoTelefono.getText().isBlank()) {
            mostrarError("Todos los campos deben estar completos.");
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoEmail.setText("");
        campoTelefono.setText("");
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

