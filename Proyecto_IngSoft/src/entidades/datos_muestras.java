package entidades;

public class datos_muestras 
{
    private int id_muestra;
    private int id_usuario;
    private String fecha_ingreso;
    private String fecha;
    private String hora;
    private boolean componente_extraño;
    private boolean contaminacion_cruzada;
    private float mg;
    private String datos;

    public datos_muestras(int id_muestra, int id_usuario, String fecha_ingreso, boolean componente_extraño, boolean contaminacion_cruzada, float mg, String datos) {
        this.id_muestra = id_muestra;
        this.id_usuario = id_usuario;
        this.fecha_ingreso = fecha_ingreso;
        this.componente_extraño = componente_extraño;
        this.contaminacion_cruzada = contaminacion_cruzada;
        this.mg = mg;
        this.datos = datos;
    }

    public datos_muestras(int id_muestra, int id_usuario, String fecha, String hora, boolean componente_extraño, boolean contaminacion_cruzada, float mg, String datos) {
        this.id_muestra = id_muestra;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.componente_extraño = componente_extraño;
        this.contaminacion_cruzada = contaminacion_cruzada;
        this.mg = mg;
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

    public boolean isComponente_extraño() {
        return componente_extraño;
    }

    public void setComponente_extraño(boolean componente_extraño) {
        this.componente_extraño = componente_extraño;
    }

    public boolean isContaminacion_cruzada() {
        return contaminacion_cruzada;
    }

    public void setContaminacion_cruzada(boolean contaminacion_cruzada) {
        this.contaminacion_cruzada = contaminacion_cruzada;
    }

    public float getMg() {
        return mg;
    }

    public void setMg(float mg) {
        this.mg = mg;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}