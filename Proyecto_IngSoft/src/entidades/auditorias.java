package entidades;

public class auditorias 
{
    private int id_auditoria;
    private int id_usuario;
    private String fecha_auditoria;
    private String datos_consultados;

    public auditorias(int id_auditoria, int id_usuario, String fecha_auditoria, String datos_consultados) {
        this.id_auditoria = id_auditoria;
        this.id_usuario = id_usuario;
        this.fecha_auditoria = fecha_auditoria;
        this.datos_consultados = datos_consultados;
    }

    public auditorias() {
    }

    public int getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_auditoria() {
        return fecha_auditoria;
    }

    public void setFecha_auditoria(String fecha_auditoria) {
        this.fecha_auditoria = fecha_auditoria;
    }

    public String getDatos_consultados() {
        return datos_consultados;
    }

    public void setDatos_consultados(String datos_consultados) {
        this.datos_consultados = datos_consultados;
    }
}