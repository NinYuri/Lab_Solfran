package entidades;

public class control_inventario 
{
    private int id_inventario;
    private int id_usuario;
    private String fecha_registro;
    private String fecha;
    private String hora;
    private String nombre;
    private int cantidad;
    private String datos;

    public control_inventario(int id_inventario, int id_usuario, String fecha_registro, String nombre, int cantidad, String datos) {
        this.id_inventario = id_inventario;
        this.id_usuario = id_usuario;
        this.fecha_registro = fecha_registro;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.datos = datos;
    }

    public control_inventario(int id_inventario, int id_usuario, String fecha, String hora, String nombre, int cantidad, String datos) {
        this.id_inventario = id_inventario;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.datos = datos;
    }

    public control_inventario() {
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}