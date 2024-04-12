package negocio;

import datos.muestrasDAO;
import entidades.datos_muestras;

public class muestrasControl 
{
    private final muestrasDAO DATOS;
    private datos_muestras obj;
    
    public muestrasControl()
    {
        DATOS = new muestrasDAO();
        obj = new datos_muestras();
    }
    
    public String Insertar(int idUsuario, String fecha, boolean componente, boolean cont, float mg, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_ingreso(fecha);
        obj.setComponente_extraño(componente);
        obj.setContaminacion_cruzada(cont);
        obj.setMg(mg);
        obj.setDatos(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Eror en la inserción de la muestra";
    }
}