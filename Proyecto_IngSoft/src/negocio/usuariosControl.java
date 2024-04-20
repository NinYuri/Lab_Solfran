package negocio;

import datos.usuariosDAO;
import entidades.usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class usuariosControl 
{
    private final usuariosDAO DATOS;
    private usuarios obj;
    private DefaultTableModel modeloTabla;
    
    public usuariosControl()
    {
        DATOS = new usuariosDAO();
        obj = new usuarios();
    }
    
    public DefaultTableModel Listar()
    {
        List<usuarios> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos  = {"ID", "Nombre", "Correo", "Rol"};
        String[] registro = new String[4];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(usuarios item:lista)
        {
            registro[0] = String.valueOf(item.getId_usuario());
            registro[1] = item.getNombre() + " " + item.getApellido();
            registro[2] = item.getCorreo();
            registro[3] = item.getRol();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
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
    
    public String Modificar(int id, String nombre, String apellido, String correo, String rol)
    {
        obj.setId_usuario(id);
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setCorreo(correo);
        obj.setRol(rol);
        
        if(DATOS.modificar(obj))
            return "OK";
        else
            return "Error en la actualización";
    }
    
    public boolean Existe(String nombre, String apellido)
    {
        if(DATOS.existe(nombre, apellido))
            return true;
        else
            return false;
    }
    
    public boolean Comparar(String nombre, String apellido, String password)
    {
        if(DATOS.comparar(nombre, apellido, password))
            return true;
        else
            return false;
    }
    
    public String getRol(String nombre, String apellido, String password)
    {
        if(DATOS.existe(nombre, apellido))
            return DATOS.rol(nombre, apellido, password);
        else
            return "";
    }
    
    public int getID(String nombre, String apellido, String password)
    {
        if(DATOS.existe(nombre, apellido))
            return DATOS.id(nombre, apellido, password);
        else
            return 0;
    }
    
    public String getNombre(int id)
    {
        return DATOS.nombre(id);
    }
    
    public String getApellido(int id)
    {
        return DATOS.apellido(id);
    }
}
