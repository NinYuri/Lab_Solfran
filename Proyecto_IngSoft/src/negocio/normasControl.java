package negocio;

import datos.normasDAO;
import entidades.verificacion_cumplimiento_normativo;

public class normasControl 
{
    private final normasDAO DATOS;
    private verificacion_cumplimiento_normativo obj;
    
    public normasControl() 
    {
        DATOS = new normasDAO();
        obj = new verificacion_cumplimiento_normativo();
    }
    
    public String Insertar(int idUsuario, String fecha, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_verificacion(fecha);
        obj.setDatos_verificados(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la norma";
    }
}