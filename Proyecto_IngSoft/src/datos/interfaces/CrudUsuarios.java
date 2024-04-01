package datos.interfaces;

public interface CrudUsuarios<T>
{
    public boolean insertar(T obj);
    public boolean existe(String nombre, String apellido);
}
