package datos.interfaces;

public interface CrudUsuarios<T>
{
    public boolean insertar(T obj);
    public boolean existe(String nombre, String apellido);
    public boolean comparar(String nombre, String apellido, String pass);
    public int id(String nombre, String apellido, String pass);
}
