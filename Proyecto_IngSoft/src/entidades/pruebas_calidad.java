package entidades;

public class pruebas_calidad 
{
    private int id_prueba;
    private int id_usuario;
    private int id_muestra;
    private String resultado;

    public pruebas_calidad(int id_prueba, int id_usuario, int id_muestra, String resultado) {
        this.id_prueba = id_prueba;
        this.id_usuario = id_usuario;
        this.id_muestra = id_muestra;
        this.resultado = resultado;
    }

    public pruebas_calidad() {
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_muestra() {
        return id_muestra;
    }

    public void setId_muestra(int id_muestra) {
        this.id_muestra = id_muestra;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}