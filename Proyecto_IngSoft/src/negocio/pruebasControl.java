package negocio;

import datos.pruebasDAO;
import entidades.pruebas_calidad;

public class pruebasControl 
{
    private final pruebasDAO DATOS;
    private pruebas_calidad obj;
    
    public pruebasControl()
    {
        DATOS = new pruebasDAO();
        obj = new pruebas_calidad();
    }
    
    public String Insertar(int idUsuario, int idMuestra, String resultado)
    {
        obj.setId_usuario(idUsuario);
        obj.setId_muestra(idMuestra);
        obj.setResultado(resultado);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la prueba";
    }
    
}