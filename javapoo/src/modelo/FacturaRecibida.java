package modelo;

public class FacturaRecibida {

    // Atributos
    private int idFactura;
    private String proveedor;
    private String fechaEmision;
    private double montoTotal;

    // Constructor para crear una nueva factura (sin ID)
    public FacturaRecibida(String proveedor, String fechaEmision, double montoTotal) {
        this.proveedor = proveedor;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    // Constructor para crear una factura con ID (al obtener de la base de datos)
    public FacturaRecibida(int idFactura, String proveedor, String fechaEmision, double montoTotal) {
        this.idFactura = idFactura;
        this.proveedor = proveedor;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    // Getters y Setters

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    // Método toString para mostrar información de la factura
    @Override
    public String toString() {
        return "Factura ID: " + idFactura + ", Proveedor: " + proveedor + ", Fecha de Emisión: " + fechaEmision + ", Monto Total: " + montoTotal;
    }
}


