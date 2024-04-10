package entidades;

public class automatizacion_procesos_clave 
{
    private int id_automatizacion;
    private int id_usuario;
    private String fecha_automatizacion;
    private String datos_automatizados;

    public automatizacion_procesos_clave(int id_automatizacion, int id_usuario, String fecha_automatizacion, String datos_automatizados) {
        this.id_automatizacion = id_automatizacion;
        this.id_usuario = id_usuario;
        this.fecha_automatizacion = fecha_automatizacion;
        this.datos_automatizados = datos_automatizados;
    }

    public automatizacion_procesos_clave() {
    }

    public int getId_automatizacion() {
        return id_automatizacion;
    }

    public void setId_automatizacion(int id_automatizacion) {
        this.id_automatizacion = id_automatizacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_automatizacion() {
        return fecha_automatizacion;
    }

    public void setFecha_automatizacion(String fecha_automatizacion) {
        this.fecha_automatizacion = fecha_automatizacion;
    }

    public String getDatos_automatizados() {
        return datos_automatizados;
    }

    public void setDatos_automatizados(String datos_automatizados) {
        this.datos_automatizados = datos_automatizados;
    }
}