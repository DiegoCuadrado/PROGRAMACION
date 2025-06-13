package gui;

import modelo.ProductoOtaku;
import modelo.ProductoDAO;
import servicio.LlmService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AkihabaraGUI extends JFrame {
    private ProductoDAO dao;
    private LlmService llm;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public AkihabaraGUI() {
        dao = new ProductoDAO();
        llm = new LlmService();

        setTitle("Akihabara Market");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 10, 10));

        JButton btnVerTodos = new JButton("Ver Todos");
        JButton btnAgregar = new JButton("Agregar");
        JButton btnBuscar = new JButton("Buscar por ID");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnDescripcionIA = new JButton("Descripción IA");
        JButton btnCategoriaIA = new JButton("Sugerir Categoría");
        JButton btnSalir = new JButton("Salir");

        // Añadir botones al panel
        panelBotones.add(btnVerTodos);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnDescripcionIA);
        panelBotones.add(btnCategoriaIA);
        panelBotones.add(btnSalir);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Categoría", "Precio", "Stock"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        panelPrincipal.add(panelBotones, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        add(panelPrincipal);
        setVisible(true);

        // Eventos
        btnVerTodos.addActionListener(e -> cargarProductos());
        btnAgregar.addActionListener(e -> mostrarFormularioAgregar());
        btnBuscar.addActionListener(e -> buscarPorId());
        btnActualizar.addActionListener(e -> actualizarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnDescripcionIA.addActionListener(e -> generarDescripcionIA());
        btnCategoriaIA.addActionListener(e -> sugerirCategoriaIA());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void cargarProductos() {
        modeloTabla.setRowCount(0);
        List<ProductoOtaku> lista = dao.obtenerTodosLosProductos();
        for (ProductoOtaku p : lista) {
            modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock()});
        }
    }

    private void mostrarFormularioAgregar() {
        JTextField nombre = new JTextField();
        JTextField categoria = new JTextField();
        JTextField precio = new JTextField();
        JTextField stock = new JTextField();

        Object[] campos = {
                "Nombre:", nombre,
                "Categoría:", categoria,
                "Precio:", precio,
                "Stock:", stock
        };

        int res = JOptionPane.showConfirmDialog(null, campos, "Agregar Producto", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            try {
                ProductoOtaku p = new ProductoOtaku(nombre.getText(), categoria.getText(),
                        Double.parseDouble(precio.getText()), Integer.parseInt(stock.getText()));
                dao.agregarProducto(p);
                cargarProductos();
                JOptionPane.showMessageDialog(this, "Producto agregado.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al agregar producto: " + e.getMessage());
            }
        }
    }

    private void buscarPorId() {
        String idStr = JOptionPane.showInputDialog("Introduce ID:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                ProductoOtaku p = dao.obtenerProductoPorId(id);
                if (p != null) {
                    JOptionPane.showMessageDialog(this, p.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }

    private void actualizarProducto() {
        String idStr = JOptionPane.showInputDialog("ID del producto a actualizar:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                ProductoOtaku existente = dao.obtenerProductoPorId(id);
                if (existente == null) {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                    return;
                }

                JTextField nombre = new JTextField(existente.getNombre());
                JTextField categoria = new JTextField(existente.getCategoria());
                JTextField precio = new JTextField(String.valueOf(existente.getPrecio()));
                JTextField stock = new JTextField(String.valueOf(existente.getStock()));

                Object[] campos = {
                        "Nombre:", nombre,
                        "Categoría:", categoria,
                        "Precio:", precio,
                        "Stock:", stock
                };

                int res = JOptionPane.showConfirmDialog(null, campos, "Actualizar Producto", JOptionPane.OK_CANCEL_OPTION);
                if (res == JOptionPane.OK_OPTION) {
                    ProductoOtaku actualizado = new ProductoOtaku(id, nombre.getText(), categoria.getText(),
                            Double.parseDouble(precio.getText()), Integer.parseInt(stock.getText()));
                    dao.actualizarProducto(actualizado);
                    cargarProductos();
                    JOptionPane.showMessageDialog(this, "Producto actualizado.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al actualizar.");
            }
        }
    }

    private void eliminarProducto() {
        String idStr = JOptionPane.showInputDialog("ID del producto a eliminar:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                boolean eliminado = dao.eliminarProducto(id);
                if (eliminado) {
                    cargarProductos();
                    JOptionPane.showMessageDialog(this, "Producto eliminado.");
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        }
    }

    private void generarDescripcionIA() {
        String idStr = JOptionPane.showInputDialog("ID del producto para describir:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                ProductoOtaku p = dao.obtenerProductoPorId(id);
                if (p != null) {
                    String prompt = "Genera una descripción de marketing para el producto otaku: "
                            + p.getNombre() + " de la categoría " + p.getCategoria() + ".";
                    String respuesta = llm.preguntarLLM(prompt);
                    JOptionPane.showMessageDialog(this, "Descripción IA:\n" + respuesta);
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error con el LLM.");
            }
        }
    }

    private void sugerirCategoriaIA() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        if (nombre != null && !nombre.isEmpty()) {
            String prompt = "Para un producto otaku llamado '" + nombre +
                    "', sugiere una categoría adecuada de esta lista: Figura, Manga, Póster, Llavero, Ropa, Videojuego, Otro.";
            try {
            	String respuesta = llm.preguntarLLM(prompt);
            	JOptionPane.showMessageDialog(this, "Sugerencia IA: " + respuesta);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error con el LLM.");
            }
        }
    }
}

