package entidades;

public class auditorias 
{
    private int id_auditoria;
    private int id_usuario;
    private String fecha_auditoria;
    private String fecha;
    private String hora;
    private String hallazgos;
    private int porcentaje_conformidad;
    private String acciones_correctivas;
    private String informe;

    public auditorias(int id_auditoria, int id_usuario, String fecha_auditoria, String hallazgos, int porcentaje_conformidad, String acciones_correctivas, String informe) {
        this.id_auditoria = id_auditoria;
        this.id_usuario = id_usuario;
        this.fecha_auditoria = fecha_auditoria;
        this.hallazgos = hallazgos;
        this.porcentaje_conformidad = porcentaje_conformidad;
        this.acciones_correctivas = acciones_correctivas;
        this.informe = informe;
    }  

    public auditorias(int id_auditoria, int id_usuario, String fecha, String hora, String hallazgos, int porcentaje_conformidad, String acciones_correctivas, String informe) {
        this.id_auditoria = id_auditoria;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.hallazgos = hallazgos;
        this.porcentaje_conformidad = porcentaje_conformidad;
        this.acciones_correctivas = acciones_correctivas;
        this.informe = informe;
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
    
    public String getHallazgos() {
        return hallazgos;
    }

    public void setHallazgos(String hallazgos) {
        this.hallazgos = hallazgos;
    }

    public int getPorcentaje_conformidad() {
        return porcentaje_conformidad;
    }

    public void setPorcentaje_conformidad(int porcentaje_conformidad) {
        this.porcentaje_conformidad = porcentaje_conformidad;
    }

    public String getAcciones_correctivas() {
        return acciones_correctivas;
    }

    public void setAcciones_correctivas(String acciones_correctivas) {
        this.acciones_correctivas = acciones_correctivas;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }    
}