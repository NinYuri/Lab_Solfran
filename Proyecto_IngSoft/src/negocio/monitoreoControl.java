package negocio;

import datos.monitoreoDAO;
import entidades.monitoreo_produccion_distribucion;

public class monitoreoControl 
{
    private final monitoreoDAO DATOS;
    private monitoreo_produccion_distribucion obj;
    
    public monitoreoControl()
    {
        DATOS = new monitoreoDAO();
        obj = new monitoreo_produccion_distribucion();
    }
    
    public String Insertar(int idUsuario, String fecha, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_monitoreo(fecha);
        obj.setDatos(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción del informe de monitoreo";
    }
}