package entidades;

public class datos_muestras 
{
    private int id_muestra;
    private int id_usuario;
    private String fecha_ingreso;
    private String datos;

    public datos_muestras(int id_muestra, int id_usuario, String fecha_ingreso, String datos) {
        this.id_muestra = id_muestra;
        this.id_usuario = id_usuario;
        this.fecha_ingreso = fecha_ingreso;
        this.datos = datos;
    }

    public datos_muestras() {
    }

    public int getId_muestra() {
        return id_muestra;
    }

    public void setId_muestra(int id_muestra) {
        this.id_muestra = id_muestra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}