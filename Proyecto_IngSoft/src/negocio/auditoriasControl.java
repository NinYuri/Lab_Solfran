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
    
    public String Insertar(int idUsuario, String fecha, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_auditoria(fecha);
        obj.setDatos_consultados(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la auditoría";
    }
}