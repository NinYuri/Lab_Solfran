package entidades;

public class verificacion_cumplimiento_normativo 
{
    private int id_verificacion;
    private int id_usuario;
    private String fecha_verificacion;
    private String datos_verificados;

    public verificacion_cumplimiento_normativo(int id_verificacion, int id_usuario, String fecha_verificacion, String datos_verificados) {
        this.id_verificacion = id_verificacion;
        this.id_usuario = id_usuario;
        this.fecha_verificacion = fecha_verificacion;
        this.datos_verificados = datos_verificados;
    }

    public verificacion_cumplimiento_normativo() {
    }

    public int getId_verificacion() {
        return id_verificacion;
    }

    public void setId_verificacion(int id_verificacion) {
        this.id_verificacion = id_verificacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_verificacion() {
        return fecha_verificacion;
    }

    public void setFecha_verificacion(String fecha_verificacion) {
        this.fecha_verificacion = fecha_verificacion;
    }

    public String getDatos_verificados() {
        return datos_verificados;
    }

    public void setDatos_verificados(String datos_verificados) {
        this.datos_verificados = datos_verificados;
    }
}