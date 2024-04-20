package datos.interfaces;

import java.util.List;

public interface CrudUsuarios<T>
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean modificar(T obj);
    public boolean existe(String nombre, String apellido);
    public boolean comparar(String nombre, String apellido, String pass);
    public int id(String nombre, String apellido, String pass);
}
