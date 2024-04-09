package negocio;

import datos.accesosDAO;
import entidades.accesos_remotos;

public class accesosControl 
{
    private final accesosDAO DATOS;
    private accesos_remotos obj;
    
    public accesosControl()
    {
        DATOS = new accesosDAO();
        obj = new accesos_remotos();
    }
    
    public String Insertar(int id_usuario, String fecha, boolean autorizado)
    {
        obj.setId_usuario(id_usuario);
        obj.setFecha_solicitud(fecha);
        obj.setAutorizado(autorizado);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción del acceso remoto";
    }
    
}