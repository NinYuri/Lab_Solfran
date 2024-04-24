package entidades;

public class monitoreo_produccion_distribucion 
{
    private int id_monitoreo;
    private int id_usuario;
    private String fecha_monitoreo;
    private String fecha;
    private String hora;
    private String datos;

    public monitoreo_produccion_distribucion(int id_monitoreo, int id_usuario, String fecha_monitoreo, String datos) {
        this.id_monitoreo = id_monitoreo;
        this.id_usuario = id_usuario;
        this.fecha_monitoreo = fecha_monitoreo;
        this.datos = datos;
    }

    public monitoreo_produccion_distribucion(int id_monitoreo, int id_usuario, String fecha, String hora, String datos) {
        this.id_monitoreo = id_monitoreo;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.datos = datos;
    }

    public monitoreo_produccion_distribucion() {
    }

    public int getId_monitoreo() {
        return id_monitoreo;
    }

    public void setId_monitoreo(int id_monitoreo) {
        this.id_monitoreo = id_monitoreo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_monitoreo() {
        return fecha_monitoreo;
    }

    public void setFecha_monitoreo(String fecha_monitoreo) {
        this.fecha_monitoreo = fecha_monitoreo;
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

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}