package negocio;

import datos.auditoriasDAO;
import entidades.auditorias;

public class auditoriasControl 
{
    private final auditoriasDAO DATOS;
    private auditorias obj;
    
    public auditoriasControl()
    {
        DATOS = new auditoriasDAO();
        obj = new auditorias();
    }
    
    public String Insertar(int idUsuario, String fecha, String hallazgos, int conformidad, String acciones, String informe)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_auditoria(fecha);
        obj.setHallazgos(hallazgos);
        obj.setPorcentaje_conformidad(conformidad);
        obj.setAcciones_correctivas(acciones);
        obj.setInforme(informe);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la auditoría";
    }
}