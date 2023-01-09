
package tienda.entidades;

public class Producto {
    private Integer codigo;
    private String nombre;
    private double precio;
    private Fabricante codigo_fabricante;
    
    public Producto(){
        
    }

    public Producto(String nombre, double precio, Fabricante codigoFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigoFabricante;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Fabricante getCodigoFabricante() {
        return codigo_fabricante;
    }

    public void setCodigoFabricante(Fabricante codigoFabricante) {
        this.codigo_fabricante = codigoFabricante;
    }
    
    
    
    
}
