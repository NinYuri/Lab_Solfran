package negocio;

import datos.usuariosDAO;
import entidades.usuarios;

public class usuariosControl 
{
    private final usuariosDAO DATOS;
    private usuarios obj;
    
    public usuariosControl()
    {
        DATOS = new usuariosDAO();
        obj = new usuarios();
    }
    
    public String Insertar(String nombre, String apellido, String correo, String contrasena, String rol)
    {
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setCorreo(correo);
        obj.setContrasena(contrasena);
        obj.setRol(rol);
            
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción del " + rol;
    }
    
    public boolean Existe(String nombre, String apellido)
    {
        if(DATOS.existe(nombre, apellido))
            return true;
        else
            return false;
    }
}
