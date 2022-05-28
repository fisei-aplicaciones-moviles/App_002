package fisei.uta.ec.Entidades;

public class Cliente {
    private int codigo;
    private String nombre;
    private String apellido;
    private double saldo;

    public Cliente(int codigo, String nombre, String apellido, double saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }

    public Cliente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
