package modelo;

import java.util.Date;

public class Venta {
    private int idVenta;
    private int idCliente;
    private int idArticulo;
    private int cantidad;
    private Date fechaVenta;

    public Venta(int idVenta, int idCliente, int idArticulo, int cantidad, Date fechaVenta) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
    }

    // Getters
    public int getIdVenta() {
        return idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    // Setters
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public Articulo getArticulo(ArticuloDAO articuloDAO) {
        return articuloDAO.obtenerPorId(this.idArticulo);  // Devuelve el artículo asociado a la venta
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", idCliente=" + idCliente +
                ", idArticulo=" + idArticulo +
                ", cantidad=" + cantidad +
                ", fechaVenta=" + fechaVenta +
                '}';
    }
}




