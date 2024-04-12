package negocio;

import datos.inventarioDAO;
import entidades.control_inventario;

public class inventarioControl 
{
    private final inventarioDAO DATOS;
    private control_inventario obj;
    
    public inventarioControl()
    {
        DATOS = new inventarioDAO();
        obj = new control_inventario();
    }
    
    public String Insertar(int idUsuario, String fecha, String nombre, int cantidad, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_registro(fecha);
        obj.setNombre(nombre);
        obj.setCantidad(cantidad);
        obj.setDatos(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de inventario";
    }
}