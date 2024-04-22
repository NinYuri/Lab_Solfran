package entidades;

public class accesos_remotos 
{
    private int id_acceso;
    private int id_usuario;
    private String fecha_solicitud;
    private String fecha;
    private String hora;
    private boolean autorizado;

    public accesos_remotos(int id_acceso, int id_usuario, String fecha_solicitud, boolean autorizado) {
        this.id_acceso = id_acceso;
        this.id_usuario = id_usuario;
        this.fecha_solicitud = fecha_solicitud;
        this.autorizado = autorizado;
    }

    public accesos_remotos(int id_acceso, int id_usuario, String fecha, String hora, boolean autorizado) {
        this.id_acceso = id_acceso;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.autorizado = autorizado;
    }

    public accesos_remotos() {
    }

    public int getId_acceso() {
        return id_acceso;
    }

    public void setId_acceso(int id_acceso) {
        this.id_acceso = id_acceso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
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

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}