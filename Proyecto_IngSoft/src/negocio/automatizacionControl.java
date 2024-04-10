package negocio;

import datos.automatizacionDAO;
import entidades.automatizacion_procesos_clave;

public class automatizacionControl 
{    
    private final automatizacionDAO DATOS;
    private automatizacion_procesos_clave obj;
    
    public automatizacionControl()
    {
        DATOS = new automatizacionDAO();
        obj = new automatizacion_procesos_clave();
    }
    
    public String Insertar(int id_usuario, String fecha, String datos)
    {
        obj.setId_usuario(id_usuario);
        obj.setFecha_automatizacion(fecha);
        obj.setDatos_automatizados(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la automatización";
    }
}